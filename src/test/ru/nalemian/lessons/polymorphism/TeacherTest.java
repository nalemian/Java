package ru.nalemian.lessons.polymorphism;

import org.junit.jupiter.api.Test;
import ru.nalemian.lessons.teacher.NewTeacher;

class TeacherTest {
    @Test
    public void testTeacherCreation() {
        NewTeacher physicist = new Physicist("физика");
        ((Physicist) physicist).teaching();
        NewTeacher mathematician = new Mathematician("математика");
        ((Mathematician) mathematician).teaching();
    }
}