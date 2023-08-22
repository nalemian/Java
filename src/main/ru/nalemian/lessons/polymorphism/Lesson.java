package ru.nalemian.lessons.polymorphism;

public interface Lesson {

    // TODO прибраться
    String name = "урок";
    Boolean lessonIsOver = false;
    // TODO добавить способ отличить один урок одного типа от другого

    String getLessonName();

    Boolean getLessonIsOver();

    void schoolSubject();

    void start();

    default void defaultSomething() {
    }
}
