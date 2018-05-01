package com.csye6225.demo.service;

/**
 * <Rishabh Jain>, <001226719>, <jain.rish@husky.neu.edu>
 **/

import com.csye6225.demo.domain.Attachment;
import com.csye6225.demo.domain.Person;
import com.csye6225.demo.domain.Task;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

public interface AttachmentService {
   // public Person findUserByEmail(String email);
    //public void saveUser(Person person);

    public Attachment findAttachmentById(String attachmentId);
    public void saveAttachment(Attachment attachment, Task task);
    public List<Attachment> findAllAttachmentByTaskId(String taskId);

    public void deleteAttachmentById(Attachment attachment);
    public void saveFileToS3(String key,File fileToUpload, String bucketName) throws Exception;
    public void deleteFileFromS3(String key, String bucketName)throws Exception;
}
