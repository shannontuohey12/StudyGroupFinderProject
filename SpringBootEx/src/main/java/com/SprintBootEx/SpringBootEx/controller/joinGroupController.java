package com.SprintBootEx.SpringBootEx.controller;

import com.SprintBootEx.SpringBootEx.factory.ConcreteStudyGroupFactory;
import com.SprintBootEx.SpringBootEx.factory.StudyGroupFactory;
import com.SprintBootEx.SpringBootEx.model.StudyGroup;
import com.SprintBootEx.SpringBootEx.repository.StudyGroupRepository;
import com.SprintBootEx.SpringBootEx.service.StudyGroupService;
import com.SprintBootEx.SpringBootEx.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/groups")
@CrossOrigin(origins = "*")
public class joinGroupController {

    @Autowired
    private StudyGroupService service;

    @Autowired
    private UserService userService;

    @Autowired
    private StudyGroupService groupService;

    @Autowired
    private StudyGroupRepository StudyGroupRepository;

    private final StudyGroupFactory factory = new ConcreteStudyGroupFactory();

    @PostMapping("/groups")
    public StudyGroup createGroup(@RequestBody StudyGroup group) {
        // Use the factory to create a StudyGroup
        StudyGroup newGroup = factory.createStudyGroup(group.getTitle(), group.getSubject());
        return StudyGroupRepository.save(newGroup);
    }

    @GetMapping("/users/{userId}/groups")
    public List<StudyGroup> getUserGroups(@PathVariable Long userId) {
        return userService.getUserGroups(userId);
    }

    @DeleteMapping("/groups/{groupId}")
    public void deleteGroup(@PathVariable Long groupId) {
        groupService.deleteGroup(groupId);
    }

    @PostMapping("/{groupId}/join/{userId}")
    public StudyGroup joinGroup(
        @PathVariable Long groupId,
        @PathVariable Long userId
    ) {
        return service.joinGroup(groupId, userId);
    }
}