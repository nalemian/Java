package ru.nalemian.lessons.teacher;

import org.junit.jupiter.api.Test;
import ru.nalemian.lessons.polymorphism.*;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DoHomeworkTest {
    @Test
    void testThatHomeworkIsDone() {
        Physicist physicist = new Physicist("физика");
        Lesson physicsLesson = new PhysicsLesson();
        Student excellentStudent = new ExcellentStudent();
        Collection<Student> studentCollection = new ArrayList<>();
        studentCollection.add(excellentStudent);
        physicist.giveHomework(studentCollection, physicist.getNameOfLesson());
        physicist.teachLesson(physicsLesson, studentCollection);
        assertTrue(excellentStudent.getNotCompletedWork().isEmpty());
        assertTrue(!excellentStudent.getCompletedWork().isEmpty());
    }
}
