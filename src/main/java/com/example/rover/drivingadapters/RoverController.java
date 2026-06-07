package com.example.rover.drivingadapters;

import com.example.rover.core.domain.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RoverController {

    private final RoverService roverService;

    public RoverController(RoverService roverService) {
        this.roverService = roverService;
    }

    @GetMapping("/")
    String viewIndex() {
        return "index";
    }

    @PostMapping("/")
    String placeRover(@RequestParam("x-coordinate") int xCoordinate,
                      @RequestParam("y-coordinate") int yCoordinate,
                      @RequestParam("direction") Direction direction) {
        roverService.placeRover(new Position(new Coordinates(xCoordinate, yCoordinate), direction));
        return "redirect:/rover-position";
    }

    @GetMapping("/rover-position")
    String viewRoverPositionNew(Model model) {
        try {
            Position position = roverService.roverPosition();
            model.addAttribute("position", position.display());
        } catch (NoSuchRoverException _) {
            model.addAttribute("position", "No Rover");
        }
        return "rover-position";
    }

    @PostMapping("/rover-position")
    String turnRoverLeft() {
        roverService.turnRoverLeft();
        return "redirect:/rover-position";
    }
}
