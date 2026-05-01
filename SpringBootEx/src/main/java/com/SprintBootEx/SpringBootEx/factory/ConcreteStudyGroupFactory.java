package com.SprintBootEx.SpringBootEx.factory;

import com.SprintBootEx.SpringBootEx.model.StudyGroup;
import org.springframework.stereotype.Component;

@Component // Important: This makes it available for @Autowired
public class ConcreteStudyGroupFactory extends StudyGroupFactory {
    @Override
    public StudyGroup createStudyGroup(String title, String subject, String date, String time) {
        StudyGroup group = new StudyGroup();
        group.setTitle(title);
        group.setSubject(subject);
        group.setDate(date);
        group.setTime(time);
        return group;
    }
}