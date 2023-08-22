package ru.nalemian.lessons.teacher;

import org.junit.jupiter.api.Test;
import ru.nalemian.lessons.polymorphism.*;

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
        Student badStudent = new BadStudent();
        Student excellentStudent = new ExcellentStudent();
        studentCollection.add(badStudent);
        studentCollection.add(excellentStudent);
        mathematician.giveHomework(studentCollection, mathematician.getNameOfLesson());
        mathematician.teachLesson(mathLesson, studentCollection);
        for (Student student : studentCollection) {
            student.doHomework();
        }
        for (Student student : studentCollection) {
            if (student.getCompletedWork().isEmpty()) {
                assertTrue(student.studentName.equals("Таня"));
            } else {
                for (Homework homework : student.getCompletedWork()) {
                    if (homework.getLessonName().equals("математика")) {
                        assertTrue(student.studentName.equals("Аня"));
                        break;
                    }
                }
            }
        }
    }
}
