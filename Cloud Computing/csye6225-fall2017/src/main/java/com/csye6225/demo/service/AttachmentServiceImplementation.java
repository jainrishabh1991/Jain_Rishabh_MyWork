package com.csye6225.demo.service;

/**
 * <Rishabh Jain>, <001226719>, <jain.rish@husky.neu.edu>
 **/

//import com.amazonaws.services.s3.AmazonS3Client;
//import com.amazonaws.services.s3.model.CannedAccessControlList;
//import com.amazonaws.services.s3.model.ObjectMetadata;
//import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.csye6225.demo.domain.Attachment;
import com.csye6225.demo.domain.Person;
import com.csye6225.demo.domain.Task;
import com.csye6225.demo.repository.AttachmentRepository;
import com.csye6225.demo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;


import java.io.File;
import java.util.List;

@Service("attachmentService")
public class AttachmentServiceImplementation implements AttachmentService{

    @Autowired
    @Qualifier("attachmentRepository")
    private AttachmentRepository attachmentRepository;

    @Autowired
    private AmazonS3 s3Client;



    @Override
    public Attachment findAttachmentById(String attachmentId) {
        return attachmentRepository.findByAttachmentId(attachmentId);
    }

    @Override
    public void saveAttachment(Attachment attachment, Task task) {
       attachment.setTask(task);
       attachmentRepository.save(attachment);
    }

    @Override
    public List<Attachment> findAllAttachmentByTaskId(String taskId){
        return attachmentRepository.findAllAttachmentByTask_TaskId(taskId);
    }

    @Override
    public void deleteAttachmentById(Attachment attachment){
        attachmentRepository.delete(attachment);
    }

    @Override
    public void saveFileToS3(String key, File fileToUpload, String bucketName) throws Exception {

        try{

            /* save file */
            s3Client.putObject(new PutObjectRequest(bucketName, key, fileToUpload));

        }
        catch(Exception ex){
            throw new Exception("An error occurred saving file to S3", ex);
        }
    }

    @Override
    public void deleteFileFromS3(String key, String bucketName) throws Exception{
        try{
            s3Client.deleteObject(new DeleteObjectRequest(bucketName, key));
        }
        catch(Exception ex){
            throw new Exception("An error occurred deleting file from S3", ex);
        }
    }
}
