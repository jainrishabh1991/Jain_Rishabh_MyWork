package com.csye6225.demo.repository;

/**
 * <Rishabh Jain>, <001226719>, <jain.rish@husky.neu.edu>
 **/

import com.csye6225.demo.domain.Attachment;
import com.csye6225.demo.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository("attachmentRepository")
@Transactional
public interface AttachmentRepository extends JpaRepository<Attachment,String> {
    //Person findByEmail(String email);
    Attachment findByAttachmentId(String attachmentId);
    List<Attachment> findAllAttachmentByTask_TaskId(String taskId);

}
