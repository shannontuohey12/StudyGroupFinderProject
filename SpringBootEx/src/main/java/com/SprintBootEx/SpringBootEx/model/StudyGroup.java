package com.SprintBootEx.SpringBootEx.model;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "study_group")
public class StudyGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String subject;
    private String date;
    private String time;

    @ManyToMany(mappedBy = "groups")
    private List<User> users = new ArrayList<>();

    public StudyGroup() {}

    public StudyGroup(String title, String subject, String date, String time) {
        this.title = title;
        this.subject = subject;
        this.date = date;
        this.time = time;
    }

    // Getters and setters     

    public List<User> getUsers() {
        return users;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }
}  