package org.petproject.minesweeper.constant;


public class Coordinates {
    private final int x;
    private final int y;

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
        if (o instanceof Coordinates cord) {
            return cord.getX() == x && cord.getY() == y;
        }
        return false;
    }
}
