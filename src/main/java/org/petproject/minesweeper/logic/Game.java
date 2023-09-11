package org.petproject.minesweeper.logic;

import org.petproject.minesweeper.constant.Box;
import org.petproject.minesweeper.constant.Constants;
import org.petproject.minesweeper.constant.Coordinates;
import org.springframework.stereotype.Component;

public class Game {
    private Bomb bomb;
    private Flag flag;

    public Game(int cols, int rows, int bombs) {
        Constants.setSize(new Coordinates(cols, rows));
        bomb = new Bomb(bombs);
        flag = new Flag();
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
}
