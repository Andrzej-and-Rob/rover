package com.example.rover.drivenadapters;

import com.example.rover.core.applesauce.Rover;
import com.example.rover.core.drivenports.ForStoringRovers;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class InMemoryRepository implements ForStoringRovers {

    private Rover rover;

    @Override
    public void save(Rover rover) {
        this.rover = rover;
    }

    @Override
    public Optional<Rover> find() {
        return Optional.ofNullable(rover);
    }
}
