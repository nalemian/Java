package ru.nalemian.lessons.teacher;

import ru.nalemian.lessons.polymorphism.Lesson;
import ru.nalemian.lessons.polymorphism.Student;

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
        for (Student student : studentCollection) {
            student.giveHomework();
            if (student.homework) {
                System.out.println("молодец, " + student.studentName + "! Ставлю 5 по предмету '" + name + "'");
            } else {
                System.out.println("очень плохо, " + student.studentName + "! Ставлю 2 по предмету '" + name + "'");
            }
        }
    }
}
