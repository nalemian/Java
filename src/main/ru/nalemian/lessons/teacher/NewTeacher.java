package ru.nalemian.lessons.teacher;

import ru.nalemian.lessons.polymorphism.Lesson;
import ru.nalemian.lessons.polymorphism.Student;

import java.util.Collection;

public class NewTeacher {
    public void teachLesson(Lesson newLesson, Collection <Student> studentCollection) {
        if(newLesson.getLessonIsOver()) {
            throw new RuntimeException(); //для исключений
        }
        for (Student student : studentCollection) {
            student.getKnowledges().add(new Knowledge(newLesson.getLessonName()));
        }
    }
}
