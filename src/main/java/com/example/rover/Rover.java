package com.example.rover;

public class Rover {
    private Position position = new Position(new Coordinates(0, 0), Direction.NORTH);

    public void place() {
    }

    public Position getPosition() {
        return position;
    }
}
