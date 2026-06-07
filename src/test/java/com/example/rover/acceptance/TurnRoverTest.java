package com.example.rover.acceptance;

import org.htmlunit.WebClient;
import org.htmlunit.html.HtmlBody;
import org.htmlunit.html.HtmlForm;
import org.htmlunit.html.HtmlPage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureMockMvc
class TurnRoverTest {

    @Autowired
    private WebClient webClient;

    @Test
    void rover_can_turn_left_by_90_degrees() throws IOException {
        HtmlPage indexPage = webClient.getPage("/");
        HtmlForm htmlForm = indexPage.getForms().getFirst();
        HtmlPage roverPositionPage = htmlForm.getInputByValue("Place Rover").click();

        HtmlForm roverControls = roverPositionPage.getForms().getFirst();
        HtmlPage afterTurningLeft = roverControls.getInputByValue("Left").click();

        HtmlBody body = afterTurningLeft.getBody();
        assertThat(body.asNormalizedText()).contains("(0, 0) W");
    }
}
