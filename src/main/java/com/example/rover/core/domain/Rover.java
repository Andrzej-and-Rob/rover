package com.example.rover.core.domain;

import java.util.Objects;

public class Rover {

    private final Position position;

    public Rover() {
        this(new Position(new Coordinates(0, 0), Direction.NORTH));
    }

    public Rover(Position position) {
        this.position = position;
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

    public Rover turnLeft() {
        return new Rover(new Position(position.coordinates(), Direction.WEST));
    }

    @Override
    public String toString() {
        return "Rover{" +
                "position=" + position +
                '}';
    }
}
