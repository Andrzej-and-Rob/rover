package com.example.rover.core.domain;

import com.example.rover.core.drivenports.ForStoringRovers;
import org.springframework.stereotype.Service;

@Service
public class RoverService {
    private final ForStoringRovers repository;

    public RoverService(ForStoringRovers repository) {
        this.repository = repository;
    }

    public void placeRover() {
        repository.save(new Rover());
    }

    public void placeRover(Position position) {
        repository.save(new Rover(position));
    }

    public Position roverPosition() {
        return repository.find()
                .orElseThrow(() -> new NoSuchRoverException("No rover found"))
                .position();
    }

    public void turnRoverLeft() {
        Rover rover = repository.find()
                .orElseThrow(() -> new NoSuchRoverException("No rover found"));
        Rover turnedRover = rover.turnLeft();
        repository.save(turnedRover);
    }
}
