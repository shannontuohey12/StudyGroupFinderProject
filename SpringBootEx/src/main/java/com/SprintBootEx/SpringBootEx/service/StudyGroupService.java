package com.SprintBootEx.SpringBootEx.service;

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

    public StudyGroup joinGroup(Long groupId, Long userId) {
        System.out.println("Joining group " + groupId + " with user " + userId);

        StudyGroup group = groupRepo.findById(groupId).orElseThrow();
        User user = userRepo.findById(userId).orElseThrow();

        group.getUsers().add(user);
        user.getGroups().add(group);

        System.out.println("User " + userId + " joined group " + groupId);
        return groupRepo.save(group);
    }

    public StudyGroup createGroup(StudyGroup group) {
        return groupRepo.save(group);
    }

    public List<StudyGroup> getAllGroups() {
        return groupRepo.findAll();
    }

    public void deleteGroup(Long groupId) {
    groupRepo.deleteById(groupId);
}
}