package ru.nalemian.lessons.teacher;

import ru.nalemian.lessons.polymorphism.Homework;
import ru.nalemian.lessons.polymorphism.Lesson;
import ru.nalemian.lessons.polymorphism.Mark;
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

    public void teachLesson(Lesson lesson, Collection<Student> studentCollection, String lessonTheme) {
        if (lesson.getLessonName().contains(lessonTheme)) {
            throw new RuntimeException("Урок уже закончился"); //для исключений
        }
        String lessonName = lesson.getLessonName();
        if (lessonName.equals(getNameOfLesson())) {
            System.out.println("начинаю урок '" + lessonName + "'");
            lesson.start(lessonTheme);
            for (Student student : studentCollection) {
                if (student.getCompletedWork().isEmpty() && student.getNotCompletedWork().isEmpty()) {
                    break;
                } else {
                    if (student.getCompletedWork().isEmpty()) {
                        student.getMarks().add(new Mark(lesson.getLessonName(), 2));
                    } else {
                        student.getMarks().add(new Mark(lesson.getLessonName(), 5));
                    }
                }
            }
            for (Student student : studentCollection) {
                student.addKnowledge(new Knowledge(lessonName, lessonTheme));
            }
            giveHomework(studentCollection, lessonName, lessonTheme);
        }
    }

    public void giveHomework(Collection<Student> studentCollection, String name, String lessonTheme) {
        for (Student student : studentCollection) {
            student.addHomework(new Homework(name, LocalDate.now()));
        }
    }
}