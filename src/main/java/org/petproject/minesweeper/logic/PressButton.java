package org.petproject.minesweeper.logic;

import org.petproject.minesweeper.constant.Coordinates;
import org.petproject.minesweeper.constant.GameState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PressButton {

    private final Game game;
    private final Recursion recursion;

    @Autowired
    public PressButton(Game game, Recursion recursion) {
        this.game = game;
        this.recursion = recursion;
    }

    public void pressLeftButton(Coordinates cord) {
        if (recursion.gameOver()) {
            game.getState().setGameState(GameState.PLAYING);
            return;
        }
        recursion.openBox(cord);
        game.checkWinner();

    }

    public void pressRightButton(Coordinates cord) {
        game.getFlag().setFlaggedToBox(cord);
    }
}
