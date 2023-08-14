package ru.nalemian.lessons.teacher;

import org.junit.jupiter.api.Test;
import ru.nalemian.lessons.polymorphism.*;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

class KnowledgeTest {
    @Test
    void main() {
        Physicist physicist = new Physicist("физика");
        physicist.teaching();
        Mathematician mathematician = new Mathematician("математика");
        mathematician.teaching();
        Lesson mathLesson = new MathLesson();
        Lesson physicsLesson = new PhysicsLesson();
        Collection<Student> studentCollection = new ArrayList<>();
        Student badStudent = new BadStudent();
        Student excellentStudent = new ExcellentStudent();
        studentCollection.add(badStudent);
        studentCollection.add(excellentStudent);
        mathematician.teachLesson(mathLesson, studentCollection);
        mathematician.teachLesson(mathLesson, studentCollection);
        mathematician.teachLesson(physicsLesson, studentCollection);
        physicist.teachLesson(physicsLesson, studentCollection);
        physicist.teachLesson(physicsLesson, studentCollection);
        physicist.teachLesson(mathLesson, studentCollection);
        for (Student student : studentCollection) {
            for (Knowledge knowledge : student.getKnowledges()) {
                if("физика".equals(knowledge.getLessonName())) {
                    System.out.println(true);
                }
                if("математика".equals(knowledge.getLessonName())) {
                    System.out.println(true);
                }
            }
        }
    }
}
