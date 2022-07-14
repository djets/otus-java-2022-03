package src.main.java.convert.services;

import src.main.java.convert.appService.OutputService;
import src.main.java.convert.domain.AvailableCurrency;

public class appRuner {
    private static InputConsole inputConsole = new InputConsole();
    private static OutputService outConsole = new OutputConsole();
    
    public static void run(){
        outConsole.outputStrings("Проектная работа по курсу OTUS Java.Developer.Basic 2022.\nПриложение - Цена прописью.\n");
        outConsole.outputStrings("Введите цену для конвертации цены \nили наберите \"exit\" для выхода из программы.");
        runConvert();  
    }
    static void runConvert(){
        SpliteratorStringWithNumbers split = new SpliteratorStringWithNumbers();
        split.spliterator(inputConsole.inputString());
        ConvertToRus convertToRus = new ConvertToRus();
        int lastChar = split.getListNumbers().peekLast();
        outConsole.outputStrings(convertToRus.convert(split.getListNumbers()) + AvailableCurrency.RUB.declinationCurrency(lastChar));
    }
}
