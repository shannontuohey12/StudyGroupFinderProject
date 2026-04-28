package com.SprintBootEx.SpringBootEx.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.SprintBootEx.SpringBootEx.model.User;


public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
}
