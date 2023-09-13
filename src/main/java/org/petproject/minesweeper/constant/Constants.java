package org.petproject.minesweeper.constant;


import java.util.ArrayList;
import java.util.Random;

public class Constants {
    public static final Integer IMAGE_SIZE = 50;
    public static final Integer ROWS = 10, COLS = 10;

    private static Integer totalBombs = 16;
    private static Coordinates size;
    private static ArrayList<Coordinates> allCoordinates;
    private static final Random random = new Random();

    public static void setSize(Coordinates _size) {
        size = _size;
        allCoordinates = new ArrayList<>();
        for (int y = 0; y < size.getY(); y++) {
            for (int x = 0; x < size.getX(); x++) {
                allCoordinates.add(new Coordinates(x, y));
            }
        }
    }

    public static Coordinates getSize() {
        return size;
    }

    public static ArrayList<Coordinates> getAllCoordinates() {
        return allCoordinates;
    }

    public static boolean inRange(Coordinates cord) {
        return cord.getX() >= 0 && cord.getX() < Constants.size.getX() &&
                cord.getY() >= 0 && cord.getY() < Constants.size.getY();
    }

    public static Coordinates getRandomCoordinate() {
        return new Coordinates(random.nextInt(size.getX()), random.nextInt(size.getY()));
    }

    public static ArrayList<Coordinates> getCoordinatesAround(Coordinates cord) {

        Coordinates aroundCord;
        ArrayList<Coordinates> list = new ArrayList<Coordinates>();
        for (int x = cord.getX() - 1; x <= cord.getX() + 1; x++) {
            for (int y = cord.getY() - 1; y <= cord.getY() + 1; y++) {
                if (Constants.inRange(aroundCord = new Coordinates(x, y))) {
                    if (!aroundCord.equals(cord)) {
                        list.add(aroundCord);
                    }
                }
            }
        }

        return list;
    }

    public static Integer getTotalBomb() {
        int maxBombs = (Constants.ROWS * Constants.COLS) / 2;
        if (totalBombs > maxBombs) {
            totalBombs = maxBombs;
        }
        return totalBombs;
    }
}
