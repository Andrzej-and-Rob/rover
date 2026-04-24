package com.example.rover.drivingadapters;

import com.example.rover.core.applesauce.NoSuchRoverException;
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

    @GetMapping("/")
    String viewIndex() {
        return "index";
    }

    @PostMapping("/")
    String placeRover() {
        roverService.placeRover();
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
}
