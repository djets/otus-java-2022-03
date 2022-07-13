package src.services;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import src.appService.Spliterator;
import src.exception.DoubleInputException;

public class SpliteratorStringWithNumbers implements Spliterator{

    //private List<Integer> listOfIntegers = new ArrayList<>();
    private ArrayDeque<Integer> listOfIntegers = new ArrayDeque<>();
    
    @Override
    public void spliterator(String numbers) {
        List<String> listOfNumberByString = new ArrayList<String>(Arrays.asList(numbers.split("")));
        //listOfNumberByString.forEach(System.out::println);
        listOfNumberByString.forEach(v -> listOfIntegers.add(numberParseInt(v))); //не обработаны исключения
    }

    @Override
    public ArrayDeque<Integer> getListNumbers() {
        return listOfIntegers;
    }
    
    int numberParseInt (String number){
        try {
            if(!number.equals(".") || !number.equals(","))
         return Integer.parseInt(number);
        } catch (Exception e) {
            new DoubleInputException("Dot");  
        }  
        return 0; 
    }
}
