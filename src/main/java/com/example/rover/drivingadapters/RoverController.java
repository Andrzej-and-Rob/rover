package com.example.rover.drivingadapters;

import com.example.rover.core.applesauce.Rover;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

// TODO: Naming changes: Change Controller (really an adapter), maybe change method

@Controller
public class RoverController {
    public RoverController(Rover rover) {
        this.rover = rover;
    }

    private Rover rover;

    @GetMapping
    String viewIndex(Model model) {
        return "index";
    }

    @PostMapping
    String viewRoverPosition(Model model) {
        return "rover-position";
    }
}
