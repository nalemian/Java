package ru.nalemian.lessons.teacher;

import org.junit.jupiter.api.Test;
import ru.nalemian.lessons.polymorphism.Lesson;
import ru.nalemian.lessons.polymorphism.Physicist;
import ru.nalemian.lessons.polymorphism.PhysicsLesson;

class NullPointerExceptionTest {
    @Test
    void main() {
        Physicist physicist = new Physicist("физика");
        Lesson physicsLesson = new PhysicsLesson();
        physicist.teachLesson(physicsLesson, null);
    }
}