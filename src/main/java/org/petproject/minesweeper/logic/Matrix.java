package org.petproject.minesweeper.logic;

import org.petproject.minesweeper.constant.Box;
import org.petproject.minesweeper.constant.Constants;
import org.petproject.minesweeper.constant.Coordinates;

class Matrix {
    private final Box[][] matrix;

    Matrix(Box defaultBox) {
        matrix = new Box[Constants.getSize().getX()][Constants.getSize().getY()];
        for (Coordinates cord : Constants.getAllCoordinates()) {
            matrix[cord.getX()][cord.getY()] = defaultBox;
        }
    }

    Box getMatrixCord(Coordinates cord) {
        if (!Constants.inRange(cord)) {
            return null;
        }
        return matrix[cord.getX()][cord.getY()];
    }
    void setMatrixCord(Coordinates cord,Box box) {
        if (Constants.inRange(cord)) {
            matrix[cord.getX()][cord.getY()] = box;
        }

    }
}
