package ru.nalemian.lessons.polymorphism;

public class SchoolWorkingProcess {
    public static void main(String[] args) {
        Lesson physicsLesson = new PhysicsLesson();
        Lesson mathLesson = new MathLesson();
        Teacher mathematician = new Mathematician();
        Teacher physicist = new Physicist();
        mathematician.startLesson(physicsLesson);
        mathematician.startLesson(mathLesson);
        physicist.startLesson(mathLesson);
        physicist.startLesson(physicsLesson);
    }
}
