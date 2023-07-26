package ru.nalemian.lessons.polymorphism;

public interface Lesson {
    String name = "урок";
    Boolean lessonIsOver = false;

    String getLessonName();

    Boolean getLessonIsOver();

    void schoolSubject();

    void start();

    default void defaultSomething() {
    }
}
