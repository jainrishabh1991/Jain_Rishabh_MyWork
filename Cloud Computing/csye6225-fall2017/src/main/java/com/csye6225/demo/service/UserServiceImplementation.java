package com.csye6225.demo.service;

/**
 * <Rishabh Jain>, <001226719>, <jain.rish@husky.neu.edu>
 **/

import com.csye6225.demo.domain.Person;
import com.csye6225.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImplementation implements UserService{

    @Autowired
    @Qualifier("personRepository")
    private PersonRepository personRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public Person findUserByEmail(String email) {
        return personRepository.findByEmail(email);
    }

    @Override
    public void saveUser(Person user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setName(user.getEmail());
        System.out.println(user.getEmail());
        personRepository.save(user);
    }
}
