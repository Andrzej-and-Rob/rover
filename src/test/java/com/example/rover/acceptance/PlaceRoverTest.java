package com.example.rover.acceptance;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

public class PlaceRoverTest {

    @Test
    @Disabled
    @Tag("Manual")
    void rover_is_placed_at_0_0() {
        // Given we are on Fake Mars
        // When the Sky Crane places the Rover
        // Then the Rover is at (0, 0) N
        fail("This is a manual test to verify rover placement at initial position");
    }
}
