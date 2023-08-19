package ru.nalemian.lessons.teacher;

import org.junit.jupiter.api.Test;
import ru.nalemian.lessons.polymorphism.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class AskHomeworkTest {
    @Test
    void ifCollectionDoesNotContainHomeworkThanMarkIs2() {
        NewTeacher mathematician = new Mathematician("математика");
        Collection<Student> studentCollection = new ArrayList<>();
        Collection<Homework> completedWork = new ArrayList<>();
        completedWork.add(new Homework("физика", LocalDate.now()));
        Student badStudent = new BadStudent();
        studentCollection.add(badStudent);
        mathematician.askHomework(studentCollection, "математика");
    }
}