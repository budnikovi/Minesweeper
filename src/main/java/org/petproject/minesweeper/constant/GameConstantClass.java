package org.petproject.minesweeper.constant;

import org.petproject.minesweeper.logic.Game;

public class GameConstantClass {
    private static Game game = new Game(Constants.COLS, Constants.ROWS, Constants.getTotalBomb());

    public static Game getGame() {
        return game;
    }

    public static void setGame(Game game) {
        GameConstantClass.game = game;
    }
}
