package com.example.rover.acceptance;

import org.htmlunit.WebClient;
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
class PlaceRoverTest {

    @Autowired
    private WebClient webClient;

    @Test
    void clicking_Place_Rover_returns_rover_position_page() throws IOException {
        HtmlPage indexPage = webClient.getPage("/");

        HtmlForm htmlForm = indexPage.getForms().getFirst();
        HtmlPage roverPosition = htmlForm.getInputByValue("Place Rover").click();

        assertThat(roverPosition.getTitleText())
                .isEqualTo("Rover Position");
    }
}
