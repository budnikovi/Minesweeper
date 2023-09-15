package org.petproject.minesweeper.logic;

import org.petproject.minesweeper.constant.Box;
import org.petproject.minesweeper.constant.Constants;
import org.petproject.minesweeper.constant.Coordinates;

public class Flag {

    private final Matrix flagMap;
    private Integer flagCounter = 0;
    private Integer countOfClosedBoxes = Constants.ROWS * Constants.COLS;

    public Flag() {
        flagMap = new Matrix(Box.CLOSED);
    }

    Box getBoxFlag(Coordinates cord) {
        return flagMap.getMatrixCord(cord);
    }

    public void setBombedToBox(Coordinates cord) {
        flagMap.setMatrixCord(cord, Box.BOMBED);
    }

    public void setOpenedToBox(Coordinates cord) {
        flagMap.setMatrixCord(cord, Box.OPENED);
        countOfClosedBoxes--;
    }

    public void setFlaggedToBox(Coordinates cord) {
        flaggedCellChecking(cord);
    }

    public void flaggedCellChecking(Coordinates cord) {
        if (flagMap.getMatrixCord(cord) == Box.FLAGGED) {
            flagMap.setMatrixCord(cord, Box.CLOSED);
            flagCounter--;
        } else if (flagMap.getMatrixCord(cord) == Box.CLOSED) {
            flagMap.setMatrixCord(cord, Box.FLAGGED);
            flagCounter++;
        }
    }

    public Integer getCountOfClosedBoxes() {
        return countOfClosedBoxes;
    }


    public void setOpenedToClosedBombBox(Coordinates cord) {
        if (flagMap.getMatrixCord(cord) == Box.CLOSED) {
            flagMap.setMatrixCord(cord, Box.OPENED);
        }
    }

    public void setNoBombToFlaggedSafeBox(Coordinates cord) {
        if (flagMap.getMatrixCord(cord) == Box.FLAGGED) {
            flagMap.setMatrixCord(cord, Box.NOBOMB);
        }
    }

    public Integer getCountOfFlaggedBoxes(Coordinates cord) {
        int count = 0;
        for (Coordinates around : Constants.getCoordinatesAround(cord)) {
            if (flagMap.getMatrixCord(around) == Box.FLAGGED) {
                count++;
            }
        }
        return count;
    }
}
