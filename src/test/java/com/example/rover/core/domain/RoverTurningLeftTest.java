package com.example.rover.core.domain;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RoverTurningLeftTest {

    @Test
    void rover_turns_left_when_pointing_north() {
        Rover rover = new Rover(new Position(new Coordinates(1, 2), Direction.NORTH));

        Rover turnedRover = rover.turnLeft();

        assertThat(turnedRover)
                .isEqualTo(new Rover(new Position(new Coordinates(1, 2), Direction.WEST)));
    }

    @Test
    void rover_turns_left_when_pointing_west() {
        Rover rover = new Rover(new Position(new Coordinates(1, 2), Direction.WEST));

        Rover turnedRover = rover.turnLeft();

        assertThat(turnedRover)
                .isEqualTo(new Rover(new Position(new Coordinates(1, 2), Direction.SOUTH)));
    }
}
