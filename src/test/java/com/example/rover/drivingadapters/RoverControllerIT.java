package com.example.rover.drivingadapters;

import com.example.rover.core.applesauce.Coordinates;
import com.example.rover.core.applesauce.Position;
import com.example.rover.core.applesauce.RoverService;
import org.htmlunit.WebClient;
import org.htmlunit.html.HtmlPage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.assertj.MockMvcTester;

import java.io.IOException;

import static com.example.rover.core.applesauce.Direction.EAST;
import static org.assertj.core.api.Assertions.assertThat;
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

        assertThat(indexPage.getBody().asNormalizedText()).contains("(5, 7) E");
    }
}