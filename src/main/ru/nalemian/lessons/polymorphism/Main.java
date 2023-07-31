package ru.nalemian.lessons.polymorphism;

public class Main {
    public static void main(String[] args) {
        Teacher physicist = new Physicist();
        physicist.teaching();
        Teacher mathematician = new Mathematician();
        mathematician.teaching();
    }
}
