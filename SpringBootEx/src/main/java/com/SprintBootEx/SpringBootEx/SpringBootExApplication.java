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
            User user = new User();
            user.setName("Shannon");
            user.setEmail("shannon@test.com");
            user.setMajor("Computer Science");
			user.setPassword("password");
            userRepo.save(user);

            // Create Group
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
            group3.setTime("18:00");
            groupRepo.save(group3);

            // Join group
            user.getGroups().add(group);
            user.getGroups().add(group2);
            user.getGroups().add(group3);

            group.getUsers().add(user);
            group2.getUsers().add(user);
            group3.getUsers().add(user);

            userRepo.save(user);
            groupRepo.save(group);
            groupRepo.save(group2);
            groupRepo.save(group3);

            System.out.println("🔥 Seed data created!");

		};

	}

}
