package com.example.rover;

import com.example.rover.core.applesauce.Coordinates;
import com.example.rover.core.applesauce.Direction;
import com.example.rover.core.applesauce.Position;
import com.example.rover.core.applesauce.RoverService;
import com.example.rover.core.drivenports.ForStoringRovers;
import com.example.rover.drivenadapters.InMemoryRepository;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RoverServiceTests {
    @Test
    void should_place_the_rover_at_0_0_north() {
        ForStoringRovers repository = new InMemoryRepository();
        RoverService roverService = new RoverService(repository);

        roverService.placeRover();

        Position expectedPosition = new Position(new Coordinates(0, 0), Direction.NORTH);
        assertThat(roverService.roverPosition()).isEqualTo(expectedPosition);
    }

    @Test
    void should_place_a_rover_at_given_location() {
        ForStoringRovers repository = new InMemoryRepository();
        RoverService roverService = new RoverService(repository);
        Coordinates fiveSix = new Coordinates(5, 6);

        roverService.placeRover(fiveSix);

        Position expectedPosition = new Position(fiveSix, Direction.NORTH);
        assertThat(roverService.roverPosition()).isEqualTo(expectedPosition);
    }

    @Test
    void should_throw_exception_when_no_rover_has_been_placed() {
        ForStoringRovers repository = new InMemoryRepository();
        RoverService roverService = new RoverService(repository);

        assertThatThrownBy(roverService::roverPosition)
                .isInstanceOf(NoSuchElementException.class);
    }
}
