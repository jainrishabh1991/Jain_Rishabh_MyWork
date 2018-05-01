package com.csye6225.demo.service;

/**
 * <Rishabh Jain>, <001226719>, <jain.rish@husky.neu.edu>
 **/

import com.csye6225.demo.domain.Person;
import com.csye6225.demo.domain.Task;
import com.csye6225.demo.repository.PersonRepository;
import com.csye6225.demo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("taskService")
public class TaskServiceImplementation implements TaskService{

    @Autowired
    @Qualifier("taskRepository")
    private TaskRepository taskRepository;



    @Override
    public Task findTaskById(String taskId) {
        return taskRepository.findByTaskId(taskId);
    }

    @Override
    public void saveTask(Task task,Person person) {
       task.setDescription(task.getDescription());
        task.setPerson(person);
       taskRepository.save(task);
    }

    @Override
    public List<Task> findAllTaskByPersonId(Long personId) {
        return taskRepository.findAllTaskByPerson_Id(personId);
    }

    @Override
    public void deleteTaskById(String id) {
        taskRepository.delete(id);
    }

}
