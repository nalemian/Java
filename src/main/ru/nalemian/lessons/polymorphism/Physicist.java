package ru.nalemian.lessons.polymorphism;

public class Physicist extends Teacher {
    @Override
    public void teaching() {
        System.out.println("Я учу физике!");
    }

    @Override
    public void startLesson(Lesson newLesson) {
        Student student1 = new BadStudent();
        Student student2 = new ExcellentStudent();
        String newLessonName = newLesson.getLessonName();
        if (newLessonName.equals("физика")) {
            System.out.println("начинаю урок '" + newLessonName + "'");
            newLesson.start();
            askHomework(student1, newLessonName);
            askHomework(student2, newLessonName);
        } else {
            System.out.println(newLessonName + " - не мой предмет");
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
