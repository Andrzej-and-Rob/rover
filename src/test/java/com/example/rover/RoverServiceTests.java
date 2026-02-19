package com.example.rover;

import com.example.rover.core.applesauce.*;
import com.example.rover.core.drivenports.ForStoringRovers;
import com.example.rover.drivenadapters.InMemoryRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

class RoverServiceTests {
    @Test
    void should_place_the_rover_at_0_0_north() {
        ForStoringRovers repository = new InMemoryRepository();
        RoverService roverService = new RoverService(repository);

        roverService.placeRover();

        Position expectedPosition = new Position(new Coordinates(0,0), Direction.NORTH);
        assertThat(roverService.roverPosition()).isEqualTo(expectedPosition);
    }

    @Test
    void should_save_a_placed_rover_at_given_location() {
        ForStoringRovers repository = Mockito.mock(ForStoringRovers.class);
        RoverService roverService = new RoverService(repository);
        Coordinates fiveSix = new Coordinates(5, 6);

        roverService.placeRover(fiveSix);

        verify(repository).save(new Rover(fiveSix));
    }

    @Disabled("Creating a repository implementation")
    @Test
    void applesauce() {
        ForStoringRovers repository = new InMemoryRepository();
        RoverService roverService = new RoverService(repository);
        Coordinates fiveSix = new Coordinates(5, 6);

        roverService.placeRover(fiveSix);

        Position expectedPosition = new Position(fiveSix, Direction.NORTH);
        assertThat(roverService.roverPosition()).isEqualTo(expectedPosition);
    }

}
