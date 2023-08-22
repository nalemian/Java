package ru.nalemian.lessons.teacher;

import ru.nalemian.lessons.polymorphism.Homework;
import ru.nalemian.lessons.polymorphism.Lesson;
import ru.nalemian.lessons.polymorphism.Student;

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

    public void teachLesson(Lesson newLesson, Collection<Student> studentCollection) {
        if (newLesson.getLessonIsOver()) {
            throw new RuntimeException(); //для исключений
        }
        String newLessonName = newLesson.getLessonName();
        boolean knowledgeSearch = false;
        for (Student student : studentCollection) {
            for (Knowledge knowledge : student.getKnowledges()) {
                if (knowledge.getLessonName().equals(newLessonName)) {
                    if (newLessonName.equals(getNameOfLesson())) {
                        System.out.println("урок " + "'" + newLessonName + "' уже закончился");
                    } else {
                        System.out.println(newLessonName + " - не мой предмет");
                    }
                    knowledgeSearch = true;
                }
            }
            if (knowledgeSearch) {
                break;
            }
        }
        if (!knowledgeSearch) {
            if (newLessonName.equals(getNameOfLesson())) {
                System.out.println("начинаю урок '" + newLessonName + "'");
                newLesson.start();
                for (Student student : studentCollection) {
                    student.getKnowledges().add(new Knowledge(newLessonName));
                }
            } else {
                System.out.println(newLessonName + " - не мой предмет");
            }
        }
    }

    public void giveHomework(Collection<Student> studentCollection, String name) {
        for (Student student : studentCollection) {
            student.getNotCompletedWork().add(new Homework(name, LocalDate.now()));
        }
    }
}
