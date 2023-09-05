package ru.nalemian.lessons.polymorphism;

import org.junit.Test;
import ru.nalemian.lessons.polymorphism.student.BadStudent;
import ru.nalemian.lessons.polymorphism.student.ExcellentStudent;
import ru.nalemian.lessons.polymorphism.student.Student;
import ru.nalemian.lessons.teacher.Knowledge;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

public class SchoolWorkingProcessTest {
    /**
     * здесь тестируется весь школьный процесс со всеми методами
     */
    @Test
    public void allProcess() {
        Physicist physicist = new Physicist("физика");
        physicist.teaching();
        Mathematician mathematician = new Mathematician("математика");
        mathematician.teaching();
        Lesson mathLesson = new MathLesson();
        Lesson physicsLesson = new PhysicsLesson();
        Collection<Student> studentCollection = new ArrayList<>();
        Student badStudent = new BadStudent("Таня");
        Student excellentStudent = new ExcellentStudent("Аня");
        studentCollection.add(badStudent);
        studentCollection.add(excellentStudent);
        mathematician.giveHomework(studentCollection, mathematician.getNameOfLesson());
        physicist.giveHomework(studentCollection, physicist.getNameOfLesson());
        for (Student student : studentCollection) {
            student.doHomework();
        }
        mathematician.teachLesson(mathLesson, studentCollection);
        physicist.teachLesson(physicsLesson, studentCollection);
        //physicist.teachLesson(mathLesson, studentCollection);
        for (Mark mark : badStudent.getMarks()) {
            System.out.println(mark.getLessonName() + " : " + mark.getMark());
        }
        for (Mark mark : excellentStudent.getMarks()) {
            System.out.println(mark.getLessonName() + " : " + mark.getMark());
        }
        for (Student student : studentCollection) {
            student.doHomework();
        }
        assertFalse(badStudent.getNotCompletedWork().isEmpty());
        assertTrue(excellentStudent.getNotCompletedWork().isEmpty());
        assertTrue(badStudent.getCompletedWork().isEmpty());
        assertFalse(excellentStudent.getCompletedWork().isEmpty());
        for (Student student : studentCollection) {
            Collection<String> names = new ArrayList<>();
            for (Knowledge knowledge : student.getKnowledges()) {
                names.add(knowledge.getLessonName());
            }
            assertTrue(names.contains("физика"));
            assertTrue(names.contains("математика"));
            assertEquals(2, names.size());
        }
    }
}