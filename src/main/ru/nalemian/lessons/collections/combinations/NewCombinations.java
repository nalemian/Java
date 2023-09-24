package ru.nalemian.lessons.collections.combinations;

import java.util.LinkedList;
import java.util.List;

public class NewCombinations {
    public static <Object> List<List<Object>> newCombinations(List<Object> elements, List<List<Object>> combinations) {
        List<Object> theFirstElement = new LinkedList<>();
        List<List<Object>> combCopy = new LinkedList<>(combinations);
        if (combinations.size() > 0) {
            for (List<Object> iterat1 : combCopy) {
                List<Object> oneLineCombinations = new LinkedList<>();
                for (Object iterat2 : iterat1) {
                    oneLineCombinations.add(iterat2);
                }
                oneLineCombinations.add(elements.get(0));
                combinations.add(oneLineCombinations);
            }
        }
        theFirstElement.add(elements.get(0));
        combinations.add(theFirstElement);
        elements.remove(0);
        if (!(elements.size() == 0)) {
            newCombinations(elements, combinations);
        }
        return combinations;
    }
}
