package com.SprintBootEx.SpringBootEx.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.SprintBootEx.SpringBootEx.model.StudyGroup;


public interface StudyGroupRepository extends JpaRepository<StudyGroup, Long> {}