package com.SprintBootEx.SpringBootEx.service;

import com.SprintBootEx.SpringBootEx.factory.StudyGroupFactory;
import com.SprintBootEx.SpringBootEx.model.*;
import com.SprintBootEx.SpringBootEx.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudyGroupService {

    @Autowired
    private StudyGroupRepository groupRepo;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private StudyGroupFactory groupFactory;

    public StudyGroup joinGroup(Long groupId, Long userId) {
        System.out.println("Joining group " + groupId + " with user " + userId);

        StudyGroup group = groupRepo.findById(groupId).orElseThrow();
        User user = userRepo.findById(userId).orElseThrow();

        if (!group.getUsers().contains(user)) {
            group.getUsers().add(user);
        }

        if (!user.getGroups().contains(group)) {
            user.getGroups().add(group);
        }

        System.out.println("User " + userId + " joined group " + groupId);
        return groupRepo.save(group);
    }

    public StudyGroup createGroup(StudyGroup group){
        System.out.println("Creating group with title: " + group.getTitle());
        StudyGroup newGroup = groupFactory.createStudyGroup(
            group.getTitle(), 
            group.getSubject(), 
            group.getDate(), 
            group.getTime()
        );
        return groupRepo.save(newGroup);
    }


    public List<StudyGroup> getAllGroups() {
        return groupRepo.findAll();
    }

    public void deleteGroup(Long groupId) {
        groupRepo.deleteById(groupId);
    }

    
}