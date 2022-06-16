package ru.otus.testsUnit;

import ru.otus.game.GameWinnerPrinter;
import ru.otus.game.Player;

class GameWinnerConsolePrinterStub implements GameWinnerPrinter {
    @Override
    public void printWinner(Player testWinner) {
        try {
            //if (testWinner != null) {
            throw new ExceptionsGame("Ошибка: метод playGame класса Game не обрабатывает условие. \n");
            //}
        } catch (ExceptionsGame e) {
            throw new RuntimeException(e);
        }
    }

}
