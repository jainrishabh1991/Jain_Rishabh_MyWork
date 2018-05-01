package com.csye6225.demo.service;

/**
 * <Rishabh Jain>, <001226719>, <jain.rish@husky.neu.edu>
 **/

import com.csye6225.demo.domain.Person;

public interface UserService {
    public Person findUserByEmail(String email);
    public void saveUser(Person person);
}
