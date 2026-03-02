package com.example.rover.drivingadapters;

import com.example.rover.core.applesauce.Coordinates;
import com.example.rover.core.applesauce.Position;
import com.example.rover.core.applesauce.RoverService;
import org.htmlunit.WebClient;
import org.htmlunit.html.HtmlForm;
import org.htmlunit.html.HtmlPage;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.assertj.MockMvcTester;

import java.io.IOException;

import static com.example.rover.core.applesauce.Direction.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.BDDMockito.given;

@WebMvcTest(RoverController.class)
class RoverControllerIT {
    @MockitoBean
    RoverService roverService;

    @Autowired
    private WebClient webClient;

    @Autowired
    private MockMvcTester mvc;

    @Test
    void should_render_the_rover_position_when_rover_placed() throws IOException {
        given(roverService.roverPosition()).willReturn(new Position(new Coordinates(5, 7), EAST));

        HtmlPage indexPage = webClient.getPage("/");
        HtmlForm htmlForm = indexPage.getForms().getFirst();
        HtmlPage roverPositionPage = htmlForm.getInputByValue("Place Rover").click();

        assertThat(roverPositionPage.getBody().asNormalizedText()).contains("(5, 7) E");
    }

    @Test
    @Disabled
    void should_render_the_rover_position_when_rover_placed_elsewhere() throws IOException {
        given(roverService.roverPosition()).willReturn(new Position(new Coordinates(1, 3), WEST));

        HtmlPage indexPage = webClient.getPage("/");
        HtmlForm htmlForm = indexPage.getForms().getFirst();
        HtmlPage roverPositionPage = htmlForm.getInputByValue("Place Rover").click();

        assertThat(roverPositionPage.getBody().asNormalizedText()).contains("(1, 3) W");
    }

    @Test
    void should_add_rover_position_attribute_to_model_when_rover_placed() {
        Position fiveFourSouth = new Position(new Coordinates(5, 4), SOUTH);
        given(roverService.roverPosition())
                .willReturn(fiveFourSouth);

        then(mvc.post().uri("/"))
                .model()
                .containsEntry("position", "(5, 4) S");
    }
}