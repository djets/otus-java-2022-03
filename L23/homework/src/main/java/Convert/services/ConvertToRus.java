package Convert.services;

import Convert.appService.ConvertService;
import Convert.domain.NumbersOfWordsRus;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class ConvertToRus implements ConvertService<ArrayDeque<Integer>, String>{
    
    protected String convertString;

    public ConvertToRus(){
        convertString = "";
    }

    @Override
    public String convert(ArrayDeque<Integer> inputStringsNumber){

        List<String> wordsList = NumbersOfWordsRus.getWordsList();
        //передоваемый остаток  
        int transmittedRemainsOfBlocks;
        //Количество делений
        int numberOfBlocks;
        //остаток
        int remainsOfBlocks = inputStringsNumber.size() % 3;
           
        if(remainsOfBlocks > 0){
            numberOfBlocks = inputStringsNumber.size() / 3 + 1;
            transmittedRemainsOfBlocks = remainsOfBlocks;
        } else {
            numberOfBlocks = inputStringsNumber.size() / 3;
            transmittedRemainsOfBlocks = 3;
        };

        for(int i = 0; i < numberOfBlocks; i++){
            //Инициализация блока с тремя или менее числами
            List<Integer> blocks = new ArrayList<>();
            for (int p = 1; p <= transmittedRemainsOfBlocks; p++) {
                blocks.add((inputStringsNumber.pollFirst()));
            }
            //Вызов метода конвертации блока чисел
            upToAThousand(blocks, wordsList, transmittedRemainsOfBlocks);
            //Проверка на присутсвие в блоке только нулей
            if(!checkingFullZero(blocks)) {
                //проверка на окончание в блоке от 10 до 19
                if(blocks.size() > 1 && blocks.get(blocks.size() - 2) == 1) {
                    convertString += getNumeralString(numberOfBlocks, i, 5);
                } else {
                    convertString += getNumeralString(numberOfBlocks, i, blocks.get(blocks.size() - 1));
                }
            }
            if(i < numberOfBlocks - 1){
                convertString += " ";
            }
            transmittedRemainsOfBlocks = 3;
        }
        //Удаление пробелов в конце строки
        if(convertString.endsWith(" ")){
            convertString = convertString.substring(0, convertString.length() - 1);
        }
        //Вывод строи с удалением двойных пробелов
        return convertString.replace("  ", " ");
    }

    //Преобразование трехзначных чисел
    void upToAThousand(List<Integer> blocks, List<String> wordsList, int transmittedRemainsOfBlocks){
        if(transmittedRemainsOfBlocks == 3){
            if(blocks.get(0) == 1) {
                convertString += wordsList.get(17) + " ";
            }
            if(blocks.get(0) == 2) {
                convertString += wordsList.get(12) + wordsList.get(19) + " ";
            }
            if(blocks.get(0) == 3 || blocks.get(0) == 4) {
                convertString += wordsList.get(blocks.get(0)) + wordsList.get(18) + " ";
            }
            if(blocks.get(0) > 4 && blocks.get(0) <= 9) {
                convertString += wordsList.get(blocks.get(0)) + wordsList.get(20) + " ";
            }
            
            if(!checkingZero(blocks)) {
                transmittedRemainsOfBlocks -= 1;  
                upToAHundred(blocks, transmittedRemainsOfBlocks, wordsList, 1);     
            } else {
                convertString = convertString.substring(0, convertString.length() - 1);
            }
        } else {upToAHundred(blocks, transmittedRemainsOfBlocks, wordsList, 0);}
    }
    //Преобразование двухзначных чисел
    void upToAHundred(List<Integer> blocks, int transmittedRemainsOfBlocks, List<String> wordsList, int i){
        //0-9
        if(transmittedRemainsOfBlocks == 1) {
            convertString += wordsList.get(blocks.get(0 + i));
        }
        
        if(transmittedRemainsOfBlocks == 2){
            if(blocks.get(0 + i) == 0){
                convertString += wordsList.get(blocks.get(1 + i));
            } 
            //11-19
            if(blocks.get(0 + i) == 1){

                if(blocks.get(1) != 3){
                    final String numberWords = wordsList.get(blocks.get(1 + i));
                    if(blocks.get(1 + i) == 2){
                        convertString += numberWords.substring(0, numberWords.length() - 1) + "енадцать";
                    } else {
                        //10
                        if(blocks.get(0 + i) == 1 && blocks.get(1 + i) == 0) {
                            convertString += wordsList.get(10) + "->";
                        } else {
                            convertString += numberWords.substring(0, numberWords.length() - 1)+ "надцать";
                        }
                    }   
                } else {
                    convertString += wordsList.get(blocks.get(1 + i)) + "надцать";
                }
            } else {
                //20-39 
                if(blocks.get(0 + i) == 2 || blocks.get(0 + i) == 3){
                    if(blocks.get(1) == 0){
                        convertString += wordsList.get(blocks.get(0 + i)) + "дцать";
                    } else {
                        convertString += wordsList.get(blocks.get(0 + i)) + "дцать " + wordsList.get(blocks.get(1 + i));
                    }
                }
                //40-49
                if((blocks.get(0 + i) == 4)) {
                    if(blocks.get(1 + i) == 0){
                        convertString += wordsList.get(14);
                    } else {
                        convertString += wordsList.get(14) + " " + wordsList.get(blocks.get(1 + i));
                    }   
                }
                //90-99
                if((blocks.get(0 + i) == 9)){
                    if(blocks.get(1 + i) == 0){
                        convertString += wordsList.get(9).substring(0, wordsList.get(1).length()) + "носто";
                    } else {
                        convertString += wordsList.get(9).substring(0, wordsList.get(1).length()) + "носто " +  wordsList.get(blocks.get(1 + i));
                    }
                }
                //50,60,70... 
                if(blocks.get(0 + i) > 4 && blocks.get(0 + i) < 9){
                    if(blocks.get(1 + i) == 0) {
                        convertString += wordsList.get(blocks.get(0 + i)) + "десят";
                    }else {
                        convertString += wordsList.get(blocks.get(0 + i)) + "десят " +  wordsList.get(blocks.get(1 + i));
                    } 
                } 
            }
        }
    }
    //Разряды чисел
    enum Numerals {
        THOUSANDS {
            public String declination(int lastNumber) {
                if(lastNumber == 1)
                    return new String(" тысяча ");
                if(lastNumber >= 2 && lastNumber <= 4)
                    return new String(" тысячи ");
                if(lastNumber >=5 || lastNumber <=9 || lastNumber == 0)
                    return new String(" тысяч ");
                return new String(" тыс. ");
            }
        },
        MILLIONS{
            public String declination(int lastNumber) {
                if(lastNumber == 1)
                    return new String(" миллион ");
                if(lastNumber >= 2 && lastNumber <= 4)
                    return new String(" миллиона ");
                if(lastNumber >=5 || lastNumber <=9 || lastNumber == 0)
                    return new String(" миллионов ");
                return new String(" млн. ");
            }
        },
        MILLIARDS{
            public String declination(int lastNumber) {
                if(lastNumber == 1)
                    return new String(" миллиард ");
                if(lastNumber >= 2 && lastNumber <= 4)
                    return new String(" миллиарда ");
                if(lastNumber >=5 || lastNumber <=9 || lastNumber == 0)
                    return new String(" миллиардов ");
                return new String(" мрд. ");
            }
        };
        public abstract String declination(int lastNumber);   
    }
    //Запрос разряда числа
    private static String getNumeralString(int iterationQuantity, int iterate, int lastNum) {
        
        if(iterate == 0 && iterationQuantity == 2) {
            return Numerals.THOUSANDS.declination(lastNum);
        }

        if(iterate == 0 && iterationQuantity == 3) {
            return Numerals.MILLIONS.declination(lastNum);
        }
        if(iterate == 1 && iterationQuantity == 3) {
            return Numerals.THOUSANDS.declination(lastNum);
        }

        if(iterate == 0 && iterationQuantity == 4) {
            return Numerals.MILLIARDS.declination(lastNum);
        }
        if(iterate == 1 && iterationQuantity == 4) {
            return Numerals.MILLIONS.declination(lastNum);
        }
        if(iterate == 2 && iterationQuantity == 4) {
            return Numerals.THOUSANDS.declination(lastNum);
        }

        return "";
    }
    //Проверка нулей в остатке для чисел 100, 200, 1000 и т.д.
    private static boolean checkingZero(List<Integer> listOfIntegers) {
        //if(listOfIntegers.get(1)== 0 && listOfIntegers.size() == 2)
        //    return true;
        if(listOfIntegers.size() > 1){
            if(listOfIntegers.get(1) == 0 && listOfIntegers.get(2) == 0)
            return true;
        }
        return false;
    }
    //Проверка на присутсвие в блоке только нулей
    private static boolean checkingFullZero(List<Integer> listOfIntegers) {
    if(listOfIntegers.size() == 3){
        if(listOfIntegers.get(0) == 0 && listOfIntegers.get(1) == 0 && listOfIntegers.get(2) == 0)
        return true;
    }
    return false;
    }     
}
