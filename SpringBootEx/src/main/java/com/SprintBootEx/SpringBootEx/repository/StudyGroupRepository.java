package com.SprintBootEx.SpringBootEx.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.SprintBootEx.SpringBootEx.model.StudyGroup;
import java.util.List;


public interface StudyGroupRepository extends JpaRepository<StudyGroup, Long> {

List<StudyGroup> findByTitleContainingIgnoreCaseOrSubjectContainingIgnoreCase(
        String title,
        String subject
    );
}