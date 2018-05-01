package com.csye6225.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "task")
public class Task {

    @OneToOne
    @JoinColumn(name="person_FK")
    private Person person;

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "taskId",unique=true)
    private String taskId;

    @Column(name = "description")
    private String description;

    @JsonIgnore
    @OneToMany(mappedBy = "task", fetch = FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Attachment> attachmentlist;


    public List<Attachment> getAttachmentlist() {
        return attachmentlist;
    }

    public void setAttachmentlist(List<Attachment> attachmentlist) {
        this.attachmentlist = attachmentlist;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }
}
