package ru.nalemian.lessons.polymorphism;

import java.util.ArrayList;
import java.util.Collection;

public class PhysicsLesson implements Lesson {
    public String name = "физика";
    public Boolean lessonIsOver = false;
    public Collection<String> themes = new ArrayList<>();

    @Override
    public String getLessonName() {
        return this.name;
    }

    @Override
    public Boolean getLessonIsOver() {
        return this.lessonIsOver;
    }

    @Override
    public void schoolSubject() {
        System.out.println("урок '" + this.name + "'" + " начался");
    }

    @Override
    public void start(String theme) {
        Lesson physicsLesson = new PhysicsLesson();
        physicsLesson.schoolSubject();
        this.lessonIsOver = true;
    }

    @Override
    public Collection<String> getThemes() {
        return themes;
    }
}
