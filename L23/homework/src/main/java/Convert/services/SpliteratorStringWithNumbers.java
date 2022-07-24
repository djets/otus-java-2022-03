package Convert.services;

import Convert.exception.DoubleInputException;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpliteratorStringWithNumbers {

    //@Override
    public static ArrayDeque<Integer> spliterator(String numbers) {
        List<String> listOfNumberByString = new ArrayList<String>(Arrays.asList(numbers.split("")));
        ArrayDeque<Integer> listOfIntegers = new ArrayDeque<>();
        listOfNumberByString.forEach(v -> {
            try {
                listOfIntegers.add(numberParseInt(v));
            } catch (DoubleInputException e) {
                System.out.println((char) 27 + "[31m" + "ОШИБКА: " + (char) 27 + "[0m" + e.getMessage());
                System.exit(1);
            }
        });
        return listOfIntegers;
    }

    static int numberParseInt(String number) throws DoubleInputException {
        try {
            return Integer.parseInt(number);
        } catch (Exception e) {
            throw new DoubleInputException("Ввод не целого числа.");
        }
    }
}
