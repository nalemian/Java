package ru.nalemian.lessons.teacher;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.nalemian.lessons.polymorphism.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NullPointerExceptionTest {

    /**
     * здесь тестируется исключение NullPointerException
     */

    @Test
    void ifTheStudentCollectionValueIsNullThenNullPointerException() {
        Physicist physicist = new Physicist("физика");
        Lesson physicsLesson = new PhysicsLesson();
        try {
            physicist.teachLesson(physicsLesson, null, "кинематика");
        } catch (NullPointerException exception) {
            assertEquals("class java.lang.NullPointerException", exception.getClass().toString());
        }
    }
}