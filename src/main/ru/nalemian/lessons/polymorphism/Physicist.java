package ru.nalemian.lessons.polymorphism;

import ru.nalemian.lessons.teacher.NewTeacher;

public class Physicist extends NewTeacher {

    public Physicist(String nameOfLesson) {
        super(nameOfLesson);
    }

    public void teaching() {
        System.out.println("я учу физике!");
    }
}
