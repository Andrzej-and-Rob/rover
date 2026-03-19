package com.example.rover.core.applesauce;

public record Position(Coordinates coordinates, Direction direction) {
    public String display() {
        return "(%d, %d) %s".formatted(coordinates().x(),
                coordinates().y(),
                direction().toString().substring(0, 1));
    }
}
