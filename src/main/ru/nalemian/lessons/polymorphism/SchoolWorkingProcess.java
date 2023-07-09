package ru.nalemian.lessons.polymorphism;

public class SchoolWorkingProcess {
    public static void main(String[] args)  {
        Lesson physicsLesson=new PhysicsLesson();
        Lesson mathLesson=new MathLesson();
        Teacher mathematician=new Mathematician();
        Teacher physicist=new Physicist();
        mathematician.startLesson(((PhysicsLesson) physicsLesson).name); //узнать почему
        mathematician.startLesson(((MathLesson) mathLesson).name);
        physicist.startLesson(((MathLesson) mathLesson).name);
        physicist.startLesson(((PhysicsLesson) physicsLesson).name);
    }
}
