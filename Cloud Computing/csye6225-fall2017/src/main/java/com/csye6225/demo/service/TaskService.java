package com.csye6225.demo.service;

/**
 * <Rishabh Jain>, <001226719>, <jain.rish@husky.neu.edu>
 **/

import com.csye6225.demo.domain.Person;
import com.csye6225.demo.domain.Task;

import java.util.List;

public interface TaskService {
   // public Person findUserByEmail(String email);
    //public void saveUser(Person person);

    public Task findTaskById(String taskId);
    public void  saveTask(Task task,Person person);
    public List<Task> findAllTaskByPersonId(Long personId);
    public void deleteTaskById(String id);
}
