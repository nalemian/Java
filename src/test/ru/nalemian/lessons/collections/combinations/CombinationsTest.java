package ru.nalemian.lessons.collections.combinations;

import org.junit.jupiter.api.Test;
import ru.nalemian.lessons.collections.combinations.Combinations;
import ru.nalemian.lessons.teacher.NewTeacher;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static ru.nalemian.lessons.collections.combinations.Combinations.combinations;

class CombinationsTest {

    @Test
    void testThatMethodPrintAllCombinations() {
        List<String> stringElements = new LinkedList<>();
        stringElements.add("Cow");
        stringElements.add("Horse");
        stringElements.add("Pig");
        List<List<String>> allStringCombinations = new LinkedList<>();
        for (int i = 1; i <= stringElements.size(); i++) {
            allStringCombinations.addAll(combinations(stringElements, i));
            System.out.println("все комбинации размера " + i + " готовы");
        }
        assertTrue(allStringCombinations.contains(stringElements));
        System.out.println(allStringCombinations);


        List<Integer> integerElements = new LinkedList<>();
        integerElements.add(1);
        integerElements.add(2);
        integerElements.add(3);
        List<List<Integer>> allIntegerCombinations = new LinkedList<>();
        for (int i = 1; i <= integerElements.size(); i++)
            allIntegerCombinations.addAll(combinations(integerElements, i));
        assertTrue(allIntegerCombinations.contains(integerElements));
        System.out.println(allIntegerCombinations);


        List<NewTeacher> newTeacherElements = new LinkedList<>();
        newTeacherElements.add(new NewTeacher("физика"));
        newTeacherElements.add(new NewTeacher("математика"));
        newTeacherElements.add(new NewTeacher("биология"));
        List<List<NewTeacher>> allNewTeacherCombinations = new LinkedList<>();
        for (int i = 1; i <= newTeacherElements.size(); i++)
            allNewTeacherCombinations.addAll(combinations(newTeacherElements, i));
        assertTrue(allNewTeacherCombinations.contains(newTeacherElements));
        System.out.println(allNewTeacherCombinations);


        List<List<String>> listForSize0 = new LinkedList<>(combinations(stringElements, 0));
        List<List<Object>> empty = new LinkedList<>();
        empty.add(Collections.emptyList());
        assertEquals(listForSize0, empty);
        System.out.println(listForSize0);


        List<String> listWithNoElements = new LinkedList<>();
        List<List<String>> listWithoutElements = new LinkedList<>(combinations(listWithNoElements, 1));
        assertEquals(listWithoutElements, Collections.emptyList());
        System.out.println(listWithoutElements);
    }

    @Test
    void testArrayOfIntegers() {
        List<Integer> integers = List.of(1, 2, 3);

        var expected = List.of(
                List.of(1),
                List.of(2),
                List.of(3),
                List.of(1, 2),
                List.of(1, 3),
                List.of(2, 3),
                List.of(1, 2, 3)
        );
        //var result = Combinations.combinations(integers); где такой метод?
        var result = Combinations.combinations(integers, integers.size());

        assertEquals(expected.size(), result.size());

        for (List<Integer> integerList : expected) {
            assertTrue(result.contains(integerList));
        }


    }
}