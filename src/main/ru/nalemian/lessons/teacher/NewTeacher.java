package ru.nalemian.lessons.teacher;

import ru.nalemian.lessons.polymorphism.Homework;
import ru.nalemian.lessons.polymorphism.Lesson;
import ru.nalemian.lessons.polymorphism.Mark;
import ru.nalemian.lessons.polymorphism.student.Student;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;

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
        if (studentCollection.isEmpty()) {
            throw new RuntimeException("Учеников в классе нет");
        }
        String lessonName = lesson.getLessonName();
        if (lessonName.equals(getNameOfLesson())) {
            System.out.println("начинаю урок '" + lessonName + "'");
            lesson.start(lessonTheme);
            for (Student student : studentCollection) {
                Boolean check = false;
                for (Homework homework : student.getCompletedWork()) {
                    if (this.nameOfLesson.equals(homework.getLessonName())) {
                        for (Mark mark : student.getPossibleMarks()) {
                            if (mark.getLessonTheme().equals(homework.getLessonTheme())) {
                                student.getMarks().add(new Mark(homework.getLessonName(), mark.getMark(), mark.getLessonTheme()));
                                check = true;
                            }
                        }
                    }
                }
                if (!check) {
                    for (Homework homework : student.getNotCompletedWork()) {
                        if (this.nameOfLesson.equals(homework.getLessonName())) {
                            for (Mark mark : student.getPossibleMarks()) {
                                if (mark.getLessonTheme().equals(homework.getLessonTheme())) {
                                    student.getMarks().add(new Mark(homework.getLessonName(), 2, mark.getLessonTheme()));
                                    check = true;
                                }
                            }
                        }
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
            student.addHomework(new Homework(lessonTheme, name, LocalDate.now()));
        }
    }
}