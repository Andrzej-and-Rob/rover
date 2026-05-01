package com.example.rover.core.applesauce;

import java.util.Objects;

public class Rover {

    private final Position position;

    public Rover() {
        this(new Position(new Coordinates(0, 0), Direction.NORTH));
    }

    public Rover(Position position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Rover{" +
                "coordinates=" + position.coordinates() +
                ", direction=N" +
                '}';
    }

    public Position position() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Rover rover = (Rover) o;
        return Objects.equals(position, rover.position);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(position);
    }
}
