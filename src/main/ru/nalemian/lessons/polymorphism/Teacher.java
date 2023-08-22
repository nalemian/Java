package ru.nalemian.lessons.polymorphism;

import ru.nalemian.lessons.polymorphism.student.Student;

public class Teacher {
    public void teaching() {
        System.out.println("Я обучаю!");
    }

    public void startLesson(Lesson newLesson, Student student1, Student student2) {
        System.out.println("начинаю урок");
    }

    public void askHomework(Student student, String name) {
        System.out.println("спрашиваю домашнее задание");
    }
}
