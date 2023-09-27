package ru.nalemian.lessons.polymorphism.student;

import org.junit.jupiter.api.Test;
import ru.nalemian.lessons.polymorphism.*;
import ru.nalemian.lessons.teacher.Knowledge;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StudentTest {

    /**
     * здесь тестируются знания учеников
     */

    @Test
    void testThatLessonGiveStudentKnowledge() {
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
        mathematician.teachLesson(mathLesson, studentCollection, "дроби");
        physicist.teachLesson(physicsLesson, studentCollection, "кинематика");
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

    /**
     * здесь тестируются темы занятий
     */

    @Test
    void testThatStudentHaveRightThemes() {
        Physicist physicist = new Physicist("физика");
        Collection<Student> studentCollection = new ArrayList<>();
        Student student1 = new Student("Таня") {
        };
        Student student2 = new Student("Аня") {
        };
        studentCollection.add(student1);
        studentCollection.add(student2);
        for (Student student : studentCollection) {
            student.addKnowledge(new Knowledge(physicist.getNameOfLesson(), "электростатика"));
        }
        for (Student student : studentCollection) {
            for (Knowledge knowledge : student.getKnowledges()) {
                assertEquals(knowledge.getLessonTheme(), "электростатика");
            }
        }
    }
}