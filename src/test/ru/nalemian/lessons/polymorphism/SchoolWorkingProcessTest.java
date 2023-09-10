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
        for (Student student : studentCollection) {
            student.addKnowledge(new Knowledge(mathematician.getNameOfLesson(), "комбинаторика"));
            student.addKnowledge(new Knowledge(physicist.getNameOfLesson(), "электростатика"));
        }
        mathematician.giveHomework(studentCollection, mathematician.getNameOfLesson(), "комбинаторика");
        physicist.giveHomework(studentCollection, physicist.getNameOfLesson(), "электростатика");
        for (Student student : studentCollection) {
            student.doHomework();
        }
        mathematician.teachLesson(mathLesson, studentCollection, "дроби");
        physicist.teachLesson(physicsLesson, studentCollection, "динамика");
        for (Mark mark : badStudent.getMarks()) {
            System.out.println(badStudent.getStudentName() + ", " + mark.getLessonName() + " : " + mark.getMark());
        }
        for (Mark mark : excellentStudent.getMarks()) {
            System.out.println(excellentStudent.getStudentName() + ", " + mark.getLessonName() + " : " + mark.getMark());
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
        }
        mathematician.teachLesson(mathLesson, studentCollection, "теория вероятности");
        physicist.teachLesson(physicsLesson, studentCollection, "баллистика");
        for (Student student : studentCollection) {
            Integer counter = 0;
            System.out.print(student.getStudentName() + ", физика: ");
            for (Knowledge knowledge : student.getKnowledges()) {
                if (knowledge.getLessonName().equals("физика")) {
                    if (counter > 0) {
                        System.out.print(", " + knowledge.getLessonTheme());
                    } else {
                        System.out.print(knowledge.getLessonTheme());
                    }
                    counter++;
                }
            }
            counter = 0;
            System.out.println();
            System.out.print(student.getStudentName() + ", математика: ");
            for (Knowledge knowledge : student.getKnowledges()) {
                if (knowledge.getLessonName().equals("математика")) {
                    if (counter > 0) {
                        System.out.print(", " + knowledge.getLessonTheme());
                    } else {
                        System.out.print(knowledge.getLessonTheme());
                    }
                    counter++;
                }
            }
            System.out.println();
        }
        System.out.print("оценки Тани: ");
        for (Mark mark : badStudent.getMarks()) {
            System.out.print(mark.getMark() + " ");
        }
        System.out.println();
        System.out.print("оценки Ани: ");
        for (Mark mark : excellentStudent.getMarks()) {
            System.out.print(mark.getMark() + " ");
        }
    }
}