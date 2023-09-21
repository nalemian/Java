package ru.nalemian.lessons.collections;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static ru.nalemian.lessons.collections.NewCombinations.newCombinations;

class NewCombinationsTest {
    /*
     здесь тестируются комбинации
    */
    @Test
    void testThatMethodPrintAllCombinations() {
        List<String> stringElements = new LinkedList<>();
        stringElements.add("Cow");
        stringElements.add("Horse");
        stringElements.add("Pig");
        List<List<String>> allStringCombinations = new LinkedList<>();
        System.out.println(newCombinations(stringElements, allStringCombinations));
        assertEquals(allStringCombinations.size(), 7);
        for (String stringElement : stringElements) {
            assertTrue(allStringCombinations.contains(stringElement));
        }

        List<Integer> integerElements = new LinkedList<>();
        integerElements.add(1);
        integerElements.add(2);
        integerElements.add(3);
        List<List<Integer>> allIntegerCombinations = new LinkedList<>();
        System.out.println(newCombinations(integerElements, allIntegerCombinations));
        assertEquals(allIntegerCombinations.size(), 7);
        for (Integer integerElement : integerElements) {
            assertTrue(allIntegerCombinations.contains(integerElement));
        }

        integerElements.add(1);
        integerElements.add(2);
        integerElements.add(3);
        integerElements.add(4);
        integerElements.add(5);
        allIntegerCombinations.removeAll(allIntegerCombinations);
        System.out.println(newCombinations(integerElements, allIntegerCombinations));
        assertEquals(allIntegerCombinations.size(), 31);
        for (Integer integerElement : integerElements) {
            assertTrue(allIntegerCombinations.contains(integerElement));
        }
    }
}