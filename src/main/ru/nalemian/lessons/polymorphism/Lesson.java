package ru.nalemian.lessons.polymorphism;

import java.util.ArrayList;
import java.util.Collection;

public interface Lesson {
    String getLessonName();

    Boolean getLessonIsOver();

    void schoolSubject();

    void start(String theme);

    Collection<String> getThemes();
}