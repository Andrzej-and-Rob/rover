package com.example.rover.acceptance;

import org.htmlunit.WebClient;
import org.htmlunit.html.*;
import org.htmlunit.javascript.host.event.KeyboardEvent;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureMockMvc
class PlaceRoverTest {

    @Autowired
    private WebClient webClient;

    @Test
    void clicking_Place_Rover_returns_rover_position_page() throws IOException {
        HtmlPage indexPage = webClient.getPage("/");

        HtmlForm htmlForm = indexPage.getForms().getFirst();
        HtmlPage roverPositionPage = htmlForm.getInputByValue("Place Rover").click();

        assertThat(roverPositionPage.getTitleText())
                .isEqualTo("Rover Position");
    }

    @Test
    void position_page_shows_rover_position() throws IOException {
        HtmlPage indexPage = webClient.getPage("/");
        HtmlForm htmlForm = indexPage.getForms().getFirst();
        HtmlPage roverPositionPage = htmlForm.getInputByValue("Place Rover").click();

        HtmlBody body = roverPositionPage.getBody();

        assertThat(body.asNormalizedText()).contains("(0, 0) N");
    }

    @Test
    void rover_placed_at_given_position() throws IOException {
        HtmlPage indexPage = webClient.getPage("/");
        HtmlForm htmlForm = indexPage.getForms().getFirst();
        HtmlInput xCoordinateInput = htmlForm.getInputByName("x-coordinate");
        HtmlInput yCoordinateInput = htmlForm.getInputByName("y-coordinate");
        xCoordinateInput.type(KeyboardEvent.DOM_VK_DELETE);
        xCoordinateInput.type("4");
        yCoordinateInput.type(KeyboardEvent.DOM_VK_DELETE);
        yCoordinateInput.type("5");

        HtmlSelect direction = htmlForm.getSelectByName("direction");
        HtmlOption eastOption = direction.getOptionByValue("EAST");
        direction.setSelectedAttribute(eastOption, true);

        HtmlPage roverPositionPage = htmlForm.getInputByValue("Place Rover").click();

        HtmlBody body = roverPositionPage.getBody();

        assertThat(body.asNormalizedText()).contains("(4, 5) E");
    }

    @Test
    @Disabled("unfinished, refer to notes related to 2026-05-08")
    void rover_can_move_forward_one_square() throws IOException {
        HtmlPage indexPage = webClient.getPage("/");
        HtmlForm htmlForm = indexPage.getForms().getFirst();
        HtmlPage roverPositionPage = htmlForm.getInputByValue("Place Rover").click();

        HtmlBody body = roverPositionPage.getBody();

        assertThat(body.asNormalizedText()).contains("(0, 0) N");
    }
}
