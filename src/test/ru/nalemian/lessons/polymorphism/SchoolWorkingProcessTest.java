package ru.nalemian.lessons.polymorphism;

import org.junit.jupiter.api.Test;
import ru.nalemian.lessons.polymorphism.student.BadStudent;
import ru.nalemian.lessons.polymorphism.student.ExcellentStudent;
import ru.nalemian.lessons.polymorphism.student.Student;
import ru.nalemian.lessons.teacher.Knowledge;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class SchoolWorkingProcessTest {

    /**
     *
     */
    @Test
    void allProcess() {
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
        mathematician.teachLesson(mathLesson, studentCollection);
        for (Student student : studentCollection) {
            student.doHomework();
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
        mathematician.teachLesson(mathLesson, studentCollection);
        mathematician.teachLesson(physicsLesson, studentCollection);
        physicist.teachLesson(physicsLesson, studentCollection);
        for (Student student : studentCollection) {
            student.doHomework();
        }
        homeworkSearch = false;
        for (Student student : studentCollection) {
            if (student.getCompletedWork().isEmpty()) {
                System.out.println("домашняя работа не сделана");
                System.out.println("очень плохо, " + student.getStudentName() + "! Ставлю 2 по предмету 'физика'");
            } else {
                for (Homework homework : student.getCompletedWork()) {
                    if (homework.getLessonName().equals("физика")) {
                        homeworkSearch = true;
                        System.out.println("домашняя работа сделана");
                        System.out.println("молодец, " + student.getStudentName() + "! Ставлю 5 по предмету 'физика'");
                        break;
                    }
                }
                if (!homeworkSearch) {
                    System.out.println("домашняя работа не сделана");
                    System.out.println("очень плохо, " + student.getStudentName() + "! Ставлю 2 по предмету 'физика'");
                }
            }
        }
        physicist.teachLesson(physicsLesson, studentCollection);
        physicist.teachLesson(mathLesson, studentCollection);
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