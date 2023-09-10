package ru.nalemian.lessons.teacher;

import org.junit.jupiter.api.Test;
import ru.nalemian.lessons.polymorphism.student.BadStudent;
import ru.nalemian.lessons.polymorphism.Mathematician;
import ru.nalemian.lessons.polymorphism.student.Student;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class GiveHomeworkTest {
    @Test
    void testThatCollectionNotCompletedWorkIsChanging() {
        NewTeacher mathematician = new Mathematician("математика");
        Student badStudent = new BadStudent("Таня");
        Collection<Student> studentCollection = new ArrayList<>();
        studentCollection.add(badStudent);
        mathematician.giveHomework(studentCollection, mathematician.getNameOfLesson(), "дроби");
        assertFalse(badStudent.getNotCompletedWork().isEmpty());
    }
}