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

class KnowledgeTest {
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

    @Test
    void testThatKnowledgesAreDifferent() {
        Physicist physicist = new Physicist("физика");
        Lesson physicsLesson = new PhysicsLesson();
        Collection<Student> studentCollection = new ArrayList<>();
        Student badStudent = new BadStudent("Таня");
        Student excellentStudent = new ExcellentStudent("Аня");
        studentCollection.add(badStudent);
        studentCollection.add(excellentStudent);
        for (Student student : studentCollection) {
            student.addKnowledge(new Knowledge(physicist.getNameOfLesson(), "электростатика"));
        }
        physicist.giveHomework(studentCollection, physicist.getNameOfLesson(), "электростатика");
        for (Student student : studentCollection) {
            student.doHomework();
        }
        physicist.teachLesson(physicsLesson, studentCollection, "динамика");

        for (Student student : studentCollection) {
            Collection<String> names = new ArrayList<>();
            for (Knowledge knowledge : student.getKnowledges()) {
                names.add(knowledge.getLessonTheme());
            }
            assertTrue(names.contains("электростатика"));
            assertTrue(names.contains("динамика"));
        }
    }
}
