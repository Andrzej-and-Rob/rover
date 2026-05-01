package com.example.rover.core.applesauce;

import java.util.Objects;

public class Rover {

    private final Coordinates coordinates;
    private Position position;

    public Rover() {
        this(new Coordinates(0, 0));
    }

    public Rover(Position position) {
        this();
        this.position = position;
    }

    public Rover(Coordinates coordinates) {
        this.coordinates = coordinates;
        this.position = new Position(coordinates, Direction.NORTH);
    }

    @Override
    public String toString() {
        return "Rover{" +
                "coordinates=" + coordinates +
                ", direction=N" +
                '}';
    }

    public Coordinates coordinates() {
        return coordinates;
    }

    public Position position() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Rover rover = (Rover) o;
        return Objects.equals(coordinates, rover.coordinates);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(coordinates);
    }
}
