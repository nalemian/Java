package ru.nalemian.lessons.polymorphism;

public interface Lesson {
    void schoolSubject();
    default void defaultSomething() {}
}
