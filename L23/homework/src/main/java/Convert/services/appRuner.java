package Convert.services;

import java.util.ArrayDeque;

import Convert.appService.OutputService;
import Convert.domain.AvailableCurrency;

public class appRuner {
    private static InputConsole inputConsole = new InputConsole();
    private static OutputService outConsole = new OutputConsole();
    
    public static void run(){
        outConsole.outputStrings("Проектная работа по курсу OTUS Java.Developer.Basic 2022.\nПриложение - Цена прописью.\n");
        outConsole.outputStrings("Введите целое число для конвертации цены \nили наберите \"exit\" для выхода из программы.");
        try {
            runConvert();
        } catch (Exception e) {
            e.getMessage();
        }  
    }
    static void runConvert() throws Exception{
        ArrayDeque<Integer> split = SpliteratorStringWithNumbers.spliterator(inputConsole.inputString());
        int lastChar = split.peekLast();
        try {
           outConsole.outputStrings(new ConvertToRus().convert(split) + AvailableCurrency.RUB.declinationCurrency(lastChar));
        } catch (Exception e) {
           throw new Exception("Ошибка конвертации.");
        }
    }
}
