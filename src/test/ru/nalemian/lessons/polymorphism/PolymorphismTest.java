package ru.nalemian.lessons.polymorphism;

import org.junit.jupiter.api.Test;

public class PolymorphismTest {
    void testPolymorphism() {
        var mathLesson = new MathLesson();
        var physicsLesson = new PhysicsLesson();
        doSomething(mathLesson);
    }

    @Test
    void testBadStudent() {
        System.out.println(1);
    }

    private void doSomething(Lesson value) {
        value.schoolSubject();
    }

}