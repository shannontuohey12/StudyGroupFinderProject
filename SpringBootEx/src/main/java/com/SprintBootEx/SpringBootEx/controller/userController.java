package com.SprintBootEx.SpringBootEx.controller;

import com.SprintBootEx.SpringBootEx.model.User;
import com.SprintBootEx.SpringBootEx.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class userController {

    private final UserService userService;

    public userController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/login")
    public User login(@RequestBody User loginRequest) {
    return userService.login(loginRequest.getEmail(), loginRequest.getPassword());
}
    // Create user
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    // Get user by id
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    // Get all users
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
}
