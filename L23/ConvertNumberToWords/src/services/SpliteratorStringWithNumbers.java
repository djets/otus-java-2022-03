package src.services;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import src.appService.SpliteratorString;
import src.exception.DoubleInputException;

public class SpliteratorStringWithNumbers implements SpliteratorString{

    private List<Integer> listOfIntegers = new ArrayList<>();
    
    @Override
    public void spliteratorString(String number) {
        List<String> listOfNumberByString = new ArrayList<String>(Arrays.asList(number.split("")));
        //listOfNumberByString.forEach(System.out::println);
        listOfNumberByString.forEach(v -> listOfIntegers.add(numberParseInt(v))); //не обработаны исключения
    }

    @Override
    public List<Integer> getListNumbers() {
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
