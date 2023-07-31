package ru.nalemian.lessons.polymorphism;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExcellentStudentTest {
    @Test
    void testExcellentStudent() {
        Student student=new ExcellentStudent();
        assertTrue(student.giveHomework());
    }
}