package com.SprintBootEx.SpringBootEx.model;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name = "app_users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String major;
    private String password;

    @ManyToMany
    @JsonIgnore
    private List<StudyGroup> groups = new ArrayList<>();

    public User() {}

    public User(String name, String email, String major) {
        this.name = name;
        this.email = email;
        this.major = major;
        this.password = "password"; // Default password for simplicity
    }

    // Getters and setters

    public List<StudyGroup> getGroups() {
        return groups;
    }

    public Long getId() {
        return id;  
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getMajor() {
        return major;
    }
    public void setMajor(String major) {
        this.major = major;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}