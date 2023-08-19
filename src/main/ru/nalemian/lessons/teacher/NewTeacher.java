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
        //if (newLesson.getLessonIsOver()) {
        //  throw new RuntimeException(); //для исключений
        //}
        String newLessonName = newLesson.getLessonName();
        boolean bool1 = false;
        for (Student student : studentCollection) {
            for (Knowledge knowledge : student.getKnowledges()) {
                if (knowledge.getLessonName().equals(newLessonName)) {
                    if (newLessonName.equals(getNameOfLesson())) {
                        System.out.println("урок " + "'" + newLessonName + "' уже закончился");
                    } else {
                        System.out.println(newLessonName + " - не мой предмет");
                    }
                    bool1 = true;
                }
            }
            if (bool1) {
                break;
            }
        }
        if (!bool1) {
            if (newLessonName.equals(getNameOfLesson())) {
                System.out.println("начинаю урок '" + newLessonName + "'");
                newLesson.start();
                askHomework(studentCollection, newLessonName);
                for (Student student : studentCollection) {
                    student.getKnowledges().add(new Knowledge(newLessonName));
                }
            } else {
                System.out.println(newLessonName + " - не мой предмет");
            }
        }
    }

    public void askHomework(Collection<Student> studentCollection, String name) {
        Boolean homeworkSearch = false;
        for (Student student : studentCollection) {
            student.doHomework();
            if (student.getCompletedWork().isEmpty()) {
                System.out.println("домашняя работа не сделана");
                System.out.println("очень плохо, " + student.studentName + "! Ставлю 2 по предмету '" + name + "'");
            } else {
                for (Homework homework : student.getCompletedWork()) {
                    if (homework.getLessonName().equals(name)) {
                        homeworkSearch = true;
                        System.out.println("домашняя работа сделана");
                        System.out.println("молодец, " + student.studentName + "! Ставлю 5 по предмету '" + name + "'");
                        break;
                    }
                }
                if (!homeworkSearch) {
                    System.out.println("домашняя работа не сделана");
                    System.out.println("очень плохо, " + student.studentName + "! Ставлю 2 по предмету '" + name + "'");
                }
            }
        }
    }

    public void giveHomework(Collection<Student> studentCollection, String name) {
        for (Student student : studentCollection) {
            student.getNotCompletedWork().add(new Homework(name, LocalDate.now()));
        }
    }
}
