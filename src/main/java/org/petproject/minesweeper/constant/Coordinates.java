package org.petproject.minesweeper.constant;


public class Coordinates {
    private int x;
    private int y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof  Coordinates) {
            Coordinates cord = (Coordinates) o;
            return cord.getX() == x && cord.getY() == y;
        }
        return false;
    }
}
