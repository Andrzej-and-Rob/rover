package com.example.rover.core.applesauce;

import com.example.rover.core.drivenports.RoverRepository;

public class RoverService {
    private final RoverRepository repository;

    public RoverService(RoverRepository repository) {
        this.repository = repository;
    }

    public void placeRover() {
        repository.save(new Rover());
    }

    public Position roverPosition() {
        return new Position(new Coordinates(0,0), Direction.NORTH);
    }
}
