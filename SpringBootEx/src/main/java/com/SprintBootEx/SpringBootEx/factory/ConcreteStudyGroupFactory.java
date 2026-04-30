package com.SprintBootEx.SpringBootEx.factory;

import com.SprintBootEx.SpringBootEx.model.StudyGroup;

public class ConcreteStudyGroupFactory extends StudyGroupFactory {
    @Override
    public StudyGroup createStudyGroup(String title, String subject) {
        StudyGroup group = new StudyGroup();
        group.setTitle(title);
        group.setSubject(subject);
        return group;
    }
}