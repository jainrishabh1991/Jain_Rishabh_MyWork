package com.csye6225.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

/**
 * <Rishabh Jain>, <001226719>, <jain.rish@husky.neu.edu>
 **/

@Entity
@Table(name = "person")
public class Person {

    @Override
    public String toString(){
        return this.email;
    }

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @JsonIgnore
    @OneToMany(mappedBy = "person", fetch = FetchType.EAGER)
    private Set<Task> tasklist;

    public Person(){

    }

    public Person(Person person){
        this.email=person.getEmail();
        this.password=person.getPassword();
        this.id=person.getId();
    }

    public Set<Task> getTasklist() {
        return tasklist;
    }

    public void setTasklist(Set<Task> tasklist) {
        this.tasklist = tasklist;
    }

    @Column(name = "email")

    private String email;

    @Column(name = "password")
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.email = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
