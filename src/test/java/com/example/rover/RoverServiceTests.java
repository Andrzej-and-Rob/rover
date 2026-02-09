package com.example.rover;

import com.example.rover.core.applesauce.*;
import com.example.rover.core.drivenports.ForStoringRovers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

class RoverServiceTests {
    @Test
    void should_place_the_rover_at_0_0_north() {
        ForStoringRovers repository = Mockito.mock(ForStoringRovers.class);
        RoverService roverService = new RoverService(repository);

        roverService.placeRover();

        Position expectedPosition = new Position(new Coordinates(0,0), Direction.NORTH);
        assertThat(roverService.roverPosition()).isEqualTo(expectedPosition);
    }

    @Test
    void should_save_a_placed_rover() {
        ForStoringRovers repository = Mockito.mock(ForStoringRovers.class);
        RoverService roverService = new RoverService(repository);

        roverService.placeRover();

        verify(repository).save(Mockito.any(Rover.class));
    }

}
