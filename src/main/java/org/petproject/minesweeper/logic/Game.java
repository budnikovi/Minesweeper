package org.petproject.minesweeper.logic;

import org.petproject.minesweeper.constant.*;

import java.util.Objects;

public class Game {
    private Bomb bomb;
    private Flag flag;
    private State state;

    public Game(int cols, int rows, int bombs) {
        Constants.setSize(new Coordinates(cols, rows));
        bomb = new Bomb(bombs);
        flag = new Flag();
        state = new State();
    }

    public void checkWinner() {
        if (state.getGameState() == GameState.PLAYING) {
            if (Objects.equals(flag.getCountOfClosedBoxes(), bomb.getTotalBombs())) {
                state.setGameState(GameState.WINNER);
            }
        }
    }



    public Box getBoxGame(Coordinates cord) {
        if (flag.getBoxFlag(cord) == Box.OPENED) {
            return bomb.getBoxBomb(cord);
        } else {
            return flag.getBoxFlag(cord);
        }
    }

    public Bomb getBomb() {
        return bomb;
    }

    public void start() {
        bomb.start();
    }

    public Flag getFlag() {
        return flag;
    }

    public State getState() {
        return state;
    }

    public void setBomb(Bomb bomb) {
        this.bomb = bomb;
    }

    public void setFlag(Flag flag) {
        this.flag = flag;
    }

    public void setState(State state) {
        this.state = state;
    }
}
