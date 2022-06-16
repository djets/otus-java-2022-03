package ru.otus.game;

import ru.otus.logging.LoggerExample;

import java.util.logging.Level;

public class Game {

    private final Dice dice;
    private final GameWinnerPrinter winnerPrinter;

    //LoggerExample loggerExample = new LoggerExample();

    public Game(Dice dice, GameWinnerPrinter winnerPrinter) {
        this.dice = dice;
        this.winnerPrinter = winnerPrinter;
    }

    public void playGame(Player player1, Player player2) {
        int player1Result = dice.roll();
        //loggerExample.getLogger().log(Level.INFO, "Бросок player1 = " + player1Result);
        int player2Result = dice.roll();
        //loggerExample.getLogger().log(Level.INFO, "Бросок player2 = " + player2Result);
        Player winner = (player1Result > player2Result)? player1: player2;
        winnerPrinter.printWinner(winner);
    }
}
