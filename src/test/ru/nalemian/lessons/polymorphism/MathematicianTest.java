package ru.nalemian.lessons.polymorphism;

import org.junit.jupiter.api.Test;
import ru.nalemian.lessons.polymorphism.student.BadStudent;
import ru.nalemian.lessons.polymorphism.student.ExcellentStudent;
import ru.nalemian.lessons.polymorphism.student.Student;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class MathematicianTest {

    @Test
    void askHomework() {
        Mathematician mathematician = new Mathematician("математика");
        Lesson mathLesson = new MathLesson();
        Collection<Student> studentCollection = new ArrayList<>();
        Student badStudent = new BadStudent("Таня");
        Student excellentStudent = new ExcellentStudent("Аня");
        studentCollection.add(badStudent);
        studentCollection.add(excellentStudent);
        mathematician.giveHomework(studentCollection, mathematician.getNameOfLesson());
        mathematician.teachLesson(mathLesson, studentCollection);
        for (Student student : studentCollection) {
            student.doHomework();
        }
        Boolean homeworkSearch = false;
        for (Student student : studentCollection) {
            if (student.getCompletedWork().isEmpty()) {
                assertEquals("Таня", student.getStudentName());
                System.out.println("домашняя работа не сделана");
                System.out.println("очень плохо, " + student.getStudentName() + "! Ставлю 2 по предмету 'математика'");
            } else {
                for (Homework homework : student.getCompletedWork()) {
                    if (homework.getLessonName().equals("математика")) {
                        assertEquals("Аня", student.getStudentName());
                        homeworkSearch = true;
                        System.out.println("домашняя работа сделана");
                        System.out.println("молодец, " + student.getStudentName() + "! Ставлю 5 по предмету 'математика'");
                        break;
                    }
                }
                if (!homeworkSearch) {
                    System.out.println("домашняя работа не сделана");
                    System.out.println("очень плохо, " + student.getStudentName() + "! Ставлю 2 по предмету 'математика'");
                }
            }
        }
        assertFalse(badStudent.getNotCompletedWork().isEmpty());
        assertTrue(excellentStudent.getNotCompletedWork().isEmpty());
        assertTrue(badStudent.getCompletedWork().isEmpty());
        assertFalse(excellentStudent.getCompletedWork().isEmpty());
    }
}