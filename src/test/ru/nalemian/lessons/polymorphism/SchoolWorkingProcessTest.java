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
        Student student1 = new Student("Таня") {
        };
        Student student2 = new Student("Аня") {
        };
        studentCollection.add(student1);
        studentCollection.add(student2);
        for (Student student : studentCollection) {
            student.addKnowledge(new Knowledge(mathematician.getNameOfLesson(), "комбинаторика"));
            student.addKnowledge(new Knowledge(physicist.getNameOfLesson(), "электростатика"));
        }
        mathematician.giveHomework(studentCollection, mathematician.getNameOfLesson(), "комбинаторика");
        physicist.giveHomework(studentCollection, physicist.getNameOfLesson(), "электростатика");
        for (Student student : studentCollection) {
            student.doHomework("комбинаторика", mathematician.getNameOfLesson());
            student.doHomework("электростатика", physicist.getNameOfLesson());
        }
        mathematician.teachLesson(mathLesson, studentCollection, "дроби");
        physicist.teachLesson(physicsLesson, studentCollection, "динамика");
        for (Student student : studentCollection) {
            student.getPossibleMarks().removeAll(student.getPossibleMarks());
        }
        for (Mark mark : student1.getMarks()) {
            System.out.println(student1.getStudentName() + ", " + mark.getLessonName() + " : " + mark.getMark());
        }
        for (Mark mark : student2.getMarks()) {
            System.out.println(student2.getStudentName() + ", " + mark.getLessonName() + " : " + mark.getMark());
        }
        for (Student student : studentCollection) {
            student.doHomework("дроби", mathematician.getNameOfLesson());
            student.doHomework("динамика", physicist.getNameOfLesson());
        }
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
        for (Mark mark : student1.getMarks()) {
            System.out.println(student1.getStudentName() + ", " + mark.getLessonName() + " : " + mark.getMark());
        }
        for (Mark mark : student2.getMarks()) {
            System.out.println(student2.getStudentName() + ", " + mark.getLessonName() + " : " + mark.getMark());
        }
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
        for (Mark mark : student1.getMarks()) {
            System.out.print(mark.getMark() + " ");
        }
        System.out.println();
        System.out.print("оценки Ани: ");
        for (Mark mark : student2.getMarks()) {
            System.out.print(mark.getMark() + " ");
        }
        for (Student student : studentCollection) {
            assertEquals(student.getKnowledges().size(), 6);
            assertEquals(student.getMarks().size(), 4);
        }
    }
}