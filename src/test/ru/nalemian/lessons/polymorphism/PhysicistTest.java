package ru.nalemian.lessons.polymorphism;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class PhysicistTest {
    @Test
    void askHomework() {
        Physicist physicist = new Physicist("физика");
        Lesson physicsLesson = new PhysicsLesson();
        Collection<Student> studentCollection = new ArrayList<>();
        Student badStudent = new BadStudent();
        Student excellentStudent = new ExcellentStudent();
        studentCollection.add(badStudent);
        studentCollection.add(excellentStudent);
        physicist.giveHomework(studentCollection, physicist.getNameOfLesson());
        physicist.teachLesson(physicsLesson, studentCollection);
        for (Student student : studentCollection) {
            student.doHomework();
        }
        Boolean homeworkSearch = false;
        for (Student student : studentCollection) {
            if (student.getCompletedWork().isEmpty()) {
                assertEquals("Таня", student.studentName);
                System.out.println("домашняя работа не сделана");
                System.out.println("очень плохо, " + student.studentName + "! Ставлю 2 по предмету 'математика'");
            } else {
                for (Homework homework : student.getCompletedWork()) {
                    if (homework.getLessonName().equals("математика")) {
                        assertEquals("Аня", student.studentName);
                        homeworkSearch = true;
                        System.out.println("домашняя работа сделана");
                        System.out.println("молодец, " + student.studentName + "! Ставлю 5 по предмету 'математика'");
                        break;
                    }
                }
                if (!homeworkSearch) {
                    System.out.println("домашняя работа не сделана");
                    System.out.println("очень плохо, " + student.studentName + "! Ставлю 2 по предмету 'математика'");
                }
            }
        }
        assertFalse(badStudent.getNotCompletedWork().isEmpty());
        assertTrue(excellentStudent.getNotCompletedWork().isEmpty());
        assertTrue(badStudent.getCompletedWork().isEmpty());
        assertFalse(excellentStudent.getCompletedWork().isEmpty());
    }
}