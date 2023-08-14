package ru.nalemian.lessons.polymorphism;

import ru.nalemian.lessons.teacher.NewTeacher;

public class Mathematician extends NewTeacher {

    public Mathematician(String nameOfLesson) {
        super(nameOfLesson);
    }

    public void teaching() {
        System.out.println("я учу математике!");
    }

}