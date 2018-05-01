package com.csye6225.demo.repository;

/**
 * <Rishabh Jain>, <001226719>, <jain.rish@husky.neu.edu>
 **/

import com.csye6225.demo.domain.Attachment;
import com.csye6225.demo.domain.Person;
import com.csye6225.demo.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("taskRepository")
public interface TaskRepository extends JpaRepository<Task,String> {
    //Person findByEmail(String email);
    Task findByTaskId(String taskId);
    List<Task> findAllTaskByPerson_Id(Long personId);
}
