package com.example.rover.core.domain;

import java.util.Objects;

import static com.example.rover.core.domain.Direction.*;

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
        Direction direction = switch (position.direction()) {
            case NORTH -> WEST;
            case WEST -> SOUTH;
            case SOUTH -> EAST;
            case null, default -> position.direction();
        };
        return new Rover(new Position(position.coordinates(), direction));
    }

    @Override
    public String toString() {
        return "Rover{" +
                "position=" + position +
                '}';
    }
}
