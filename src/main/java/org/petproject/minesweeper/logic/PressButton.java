package org.petproject.minesweeper.logic;

import org.petproject.minesweeper.constant.Coordinates;
import org.petproject.minesweeper.constant.GameConstantClass;
import org.petproject.minesweeper.constant.GameState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PressButton {

    private Game game = GameConstantClass.getGame();
    private final Recursion recursion;

    @Autowired
    public PressButton(Recursion recursion) {
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
