package ru.nalemian.lessons.polymorphism;

public interface Lesson {
    String name = "урок";

    String getLessonName();

    void schoolSubject();

    void start();

    default void defaultSomething() {
    }
}
