package ru.nalemian.lessons.polymorphism;

public class Mathematician extends Teacher {
    @Override
    public void teaching() {
        System.out.println("я учу математике!");
    }

    @Override
    public void startLesson(Lesson newLesson, Student student1, Student student2) {
        if (newLesson.getLessonIsOver()) {
            System.out.println("этот урок уже закончился");
        } else {
            String newLessonName = newLesson.getLessonName();
            if (newLessonName.equals("математика")) {
                System.out.println("начинаю урок '" + newLessonName + "'");
                newLesson.start();
                askHomework(student1, newLessonName);
                askHomework(student2, newLessonName);
            } else {
                System.out.println(newLessonName + " - не мой предмет");
            }
        }
    }

    @Override
    public void askHomework(Student student, String name) {
        student.giveHomework();
        if (student.homework) {
            System.out.println("молодец, " + student.studentName + "! Ставлю 5 по предмету '" + name + "'");
        } else {
            System.out.println("очень плохо, " + student.studentName + "! Ставлю 2 по предмету '" + name + "'");
        }
    }
}