package com.SprintBootEx.SpringBootEx;

import com.SprintBootEx.SpringBootEx.model.User;
import com.SprintBootEx.SpringBootEx.model.StudyGroup;
import com.SprintBootEx.SpringBootEx.repository.*;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootExApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootExApplication.class, args);
    }

    @Bean
    CommandLineRunner init(UserRepository userRepo, StudyGroupRepository groupRepo) {
        return args -> {

            // Create User
            User user = userRepo.findByEmail("shannon@test.com").orElseGet(() -> {
                User newUser = new User();
                newUser.setName("Shannon");
                newUser.setEmail("shannon@test.com");
                newUser.setMajor("Computer Science");
                newUser.setPassword("password");
                return userRepo.save(newUser);
            });

            if (groupRepo.count() == 0) {
                StudyGroup group = new StudyGroup();
                group.setSubject("CSII");
                group.setTitle("Algorithms Help");
                group.setDate("2026-10-10");
                group.setTime("18:00");
                groupRepo.save(group);

                StudyGroup group2 = new StudyGroup();
                group2.setSubject("Calculus I");
                group2.setTitle("Derivatives Study Group");
                group2.setDate("2026-10-10");
                group2.setTime("18:00");
                groupRepo.save(group2);

                StudyGroup group3 = new StudyGroup();
                group3.setSubject("English 170");
                group3.setTitle("Writing Workshop");
                group3.setDate("2026-10-10");
                groupRepo.save(group3);

                System.out.println("Seed data created!");
            }
        };
    }
}
