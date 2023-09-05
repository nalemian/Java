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

    public void teachLesson(Lesson lesson, Collection<Student> studentCollection) {
        if (lesson.getLessonIsOver()) {
            throw new RuntimeException("Урок уже закончился"); //для исключений
        }
        String lessonName = lesson.getLessonName();
        if (lessonName.equals(getNameOfLesson())) {
            System.out.println("начинаю урок '" + lessonName + "'");
            lesson.start();
            for (Student student : studentCollection) {
                if (student.getCompletedWork().isEmpty() && student.getNotCompletedWork().isEmpty()) {
                    break;
                } else {
                    if (student.getCompletedWork().isEmpty()) {
                        for (Homework homework : student.getNotCompletedWork()) {
                            if (this.nameOfLesson.equals(homework.getLessonName())) {
                                if (!student.getMarks().isEmpty()) {
                                    Integer allMarks = 0;
                                    for (Mark mark : student.getMarks()) {
                                        allMarks += mark.getMark();
                                    }
                                    Integer averageMark = allMarks / student.getMarks().size();
                                    if (averageMark >= 4) {
                                        student.getMarks().add(new Mark(homework.getLessonName(), 3));
                                    } else {
                                        student.getMarks().add(new Mark(homework.getLessonName(), 2));
                                    }
                                } else {
                                    student.getMarks().add(new Mark(homework.getLessonName(), 2));
                                }
                            }
                        }
                    } else {
                        for (Homework homework : student.getCompletedWork()) {
                            if (this.nameOfLesson.equals(homework.getLessonName())) {
                                if (!student.getMarks().isEmpty()) {
                                    Integer allMarks = 0;
                                    for (Mark mark : student.getMarks()) {
                                        allMarks += mark.getMark();
                                    }
                                    int averageMark = allMarks / student.getMarks().size();
                                    if (averageMark >= 4) {
                                        student.getMarks().add(new Mark(homework.getLessonName(), 5));
                                    } else {
                                        student.getMarks().add(new Mark(homework.getLessonName(), 4));
                                    }
                                } else {
                                    student.getMarks().add(new Mark(homework.getLessonName(), 5));
                                }
                            }
                        }
                    }
                }
            }
            for (Student student : studentCollection) {
                student.addKnowledge(new Knowledge(lessonName));
            }
            giveHomework(studentCollection, lessonName);

        }
    }

    public void giveHomework(Collection<Student> studentCollection, String name) {
        for (Student student : studentCollection) {
            student.addHomework(new Homework(name, LocalDate.now()));
        }
    }
}