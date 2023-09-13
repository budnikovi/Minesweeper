package org.petproject.minesweeper.logic;

import org.petproject.minesweeper.constant.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;
@Component
public class Game {
    private Bomb bomb;
    private Flag flag;
    private State state;
    private Constants constants;

    public Game() {
        constants = new Constants();
        Constants.setSize(new Coordinates(constants.COLS,constants.ROWS));
        bomb = new Bomb(Constants.getTotalBomb(constants));
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
