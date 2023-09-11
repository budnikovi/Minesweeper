package org.petproject.minesweeper.logic;

import org.petproject.minesweeper.constant.Box;
import org.petproject.minesweeper.constant.Coordinates;

public class Flag {

    private final Matrix flagMap;

    public Flag() {
        flagMap = new Matrix(Box.CLOSED);
    }

    Box getBoxFlag(Coordinates cord) {
        return flagMap.getMatrixCord(cord);
    }

    public void setOpenedToBox(Coordinates cord) {
        flagMap.setMatrixCord(cord, Box.OPENED);
    }

    public void setFlaggedToBox(Coordinates cord) {
        if (flagMap.getMatrixCord(cord) == Box.FLAGGED) {
            flagMap.setMatrixCord(cord, Box.CLOSED);
        } else if (flagMap.getMatrixCord(cord) == Box.CLOSED){
            flagMap.setMatrixCord(cord, Box.FLAGGED);
        }
    }

    public Matrix getFlagMap() {
        return flagMap;
    }
}
