package com.csye6225.demo.controllers;

import com.csye6225.demo.domain.Person;
import com.csye6225.demo.domain.Task;
import com.csye6225.demo.service.TaskService;
import com.csye6225.demo.service.UserService;
import com.google.gson.JsonObject;
import org.apache.catalina.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.nio.charset.Charset;
import java.util.Base64;

@Controller
public class TaskController {

    private final static Logger logger = LoggerFactory.getLogger(TaskController.class);

    @Autowired
    TaskService taskService;

    @Autowired
    private UserService userService;

    @RequestMapping(value="/tasks", method = RequestMethod.POST,produces = "application/json")
    @ResponseBody
    public String CreateTask(@RequestBody Task task,HttpServletRequest request  ,HttpServletResponse response) {
        String authorization = request.getHeader("Authorization");
        JsonObject jsonObject = new JsonObject();

        if (authorization != null && authorization.startsWith("Basic")) {
            // Authorization: Basic base64credentials
            BCryptPasswordEncoder decodePassword = new BCryptPasswordEncoder();
            String base64Credentials = authorization.substring("Basic".length()).trim();
            String credentials = new String(Base64.getDecoder().decode(base64Credentials),
                    Charset.forName("UTF-8"));
            // credentials = username:password
            final String[] values = credentials.split(":", 2);
            Person person = userService.findUserByEmail(values[0]);
            if (person != null) {
                if (decodePassword.matches(values[1], person.getPassword()) || values[1].equals(person.getPassword())) {
                    if(task.getDescription().length()>4096){
                        jsonObject.addProperty("message", "Description too long");
                        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                        response.setContentType(org.apache.http.entity.ContentType.APPLICATION_JSON.getMimeType());
                        return jsonObject.toString();
                    }
                    else {
                        taskService.saveTask(task, person);
                        jsonObject.addProperty("taskId",task.getTaskId());
                        jsonObject.addProperty("taskDescription",task.getDescription());
                        response.setStatus(HttpServletResponse.SC_CREATED);
                        response.setContentType(org.apache.http.entity.ContentType.APPLICATION_JSON.getMimeType());
                        return jsonObject.toString();
                    }
                } else {
                    response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                    jsonObject.addProperty("message", "Incorrect passsword");
                    response.setContentType(org.apache.http.entity.ContentType.APPLICATION_JSON.getMimeType());
                    return jsonObject.toString();
                }
            } else {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                jsonObject.addProperty("message", "Email does not exist");
                response.setContentType(org.apache.http.entity.ContentType.APPLICATION_JSON.getMimeType());
                return jsonObject.toString();
            }
        }
        else {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            jsonObject.addProperty("message","Incorrect authorization request");
            response.setContentType(org.apache.http.entity.ContentType.APPLICATION_JSON.getMimeType());
            return jsonObject.toString();
        }

    }


    @RequestMapping(value = "/tasks/{id}", method = RequestMethod.PUT,produces = "application/json")
    @ResponseBody
    public String updateTask(@PathVariable("id") String id, @RequestBody Task task, HttpServletRequest request, HttpServletResponse response) {
        logger.info("Updating Task with id {}", id);

        String authorization = request.getHeader("Authorization");
        JsonObject jsonObject = new JsonObject();

        if (authorization != null && authorization.startsWith("Basic")) {
            // Authorization: Basic base64credentials
            BCryptPasswordEncoder decodePassword = new BCryptPasswordEncoder();
            String base64Credentials = authorization.substring("Basic".length()).trim();
            String credentials = new String(Base64.getDecoder().decode(base64Credentials),
                    Charset.forName("UTF-8"));
            final String[] values = credentials.split(":", 2);
            Person person = userService.findUserByEmail(values[0]);
            if (person != null) {
                if (decodePassword.matches(values[1], person.getPassword()) || values[1].equals(person.getPassword())) {
                    Task currentTask = taskService.findTaskById(id);
                    if (currentTask == null || !currentTask.getPerson().getId().equals(person.getId()) || task.getDescription().length()>4096) {
                        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                        jsonObject.addProperty("message", "Unable to update");
                        return jsonObject.toString();
                    } else {
                        currentTask.setDescription(task.getDescription());
                        taskService.saveTask(currentTask, person);
                        response.setStatus(HttpServletResponse.SC_OK);
                        jsonObject.addProperty("taskId",currentTask.getTaskId());
                        jsonObject.addProperty("taskDescription",task.getDescription());
                        return jsonObject.toString();
                    }

                } else {
                    response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                    jsonObject.addProperty("message", "Incorrect passsword");
                    response.setContentType(org.apache.http.entity.ContentType.APPLICATION_JSON.getMimeType());
                    return jsonObject.toString();
                }
            } else {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                jsonObject.addProperty("message", "Email does not exist");
                response.setContentType(org.apache.http.entity.ContentType.APPLICATION_JSON.getMimeType());
                return jsonObject.toString();
            }

        }
        else {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            jsonObject.addProperty("message","Incorrect authorization request");
            response.setContentType(org.apache.http.entity.ContentType.APPLICATION_JSON.getMimeType());
            return jsonObject.toString();
        }


    }

    @RequestMapping(value = "/tasks/{id}", method = RequestMethod.DELETE,produces = "application/json")
    @ResponseBody
    public String deleteUser(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) {

        logger.info("Fetching & Deleting Task with id {}", id);

        String authorization = request.getHeader("Authorization");
        JsonObject jsonObject = new JsonObject();

        if (authorization != null && authorization.startsWith("Basic")) {
            // Authorization: Basic base64credentials
            BCryptPasswordEncoder decodePassword = new BCryptPasswordEncoder();
            String base64Credentials = authorization.substring("Basic".length()).trim();
            String credentials = new String(Base64.getDecoder().decode(base64Credentials),
                    Charset.forName("UTF-8"));
            final String[] values = credentials.split(":", 2);
            Person person = userService.findUserByEmail(values[0]);
            if (person != null) {
                if (decodePassword.matches(values[1], person.getPassword()) || values[1].equals(person.getPassword())) {
                    Task currentTask = taskService.findTaskById(id);
                    if (currentTask == null || !currentTask.getPerson().getId().equals(person.getId())) {
                        logger.error("Unable to update. Task with id {} not found.", id);
                        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                        jsonObject.addProperty("message", "Unable to update. Task not found.");
                        response.setContentType(org.apache.http.entity.ContentType.APPLICATION_JSON.getMimeType());
                        return jsonObject.toString();
                    } else {
                        taskService.deleteTaskById(id);
                        response.setStatus(HttpServletResponse.SC_NO_CONTENT);
                        jsonObject.addProperty("message", "Updated Task.");
                        response.setContentType(org.apache.http.entity.ContentType.APPLICATION_JSON.getMimeType());
                        return jsonObject.toString();
                    }

                } else {
                    response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                    jsonObject.addProperty("message", "Incorrect passsword");
                    response.setContentType(org.apache.http.entity.ContentType.APPLICATION_JSON.getMimeType());
                    return jsonObject.toString();
                }
            } else {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                jsonObject.addProperty("message", "Email does not exist");
                response.setContentType(org.apache.http.entity.ContentType.APPLICATION_JSON.getMimeType());
                return jsonObject.toString();
            }

        } else {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            jsonObject.addProperty("message", "Incorrect authorization request");
            response.setContentType(org.apache.http.entity.ContentType.APPLICATION_JSON.getMimeType());
            return jsonObject.toString();
        }


    }

   
    

}
