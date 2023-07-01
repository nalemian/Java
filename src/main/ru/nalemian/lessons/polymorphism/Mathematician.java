package ru.nalemian.lessons.polymorphism;

public class Mathematician extends Teacher {
    @Override
    public void teaching() {
        System.out.println("Я учу математике!");
    }
}