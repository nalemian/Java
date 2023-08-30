package ru.nalemian.lessons.collections;

import java.util.*;

public class Combinations {
    public static <Object> List<List<Object>> combinations(List<Object> elements, int size) {
        List<List<Object>> allCombinations = new LinkedList<>();
        if (0 == size) {
            System.out.println("для комбинации достаточно элементов");
            List<List<Object>> replacement = new LinkedList<>();
            replacement.add(Collections.emptyList());
            return replacement; //[[]]
        }
        if (elements.isEmpty()) {
            System.out.println("элементы закончились");
            return Collections.emptyList(); //возвращает []
        }
        Object currentElement = elements.get(0);
        List<Object> untouchedElements = new LinkedList<>(elements);
        untouchedElements.remove(currentElement);
        System.out.println("Size при просмотре количества элементов для комбинации: " + size);
        List<List<Object>> remainingElements = combinations(untouchedElements, size - 1);
        System.out.println("remainingElements сейчас: " + remainingElements);
        for (List<Object> element : remainingElements) {
            System.out.println("Size при заполнении коллекции: " + size);
            List<Object> onOfTheCombinations = new LinkedList<>(element);
            onOfTheCombinations.add(0, currentElement);
            allCombinations.add(onOfTheCombinations);
            System.out.println("onOfTheCombinations: " + onOfTheCombinations);
            System.out.println("allCombinations: " + allCombinations);
        }
        allCombinations.addAll(combinations(untouchedElements, size));
        System.out.println("вывод: " + allCombinations);
        return allCombinations;
    }
}