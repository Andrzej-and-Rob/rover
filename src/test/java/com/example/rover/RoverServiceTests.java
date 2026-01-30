package com.example.rover;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RoverServiceTests {
    @Test
    void should_place_the_rover_at_0_0_north() {
        RoverService roverService = new RoverService();
        roverService.placeRover();
        Position expectedPosition = new Position(new Coordinates(0,0), Direction.NORTH);
        assertThat(roverService.roverPosition()).isEqualTo(expectedPosition);
    }

}
