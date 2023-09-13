package org.petproject.minesweeper.logic;

import org.petproject.minesweeper.constant.*;
import org.springframework.stereotype.Component;

@Component
public class Recursion {

    private Game game = GameConstantClass.getGame();

    protected void openBox(Coordinates cord) {
        switch (game.getFlag().getBoxFlag(cord)) {
            case FLAGGED -> {
                return;
            }
            case OPENED -> {
                setOpenedToClosedBoxesAroundNumber(cord);
            }
            case CLOSED -> {
                switch (game.getBomb().getBoxBomb(cord)) {
                    case ZERO -> {
                        openBoxesAround(cord);
                    }
                    case BOMB -> {
                        openBombs(cord);
                    }
                    default -> {
                        game.getFlag().setOpenedToBox(cord);
                    }
                }
            }
        }
    }

    private void openBombs(Coordinates bomb) {
        game.getState().setGameState(GameState.BOMBED);
        game.getFlag().setBombedToBox(bomb);
        for (Coordinates cord : Constants.getAllCoordinates()) {
            if (game.getBomb().getBoxBomb(cord) == Box.BOMB) {
                game.getFlag().setOpenedToClosedBombBox(cord);
            } else {
                game.getFlag().setNoBombToFlaggedSafeBox(cord);
            }
        }
    }

    private void openBoxesAround(Coordinates cord) {
        game.getFlag().setOpenedToBox(cord);
        for (Coordinates around : Constants.getCoordinatesAround(cord)) {
            openBox(around);
        }
    }

    public void setOpenedToClosedBoxesAroundNumber(Coordinates cord) {
        if (game.getBomb().getBoxBomb(cord) != Box.BOMB) {
            if (game.getFlag().getCountOfFlaggedBoxes(cord).equals(game.getBomb().getBoxBomb(cord).getNumber())) {
                for (Coordinates around : Constants.getCoordinatesAround(cord)) {
                    if (game.getFlag().getBoxFlag(around) == Box.CLOSED) {
                        openBox(around);
                    }
                }
            }
        }
    }
    public boolean gameOver() {
        if (game.getState().getGameState() == GameState.PLAYING) {
            return false;
        }
        GameConstantClass.setGame(new Game(Constants.COLS, Constants.ROWS, Constants.getTotalBomb()));
        GameConstantClass.getGame().setBomb(new Bomb(Constants.getTotalBomb()));
        GameConstantClass.getGame().setFlag(new Flag());
        GameConstantClass.getGame().setState(new State());
        return true;
    }
}
