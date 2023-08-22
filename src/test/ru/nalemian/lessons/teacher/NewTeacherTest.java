package ru.nalemian.lessons.teacher;

import org.junit.jupiter.api.Test;
import ru.nalemian.lessons.polymorphism.Lesson;
import ru.nalemian.lessons.polymorphism.MathLesson;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class NewTeacherTest {

    @Test
    void whenLessonIsOver_thenRuntimeException() {
        NewTeacher newTeacher = new NewTeacher("урок");
        Lesson newLesson = new MathLesson();
        newLesson.start();
        assertThrows(
                RuntimeException.class,
                () -> newTeacher.teachLesson(newLesson, Collections.emptyList())
        );
    }
}