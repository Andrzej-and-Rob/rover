package com.example.rover;

import com.example.rover.core.applesauce.*;
import com.example.rover.core.drivenports.ForStoringRovers;
import com.example.rover.drivenadapters.InMemoryRepository;
import org.junit.jupiter.api.Test;

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
        Position fiveSixNorth = new Position(fiveSix, Direction.NORTH);

        roverService.placeRover(fiveSixNorth);

        assertThat(roverService.roverPosition()).isEqualTo(fiveSixNorth);
    }

    @Test
    void should_place_a_rover_at_given_position() {
        // TODO: could be separated into a common setup
        ForStoringRovers repository = new InMemoryRepository();
        RoverService roverService = new RoverService(repository);
        Position fiveSixWest = new Position(new Coordinates(5, 6), Direction.WEST);

        roverService.placeRover(fiveSixWest);

        assertThat(roverService.roverPosition()).isEqualTo(fiveSixWest);
    }

    @Test
    void should_throw_exception_when_no_rover_has_been_placed() {
        ForStoringRovers repository = new InMemoryRepository();
        RoverService roverService = new RoverService(repository);

        assertThatThrownBy(roverService::roverPosition)
                .isInstanceOf(NoSuchRoverException.class)
                .hasMessage("No rover found");
    }
}
