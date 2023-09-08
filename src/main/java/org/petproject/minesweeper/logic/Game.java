package org.petproject.minesweeper.logic;

import org.petproject.minesweeper.constant.Box;
import org.petproject.minesweeper.constant.Constants;
import org.petproject.minesweeper.constant.Coordinates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Game {
    private Bomb bomb;

    public Game() {
    }

    public Game(int cols, int rows, int bombs) {
        Constants.setSize(new Coordinates(cols, rows));
        bomb = new Bomb(bombs);
    }

    public Box getBoxGame(Coordinates cord) {
        return bomb.getBoxBomb(cord);
    }

    public Bomb getBomb() {
        return bomb;
    }

    public void start() {
        bomb.start();
    }
}
