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

            // 👤 Create User
            User user = new User();
            user.setName("Shannon");
            user.setEmail("shannon@test.com");
            user.setMajor("Computer Science");
			user.setPassword("password");
            userRepo.save(user);

            // 📚 Create Group
            StudyGroup group = new StudyGroup();
            group.setSubject("CS Study Group");
            group.setTitle("Algorithms Help");
            group.setDate("2023-10-10");
            group.setTime("18:00");
            groupRepo.save(group);

            // 🤝 Join group
            user.getGroups().add(group);
            group.getUsers().add(user);

            userRepo.save(user);
            groupRepo.save(group);

            System.out.println("🔥 Seed data created!");

		};

	}

}
