package ru.nalemian.lessons.polymorphism;

public class Physicist extends Teacher {
    @Override
    public void teaching() {
        System.out.println("Я учу физике!");
    }
    @Override
    public void startLesson(String lessonName) {
        if(lessonName=="физика") {
            System.out.println("начинаю урок '"+lessonName+"'");
            Lesson physicsLesson=new PhysicsLesson();
            physicsLesson.schoolSubject();
            Student student1=new BadStudent();
            askHomework(student1, lessonName);
            Student student2=new ExcellentStudent();
            askHomework(student2, lessonName);
        } else {
            System.out.println(lessonName+" - не мой предмет");
            Lesson mathLesson=new MathLesson();
            mathLesson.schoolSubject();
        }
    }
    @Override
    public void askHomework(Student student, String name) {
        student.giveHomework();
        if(student.homework) {
            System.out.println("молодец, "+student.studentName+"! Ставлю 5 по предмету '"+name+"'");
        } else {
            System.out.println("очень плохо, "+student.studentName+"! Ставлю 2 по предмету '"+name+"'");
        }
    }
}
