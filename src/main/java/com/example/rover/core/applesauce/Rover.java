package com.example.rover.core.applesauce;

import java.util.Objects;

public class Rover {

    private final Coordinates coordinates;

    public Rover() {
        this(new Coordinates(0, 0));
    }

    public Rover(Coordinates coordinates) {
        this.coordinates = coordinates;
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
