package com.csye6225.demo.controllers;

/**
 * <Rishabh Jain>, <001226719>, <jain.rish@husky.neu.edu>
 **/

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.InstanceProfileCredentialsProvider;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.PublishResult;
import com.csye6225.demo.domain.Person;
import com.csye6225.demo.service.UserService;
import com.google.gson.JsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.Charset;
import java.util.Base64;
import java.util.Date;

@Controller
public class PersonController {

  private final static Logger logger = LoggerFactory.getLogger(PersonController.class);

  @Autowired
  private UserService userService;

  @RequestMapping(value="/user/register", method = RequestMethod.POST)
  @ResponseBody
  public String Register(@RequestBody Person person) {
    JsonObject jsonObject = new JsonObject();
    Person person1 = userService.findUserByEmail(person.getEmail());
    if(person1!=null){
      jsonObject.addProperty("message", "user already exists");
    }
    else {
      userService.saveUser(person);
      jsonObject.addProperty("message", "user saved successfully");
      jsonObject.addProperty("email", person.getEmail());
      jsonObject.addProperty("password", person.getPassword());
    }
    return jsonObject.toString();
  }

  @RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
  @ResponseBody
  public String welcome(HttpServletRequest request, HttpServletResponse response) {
    String authorization = request.getHeader("Authorization");
    JsonObject jsonObject = new JsonObject();
    if (authorization != null && authorization.startsWith("Basic")) {
      // Authorization: Basic base64credentials
      BCryptPasswordEncoder decodePassword=new BCryptPasswordEncoder();
      String base64Credentials = authorization.substring("Basic".length()).trim();
      String credentials = new String(Base64.getDecoder().decode(base64Credentials),
              Charset.forName("UTF-8"));
      // credentials = username:password
      final String[] values = credentials.split(":", 2);
      Person person = userService.findUserByEmail(values[0]);
      if (person != null) {
        if (decodePassword.matches(values[1], person.getPassword()) || values[1].equals(person.getPassword())) {
          request.getSession().setAttribute("person",person);
          jsonObject.addProperty("message", "you are logged in. current time is " + new Date().toString());
        } else {
          jsonObject.addProperty("message", "unauthorized");
        }
      } else {
        jsonObject.addProperty("message", "you are not logged in!!!");
      }


    } else {
      jsonObject.addProperty("message", "you are not logged in!!!");
    }

    return jsonObject.toString();
  }

  @RequestMapping(value = "/logout", method = RequestMethod.GET, produces = "application/json")
  @ResponseBody
  public String logout(HttpServletRequest request){
    request.getSession().invalidate();
    JsonObject jsonObject = new JsonObject();
    jsonObject.addProperty("message", "Logged out successfully!!!");
    return jsonObject.toString();
  }

  @RequestMapping(value = "/reset-password", method = RequestMethod.POST, produces = "application/json")
  @ResponseBody
  public String resetPassword(@RequestBody Person person,HttpServletResponse response) {
    JsonObject jsonObject = new JsonObject();
    Person person1 = userService.findUserByEmail(person.getEmail());
    if(person!=null && person1!=null){

      AmazonSNS snsClient= AmazonSNSClientBuilder.standard().withCredentials(new InstanceProfileCredentialsProvider(false)).build();

      String topicArn= snsClient.createTopic("password_reset").getTopicArn();
      PublishRequest publishRequest = new PublishRequest(topicArn, person.getEmail());
      PublishResult publishResult = snsClient.publish(publishRequest);

      System.out.println("Password reset message sent!");
    }
    response.setStatus(HttpServletResponse.SC_OK);
    return jsonObject.toString();

  }
}
