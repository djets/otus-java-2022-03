package src.main.java.convert.services;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import src.main.java.convert.appService.SpliteratorString;
import src.main.java.convert.exception.DoubleInputException;

public class SpliteratorStringWithNumbers implements SpliteratorString<String, Integer>{

    private ArrayDeque<Integer> listOfIntegers = new ArrayDeque<>();
    
    @Override
    public void spliterator(String numbers) {
        List<String> listOfNumberByString = new ArrayList<String>(Arrays.asList(numbers.split("")));

        listOfNumberByString.forEach(v -> {
            try {
                listOfIntegers.add(numberParseInt(v));
            } catch (DoubleInputException e) {
                System.out.println((char)27 + "[31m" + "ОШИБКА: " + (char)27 + "[0m" + e.getMessage());
                System.exit(1);
            }
        });
    }

    @Override
    public ArrayDeque<Integer> getListNumbers() {
        return listOfIntegers;
    }
    
    int numberParseInt (String number) throws DoubleInputException{
        try {
            return Integer.parseInt(number);
        } catch (Exception e) {
            throw new DoubleInputException("Ввод не целого числа."); 
        }  
        //return 0; 
    }
}
