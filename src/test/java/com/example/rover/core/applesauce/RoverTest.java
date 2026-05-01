package com.example.rover.core.applesauce;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RoverTest {
    @Test
    void should_have_a_toString_showing_the_coordinates() {
        Rover rover = new Rover(new Position(new Coordinates(1, 2), Direction.NORTH));

        assertThat(rover)
                .hasToString("Rover{coordinates=Coordinates[x=1, y=2], direction=N}");
    }

}