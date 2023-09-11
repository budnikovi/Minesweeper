package org.petproject.minesweeper.constant;

import org.petproject.minesweeper.logic.Game;
import org.springframework.stereotype.Component;

@Component
public class GameConstantClass {
    private static final Game game = new Game(Constants.COLS, Constants.ROWS, Constants.getTotalBomb());

    public static Game getGame() {
        return game;
    }

}
