package ru.nalemian.lessons.polymorphism;

import org.junit.jupiter.api.Test;

class TeacherTest {
    @Test
    public void testTeacherCreation() {
        Teacher physicist = new Physicist();
        physicist.teaching();
        Teacher mathematician = new Mathematician();
        mathematician.teaching();
    }
}