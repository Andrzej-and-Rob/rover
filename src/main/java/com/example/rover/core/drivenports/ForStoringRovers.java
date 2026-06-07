package com.example.rover.core.drivenports;

import com.example.rover.core.domain.Rover;

import java.util.Optional;

public interface ForStoringRovers {
    void save(Rover rover);

    Optional<Rover> find();
}
