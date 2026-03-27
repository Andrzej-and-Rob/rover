package com.example.rover.drivingadapters;

import com.example.rover.core.applesauce.Position;
import com.example.rover.core.applesauce.RoverService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RoverController {

    private final RoverService roverService;

    public RoverController(RoverService roverService) {
        this.roverService = roverService;
    }

    @GetMapping
    String viewIndex(Model model) {
        model.addAttribute("position", "(5, 7) E");
        return "index";
    }

    @PostMapping
    String viewRoverPosition(Model model) {
        roverService.placeRover();
        Position position = roverService.roverPosition();
        model.addAttribute("position", position.display());
        return "rover-position";
    }
}
