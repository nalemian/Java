package ru.nalemian.lessons.polymorphism;

import org.junit.jupiter.api.Test;
import ru.nalemian.lessons.teacher.Knowledge;
import ru.nalemian.lessons.teacher.NewTeacher;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class SchoolWorkingProcessTest {

    @Test
    void allProcess() {
        Physicist physicist = new Physicist("физика");
        physicist.teaching();
        Mathematician mathematician = new Mathematician("математика");
        mathematician.teaching();
        Lesson mathLesson = new MathLesson();
        Lesson physicsLesson = new PhysicsLesson();
        Collection<Student> studentCollection = new ArrayList<>();
        Student badStudent = new BadStudent();
        Student excellentStudent = new ExcellentStudent();
        studentCollection.add(badStudent);
        studentCollection.add(excellentStudent);
        mathematician.giveHomework(studentCollection, mathematician.getNameOfLesson());
        physicist.giveHomework(studentCollection, physicist.getNameOfLesson());
        mathematician.teachLesson(mathLesson, studentCollection);
        mathematician.teachLesson(mathLesson, studentCollection);
        mathematician.teachLesson(physicsLesson, studentCollection);
        physicist.teachLesson(physicsLesson, studentCollection);
        physicist.teachLesson(physicsLesson, studentCollection);
        physicist.teachLesson(mathLesson, studentCollection);
    }
}