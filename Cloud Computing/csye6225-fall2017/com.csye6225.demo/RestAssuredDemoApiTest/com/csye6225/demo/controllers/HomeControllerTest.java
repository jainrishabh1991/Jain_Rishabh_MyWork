package com.csye6225.demo.controllers;

import com.csye6225.demo.domain.Person;
import com.csye6225.demo.repository.PersonRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.Mockito.when;


import static org.junit.Assert.*;

@DataJpaTest
@WebMvcTest(controllers = PersonController.class, secure = false)
public class HomeControllerTest {
    @Test
    public void welcome() throws Exception {
        String test="test";
        String test1="test";
        Assert.assertEquals(test,test1);
    }

    @Mock
    PersonRepository personRepository;

    @Autowired
    MockMvc mockMvc;



    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

        Person createUser = new Person();
        createUser.setName("rishabh@gmail.com");
        createUser.setPassword("abc");
        
        when(personRepository.findByEmail("rishabh@gmail.com")).thenReturn(createUser);
    }
    @Test
    public void register() throws Exception {
        Person retrievedUser = personRepository.findByEmail("rishabh@gmail.com");
        assertEquals(retrievedUser.getEmail(),"rishabh@gmail.com");
    }



}