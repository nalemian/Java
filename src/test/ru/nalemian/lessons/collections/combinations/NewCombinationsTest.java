package ru.nalemian.lessons.collections.combinations;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static ru.nalemian.lessons.collections.combinations.NewCombinations.newCombinations;

class NewCombinationsTest {

    /**
     * Демонстрация комбинаций для любого объекта
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

    }

    /**
     * Комбинации для трех чисел
     */
    @Test
    void testIntegers_3() {
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
    }

    /**
     * комбинации для 5 чисел
     */
    @Test
    void testIntegers_5() {
        List<Integer> integerElements = new LinkedList<>();
        List<List<Integer>> allIntegerCombinations = new LinkedList<>();
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