package src.services;

import java.util.List;

import src.appService.ConvertService;

public class ConvertNumberToWords implements ConvertService<Integer, String, String> {

    @Override
    public String convert(List<Integer> listOfIntegers, List<String> wordsList) {
        int size = listOfIntegers.size();
        //0-10
        if(size == 1) {
            return wordsList.get(listOfIntegers.get(0));
        }
        if(size == 2){
            //11-19
            if(listOfIntegers.get(0) == 1){
                if(listOfIntegers.get(1) != 3){
                    String numberWords = wordsList.get(listOfIntegers.get(1));
                    int sub = numberWords.length() - 1;
                    if(listOfIntegers.get(1) == 2){
                        return  numberWords.substring(0, sub) + "енадцать";
                    }
                    return  numberWords.substring(0, sub)+ "надцать";
                } else {
                    return wordsList.get(listOfIntegers.get(1)) + "надцать";
                }
            } else {
                //20-39 
                if((listOfIntegers.get(0) < 4)){
                    if(listOfIntegers.get(1) == 0){
                        return wordsList.get(listOfIntegers.get(0)) + "дцать";
                    } else {
                      return wordsList.get(listOfIntegers.get(0)) + "дцать " + wordsList.get(listOfIntegers.get(1));
                    }
                    
                }
                //40-49
                if((listOfIntegers.get(0) == 4)) {
                    if(listOfIntegers.get(1) == 0){
                        return wordsList.get(14);
                    } else {
                        return wordsList.get(14) + " " + wordsList.get(listOfIntegers.get(1));
                    }   
                }
                //90-99
                if((listOfIntegers.get(0) == 9)){
                    if(listOfIntegers.get(1) == 0){
                        return wordsList.get(9).substring(0, wordsList.get(1).length()) + "носто";
                    } else {
                        return wordsList.get(9).substring(0, wordsList.get(1).length()) + "носто " +  wordsList.get(listOfIntegers.get(1));
                    }
                }
                if((listOfIntegers.get(1) == 0)){
                    return wordsList.get(listOfIntegers.get(0)) + "десят";
                } else {
                    return wordsList.get(listOfIntegers.get(0)) + "десят " +  wordsList.get(listOfIntegers.get(1));
                }
            }
        }
        return "null";
    }
}
