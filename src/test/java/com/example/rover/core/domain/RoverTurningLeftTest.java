package com.example.rover.core.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class RoverTurningLeftTest {

    @Test
    void rover_turns_left_when_pointing_west() {
        Rover rover = new Rover(new Position(new Coordinates(1, 2), Direction.WEST));

        Rover turnedRover = rover.turnLeft();

        assertThat(turnedRover)
                .isEqualTo(new Rover(new Position(new Coordinates(1, 2), Direction.SOUTH)));
    }

    @ParameterizedTest
    @CsvSource({"NORTH, WEST"})
    void rover_turns_left(Direction start, Direction expected) {
        Rover rover = new Rover(new Position(new Coordinates(1, 2), start));

        Rover turnedRover = rover.turnLeft();

        assertThat(turnedRover)
                .isEqualTo(new Rover(new Position(new Coordinates(1, 2), expected)));
    }
}
