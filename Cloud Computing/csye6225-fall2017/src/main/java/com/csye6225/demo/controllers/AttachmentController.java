package com.csye6225.demo.controllers;

//import com.amazonaws.services.s3.AmazonS3Client;
//import com.amazonaws.services.s3.model.CannedAccessControlList;
//import com.amazonaws.services.s3.model.ObjectMetadata;
//import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.HttpMethod;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CreateBucketRequest;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import com.csye6225.demo.domain.Attachment;
import com.csye6225.demo.domain.Person;
import com.csye6225.demo.domain.Task;
import com.csye6225.demo.service.AttachmentService;
import com.csye6225.demo.service.TaskService;
import com.csye6225.demo.service.UserService;
import com.google.gson.JsonObject;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.time.Instant;
import java.util.Base64;
import java.util.Date;
import java.util.List;

@Controller
public class AttachmentController {

    private final static Logger logger = LoggerFactory.getLogger(AttachmentController.class);

//    @Autowired
//    private AmazonS3Client amazonS3Client;

    @Autowired
    AttachmentService attachmentService;

    @Autowired
    TaskService taskService;


    @Autowired
    private UserService userService;

    @Autowired
    private AmazonS3 s3Client;

    private static final String bucketName = "csye6225-fall2017-s31-file";

    @RequestMapping(value="/tasks/{id}/attachments", method = RequestMethod.POST,produces = "application/json",consumes = {"multipart/form-data"})
    @ResponseBody
    public String createAttachment(@PathVariable("id") String id, @RequestParam("file") MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws Exception {
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
                    List<Task> tasks=taskService.findAllTaskByPersonId(person.getId());
                    File local=null;
                    Attachment attachment=new Attachment();
                    Task task=taskService.findTaskById(id);
                    for(int i=0;i<tasks.size();i++){
                        if(tasks.get(i).getTaskId().equals(id)){
                            File path = new File(File.separator+"tmp"+File.separator+"cloud"+File.separator);
                            if (!path.exists())
                                path.mkdirs();
                            local=new File(path.getAbsoluteFile(),file.getOriginalFilename().split("\\.")[0]+"."+file.getOriginalFilename().split("\\.")[1]);
                            file.transferTo(local);
//                            attachment.setFilePath(local.getPath());
//                            attachment.setFileName(file.getOriginalFilename());
//                            File fileToUpload = new File(file.getOriginalFilename());
//                            fileToUpload.createNewFile();
//                            FileOutputStream fos = new FileOutputStream(fileToUpload);
//                            fos.write(file.getBytes());
//                            fos.close();
                            String key = Instant.now().getEpochSecond() + "_" + local.getName();
                            GeneratePresignedUrlRequest generatePresignedUrlRequest = new GeneratePresignedUrlRequest(bucketName, key);
                            generatePresignedUrlRequest.setMethod(HttpMethod.GET);
                            generatePresignedUrlRequest.setExpiration(DateTime.now().plusDays(4).toDate());

                            URL signedUrl = s3Client.generatePresignedUrl(generatePresignedUrlRequest);

                            attachment.setFilePath(signedUrl.toString());
                            attachment.setFileName(key);
                            if(!(s3Client.doesBucketExist(bucketName)))
                            {
                                // Note that CreateBucketRequest does not specify region. So bucket is
                                // created in the region specified in the client.
                                s3Client.createBucket(new CreateBucketRequest(
                                        bucketName));
                            }
                            attachmentService.saveFileToS3(key,local, bucketName);
                            attachmentService.saveAttachment(attachment,task);
                            response.setStatus(HttpServletResponse.SC_CREATED);
                            jsonObject.addProperty("id",attachment.getAttachmentId());
                            jsonObject.addProperty("url",attachment.getFilePath());
                            response.setContentType(org.apache.http.entity.ContentType.APPLICATION_JSON.getMimeType());
                            return jsonObject.toString();
                        }
                    }
                    response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                    jsonObject.addProperty("message","Cannot access the task specified");
                    response.setContentType(org.apache.http.entity.ContentType.APPLICATION_JSON.getMimeType());
                    return jsonObject.toString();
                } else {
                    response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                    jsonObject.addProperty("message","Incorrect passsword");
                    response.setContentType(org.apache.http.entity.ContentType.APPLICATION_JSON.getMimeType());
                    return jsonObject.toString();
                }
            } else {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                jsonObject.addProperty("message","Email does not exist");
                response.setContentType(org.apache.http.entity.ContentType.APPLICATION_JSON.getMimeType());
                return jsonObject.toString();
            }


        } else {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            jsonObject.addProperty("message","Incorrect authorization request");
            response.setContentType(org.apache.http.entity.ContentType.APPLICATION_JSON.getMimeType());
            return jsonObject.toString();
        }

    }

    @RequestMapping(value="/tasks/{id}/attachments", method = RequestMethod.GET,produces = "application/json")
    @ResponseBody
    public ResponseEntity<List<Attachment>> getAllAttachment(@PathVariable("id") String id, HttpServletRequest request,HttpServletResponse response) throws IOException {
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
                    List<Task> tasks=taskService.findAllTaskByPersonId(person.getId());
                    for(int i=0;i<tasks.size();i++){
                        if(tasks.get(i).getTaskId().equals(id)){
                            List<Attachment> attachmentList=attachmentService.findAllAttachmentByTaskId(id);
                            return new ResponseEntity<List<Attachment>>(attachmentList, HttpStatus.OK);
                        }
                    }
                    jsonObject.addProperty("message","Cannot access the task specified");
                    response.setContentType(org.apache.http.entity.ContentType.APPLICATION_JSON.getMimeType());
                    return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
                } else {
                    jsonObject.addProperty("message","Incorrect password");
                    response.setContentType(org.apache.http.entity.ContentType.APPLICATION_JSON.getMimeType());
                    return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
                }
            } else {
                jsonObject.addProperty("message","Email does not exist");
                response.setContentType(org.apache.http.entity.ContentType.APPLICATION_JSON.getMimeType());
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }


        } else {
            jsonObject.addProperty("message","Incorrect authorization request");
            response.setContentType(org.apache.http.entity.ContentType.APPLICATION_JSON.getMimeType());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @RequestMapping(value="/tasks/{id}/attachments/{idAttachments}", method = RequestMethod.DELETE,produces = "application/json")
    @ResponseBody
    public String deleteAttachment(@PathVariable("id") String id, @PathVariable("idAttachments") String attachmentId, HttpServletRequest request, HttpServletResponse response) throws Exception {
        String authorization = request.getHeader("Authorization");
        JsonObject jsonObject = new JsonObject();
        response.setContentType(org.apache.http.entity.ContentType.APPLICATION_JSON.getMimeType());
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
                    jsonObject.addProperty("message", "you are logged in. current time is " + new Date().toString());
                    List<Task> tasks=taskService.findAllTaskByPersonId(person.getId());
                    boolean flag=false;
                    for(int i=0;i<tasks.size();i++){

                        if(tasks.get(i).getTaskId().equals(id)){
                            flag=true;
                            List<Attachment> attachmentList=attachmentService.findAllAttachmentByTaskId(id);
                            for(int j=0;j<attachmentList.size();j++){
                                if(attachmentList.get(j).getAttachmentId().equals(attachmentId)){
                                    Attachment attachment=attachmentService.findAttachmentById(attachmentId);
                                    attachmentService.deleteFileFromS3(attachment.getFileName(),bucketName);
                                    attachmentService.deleteAttachmentById(attachment);
                                    System.out.println("test");
                                    jsonObject.addProperty("message","File deleted successfully");
                                    response.setContentType(org.apache.http.entity.ContentType.APPLICATION_JSON.getMimeType());
                                    response.setStatus(HttpServletResponse.SC_NO_CONTENT);
                                    return jsonObject.toString();
                                }
                            }
                        }
                    }
                    if(!flag){
                        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                        jsonObject.addProperty("message","Cannot access the attachment specified");
                        response.setContentType(org.apache.http.entity.ContentType.APPLICATION_JSON.getMimeType());
                        return jsonObject.toString();
                    }
                    else{
                        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                        jsonObject.addProperty("message","Cannot access the task specified");
                        response.setContentType(org.apache.http.entity.ContentType.APPLICATION_JSON.getMimeType());
                        return jsonObject.toString();
                    }

                } else {
                    response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                    jsonObject.addProperty("message","Incorrect passsword");
                    response.setContentType(org.apache.http.entity.ContentType.APPLICATION_JSON.getMimeType());
                    return jsonObject.toString();
                }
            } else {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                jsonObject.addProperty("message","Email does not exist");
                response.setContentType(org.apache.http.entity.ContentType.APPLICATION_JSON.getMimeType());
                return jsonObject.toString();
            }


        } else {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            jsonObject.addProperty("message","Incorrect authorization request");
            response.setContentType(org.apache.http.entity.ContentType.APPLICATION_JSON.getMimeType());
            return jsonObject.toString();
        }

    }
}
