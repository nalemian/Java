package ru.nalemian.lessons.teacher;

import org.junit.jupiter.api.Test;
import ru.nalemian.lessons.polymorphism.Lesson;
import ru.nalemian.lessons.polymorphism.MathLesson;
import ru.nalemian.lessons.polymorphism.Physicist;
import ru.nalemian.lessons.polymorphism.PhysicsLesson;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class NewTeacherTest {

    @Test
    void whenLessonIsOver_thenRuntimeException() {
        NewTeacher newTeacher = new NewTeacher("урок");
        Lesson newLesson = new MathLesson();
        newLesson.start("дроби");
        assertThrows(
                RuntimeException.class,
                () -> newTeacher.teachLesson(newLesson, Collections.emptyList(), "дроби")
        );
    }

    @Test
    void whenStudentCollectionIsNull_thenNPE() {
        Physicist physicist = new Physicist("физика");
        Lesson physicsLesson = new PhysicsLesson();

        assertThrows(
                NullPointerException.class,
                () -> physicist.teachLesson(physicsLesson, null, "статика")
        );
    }
}