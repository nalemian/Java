package ru.nalemian.lessons.polymorphism;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PhysicistTest {
    @Test
    void startLesson() {
        String lessonName = "физика";
        if (lessonName == "физика") {
            System.out.println("начинаю урок '" + lessonName + "'");
            Lesson physicsLesson = new PhysicsLesson();
            physicsLesson.schoolSubject();

        } else {
            System.out.println(lessonName + " - не мой предмет");
            Lesson mathLesson = new MathLesson();
            mathLesson.schoolSubject();
        }
    }

    @Test
    void askHomework() {
        Student student = new BadStudent();
        String name = "физика";
        student.giveHomework();
        if (student.homework) {
            System.out.println("молодец, " + student.studentName + "! Ставлю 5 по предмету '" + name + "'");
        } else {
            System.out.println("очень плохо, " + student.studentName + "! Ставлю 2 по предмету '" + name + "'");
        }
    }
}