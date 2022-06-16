package ru.otus.testsUnit;
import ru.otus.game.*;
import java.util.HashSet;
import java.util.Set;

public class Tests {
    //Первый тест
    public void diceImplTestOne(int low, int high) throws ExceptionsGame {
        //Тестирование метода подброса костей 1
        System.out.println("\n1. Тестирование метода подброса костей (по условию диапазон от 1-6):");
        int dice = new DiceImpl().roll();
        if (dice < low || dice > high) {
            throw new ExceptionsGame("Ошибка: число " + dice + " за пределами заданного в условии диапазона (" + low + "-" + high + ").\n");
        }
        else {
            System.out.println((char)27 + "[33m" + "Тест пройден успешно");
        }
    }

    public void diceImplTestTwo(int numberRoll) throws ExceptionsGame {
        //Тестирование метода подброса костей 2
        Dice dice = new DiceImpl();
        System.out.println("2. Тестирование метода подброса костей\nвыпадающие значения не должны постоянно совпадать.\nКоличество бросков - " + numberRoll);
        Set<Integer> setRoll = new HashSet<>();
        for (int i = 1; i <= numberRoll; i++){
            setRoll.add(dice.roll());
        }
        if (numberRoll - setRoll.size() > numberRoll - 1){
           throw new ExceptionsGame("Ошибка: метод dice.roll() выдает постоянное значение.\n");
        }
        else {
            System.out.println((char)27 + "[33m" + "Тест пройден успешно");
        }
    }
    public void gameTestOne() throws ExceptionsGame {
        //Создаем экземпляры заглушек
        Dice diceStub = new DiceImplStub();
        GameWinnerPrinter winnerPrinterTest = new GameWinnerConsolePrinterStub();
        Game gameTest = new Game(diceStub, winnerPrinterTest);
        Player first = new Player("First");
        Player second = new Player("Second");
        System.out.println((char)27 + "[0m" + "\n3. Тестирование равного результата бросков костей:");
            gameTest.playGame(first, second);
    }
}

