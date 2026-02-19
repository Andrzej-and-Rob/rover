package com.example.rover.drivenadapters;

import com.example.rover.core.applesauce.Rover;
import com.example.rover.core.drivenports.ForStoringRovers;

import java.util.Optional;

public class InMemoryRepository implements ForStoringRovers {
    @Override
    public void save(Rover rover) {

    }

    @Override
    public Optional<Rover> find() {
        return Optional.empty();
    }
}
