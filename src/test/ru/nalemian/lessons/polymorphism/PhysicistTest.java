package ru.nalemian.lessons.polymorphism;

import org.junit.jupiter.api.Test;
import ru.nalemian.lessons.polymorphism.student.BadStudent;
import ru.nalemian.lessons.polymorphism.student.ExcellentStudent;
import ru.nalemian.lessons.polymorphism.student.Student;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class PhysicistTest {
    @Test
    void askHomework() {
        Physicist physicist = new Physicist("физика");
        Lesson physicsLesson = new PhysicsLesson();
        Collection<Student> studentCollection = new ArrayList<>();
        Student badStudent = new BadStudent("Таня");
        Student excellentStudent = new ExcellentStudent("Аня");
        studentCollection.add(badStudent);
        studentCollection.add(excellentStudent);
        physicist.giveHomework(studentCollection, physicist.getNameOfLesson(), "баллистика");
        physicist.teachLesson(physicsLesson, studentCollection, "кинематика");
        for (Student student : studentCollection) {
            student.doHomework("баллистика", physicist.getNameOfLesson());
        }
        Boolean homeworkSearch = false;
        for (Student student : studentCollection) {
            if (student.getCompletedWork().isEmpty()) {
                System.out.println("домашняя работа не сделана");
                System.out.println("очень плохо, " + student.getStudentName() + "! Ставлю 2 по предмету 'математика'");
            } else {
                for (Homework homework : student.getCompletedWork()) {
                    if (homework.getLessonName().equals("математика")) {
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
        for (Student student : studentCollection) {
            assertEquals(student.getMarks().size(), 0);
        }
    }
}