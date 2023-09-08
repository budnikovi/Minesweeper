package org.petproject.minesweeper.logic;

import org.petproject.minesweeper.constant.Box;
import org.petproject.minesweeper.constant.Constants;
import org.petproject.minesweeper.constant.Coordinates;

import java.util.ArrayList;

public class Bomb {
    private Matrix bombMap;
    private Integer totalBombs;

    Bomb(int totalBombs) {
        this.totalBombs = totalBombs;
    }

    void start() {
        bombMap = new Matrix(Box.ZERO);
        placeBomb();
    }

    Box getBoxBomb(Coordinates cord) {
        return bombMap.getMatrixCord(cord);
    }

    private void placeBomb() {
        int count = 0;
        while (true) {
            if (count == totalBombs) {
                break;
            }
            Coordinates cord = Constants.getRandomCoordinate();
            if (Box.BOMB != bombMap.getMatrixCord(cord)) {
                bombMap.setMatrixCord(cord, Box.BOMB);
                NumbersAroundBomb(cord);
                count++;
            }
        }
    }

    private void NumbersAroundBomb(Coordinates cord) {
        for (Coordinates aroundBomb : Constants.getCoordinatesAroundBomb(cord)) {
            if (Box.BOMB != bombMap.getMatrixCord(aroundBomb)) {
                bombMap.setMatrixCord(aroundBomb, bombMap.getMatrixCord(aroundBomb).getNumberAroundBomb());
            }
        }
    }
}
