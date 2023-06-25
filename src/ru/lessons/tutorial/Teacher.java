package ru.lessons.tutorial;
public class Teacher {
    public void teaching() {
        System.out.println("Я обучаю!");
    }
    public static class Physicist extends Teacher {
        public void teaching() {
            System.out.println("Я учу физике!");
        }
    }
    public static class Mathematician extends Teacher {
        public void teaching() {
            System.out.println("Я учу математике!");
        }
    }
}
class Main {
    public static void main(String[] args) {
        Teacher physicist = new Teacher.Physicist();
        physicist.teaching();
        Teacher mathematician=new Teacher.Mathematician();
        mathematician.teaching();
    }
}
