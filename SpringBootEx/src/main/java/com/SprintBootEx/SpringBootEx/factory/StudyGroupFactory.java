package com.SprintBootEx.SpringBootEx.factory;

import com.SprintBootEx.SpringBootEx.model.StudyGroup;

public abstract class StudyGroupFactory {
    public abstract StudyGroup createStudyGroup(String title, String subject);
}