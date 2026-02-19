package com.example.rover.drivenadapters;

import com.example.rover.core.applesauce.Coordinates;
import com.example.rover.core.applesauce.Rover;
import com.example.rover.core.drivenports.ForStoringRovers;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class InMemoryRepositoryTest {
    @Test
    void should_return_an_empty_rover_initially() {
        ForStoringRovers repository = new InMemoryRepository();

        Optional<Rover> rover = repository.find();

        assertThat(rover).isEmpty();
    }

    @Test
    void should_save_and_retrieve_a_rover() {
        ForStoringRovers repository = new InMemoryRepository();
        Rover rover = new Rover(new Coordinates(4, 6));

        repository.save(rover);
        Optional<Rover> resultOfFind = repository.find();

        assertThat(resultOfFind)
                .contains(rover);
    }
}