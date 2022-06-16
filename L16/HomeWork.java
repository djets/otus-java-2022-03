package ru.otus;


import ru.otus.testsUnit.ExceptionsGame;
import ru.otus.testsUnit.Tests;

public class HomeWork {

    /*
        Заготовка для ДЗ представляет собой игру в кости.
        При вызове game.playGame(), два игрока кидают кости.
        Выигрывает игрок, у кого результат (1-6) больше

        Написать тесты (минимум 4) на классы DiceImpl и Game.
        Тесты должны найти не менее двух ошибок.

        Информацию о пройденном тесте предлагается выводить в System.out, а об упавшем в System.err
     */



    public static void main(String[] args) {
        Tests tests = new Tests();
        try {
            tests.diceImplTestOne(1, 6);
        }
        catch (ExceptionsGame eOne) {
            //Не могу понять почему System.err выводит сразу все
            System.err.println(eOne.getMessage());
        }
        try {
            tests.diceImplTestTwo(6);
        } catch (ExceptionsGame eTwo) {
            System.err.println(eTwo.getMessage());
        }
        try {
            tests.gameTestOne();
        } catch (RuntimeException | ExceptionsGame eThree) {
            System.err.println(eThree.getMessage());
        }
    }
    }

