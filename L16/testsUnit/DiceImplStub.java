package ru.otus.testsUnit;

import ru.otus.game.Dice;

class DiceImplStub implements Dice {
    @Override
    public int roll() {
        return 1;
    }
}
