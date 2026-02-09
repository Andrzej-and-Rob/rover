package com.example.rover.core.applesauce;

import com.example.rover.core.drivenports.ForStoringRovers;

public class RoverService {
    private final ForStoringRovers repository;

    public RoverService(ForStoringRovers repository) {
        this.repository = repository;
    }

    public void placeRover() {
        repository.save(new Rover());
    }

    public Position roverPosition() {
        return new Position(new Coordinates(0,0), Direction.NORTH);
    }

    public void placeRover(Coordinates coordinates) {
        repository.save(new Rover(coordinates));
    }
}
