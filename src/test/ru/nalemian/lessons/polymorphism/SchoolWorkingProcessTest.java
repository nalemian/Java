package ru.nalemian.lessons.polymorphism;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SchoolWorkingProcessTest {

    @Test
    void main() {
        Lesson physicsLesson = new PhysicsLesson();
        Lesson mathLesson = new MathLesson();
        Teacher mathematician = new Mathematician();
        Teacher physicist = new Physicist();
        Student badStudent = new BadStudent();
        Student excellentStudent = new ExcellentStudent();
        mathematician.startLesson(physicsLesson, badStudent, excellentStudent);
        mathematician.startLesson(mathLesson, badStudent, excellentStudent);
        physicist.startLesson(mathLesson, badStudent, excellentStudent);
        physicist.startLesson(physicsLesson, badStudent, excellentStudent);
    }
}