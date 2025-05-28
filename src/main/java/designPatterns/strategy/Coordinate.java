package src.main.java.designPatterns.strategy;


public class Coordinate {
    int x;
    int y;
    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    int getXCoordinate() {
        return this.x;
    }

    int getYCoordinate() {
        return this.y;
    }

}