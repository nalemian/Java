package ru.nalemian.lessons.teacher;

import ru.nalemian.lessons.polymorphism.Homework;
import ru.nalemian.lessons.polymorphism.Lesson;
import ru.nalemian.lessons.polymorphism.student.Student;

import java.time.LocalDate;
import java.util.Collection;

public class NewTeacher {
    String nameOfLesson;

    public NewTeacher(String nameOfLesson) {
        this.nameOfLesson = nameOfLesson;
    }

    public String getNameOfLesson() {
        return this.nameOfLesson;
    }

    public void teachLesson(Lesson lesson, Collection<Student> studentCollection) {
        if (lesson.getLessonIsOver()) {
            throw new RuntimeException("Урок уже закончился"); //для исключений
        }
        String lessonName = lesson.getLessonName();

        if (lessonName.equals(getNameOfLesson())) {
            System.out.println("начинаю урок '" + lessonName + "'");

            //урок начался
            lesson.start();
            // проверяем предыдущие домашки по этому уроку

            // TODO придумай какая должна быть логика по проверке ДЗ

            // даем знания студентам
            for (Student student : studentCollection) {
                student.addKnowledge(new Knowledge(lessonName));
            }

            // даем домашку студентам
            giveHomework(studentCollection, lessonName);

        }
    }

    public void giveHomework(Collection<Student> studentCollection, String name) {
        for (Student student : studentCollection) {
            student.addHomework(new Homework(name, LocalDate.now()));
        }
    }
}
