package ru.nalemian.lessons.polymorphism;

import java.util.ArrayList;
import java.util.Collection;

public class MathLesson implements Lesson {
    public String name = "математика";
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
        Lesson mathLesson = new MathLesson();
        mathLesson.schoolSubject();
        this.lessonIsOver = true;
    }

    @Override
    public Collection<String> getThemes() {
        return themes;
    }
}
