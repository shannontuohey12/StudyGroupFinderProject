package com.SprintBootEx.SpringBootEx.service;
import com.SprintBootEx.SpringBootEx.model.StudyGroup;
import com.SprintBootEx.SpringBootEx.model.User;
import com.SprintBootEx.SpringBootEx.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    public User createUser(User user) {
        return userRepo.save(user);
    }
    public User login(String email, String password) {

    User user = userRepo.findByEmail(email)
            .orElseThrow(() -> new RuntimeException("User not found"));

    if (user.getPassword() == null || !user.getPassword().equals(password)) {
        throw new RuntimeException("Invalid password");
    }

    return user;
}
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public User getUserById(Long id) {
    return userRepo.findById(id)
            .orElseThrow(() -> new RuntimeException("User not found"));
}

    public List<StudyGroup> getUserGroups(Long userId) {
        User user = userRepo.findById(userId).orElseThrow();
        return user.getGroups();
    }
}