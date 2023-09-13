package org.petproject.minesweeper.logic;

import org.petproject.minesweeper.constant.GameConstantClass;
import org.petproject.minesweeper.constant.GameState;

public class State {
    private Game game = GameConstantClass.getGame();
    private GameState gameState;

    public State() {
        setGameState(GameState.PLAYING);
    }

    public String getMessage() {
        return switch (gameState) {
            case BOMBED -> "Nice try, but unfortunately you lose";
            case WINNER -> "My congratulations!!! You are a winner!!!";
            default -> "Think twice";
        };
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }
}
