package ru.nalemian.lessons.polymorphism;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathematicianTest {
    @Test
    void startLesson() {
        String lessonName = "математика";
        if (lessonName == "математика") {
            System.out.println("начинаю урок '" + lessonName + "'");
            Lesson mathLesson = new MathLesson();
            mathLesson.schoolSubject();

        } else {
            System.out.println(lessonName + " - не мой предмет");
            Lesson physicsLesson = new PhysicsLesson();
            physicsLesson.schoolSubject();
        }
    }

    @Test
    void askHomework() {
        Student student = new ExcellentStudent();
        String name = "математика";
        student.giveHomework();
        if (student.homework) {
            System.out.println("молодец, " + student.studentName + "! Ставлю 5 по предмету '" + name + "'");
        } else {
            System.out.println("очень плохо, " + student.studentName + "! Ставлю 2 по предмету '" + name + "'");
        }
    }
}