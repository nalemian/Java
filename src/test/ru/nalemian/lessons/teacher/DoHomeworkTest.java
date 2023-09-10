package ru.nalemian.lessons.teacher;

import org.junit.jupiter.api.Test;
import ru.nalemian.lessons.polymorphism.*;
import ru.nalemian.lessons.polymorphism.student.BadStudent;
import ru.nalemian.lessons.polymorphism.student.ExcellentStudent;
import ru.nalemian.lessons.polymorphism.student.Student;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DoHomeworkTest {
    @Test
    void areTheRightStudentsDoingTheHomework() {
        Mathematician mathematician = new Mathematician("математика");
        Lesson mathLesson = new MathLesson();
        Collection<Student> studentCollection = new ArrayList<>();
        Student badStudent = new BadStudent("Таня");
        Student excellentStudent = new ExcellentStudent("Аня");
        studentCollection.add(badStudent);
        studentCollection.add(excellentStudent);
        mathematician.giveHomework(studentCollection, mathematician.getNameOfLesson(),"дроби");
        mathematician.teachLesson(mathLesson, studentCollection,"биномы Ньютона");
        for (Student student : studentCollection) {
            student.doHomework();
        }
        for (Student student : studentCollection) {
            if (student.getCompletedWork().isEmpty()) {
                assertTrue(student.getStudentName().equals("Таня"));
            } else {
                for (Homework homework : student.getCompletedWork()) {
                    if (homework.getLessonName().equals("математика")) {
                        assertTrue(student.getStudentName().equals("Аня"));
                        break;
                    }
                }
            }
        }
    }
}
