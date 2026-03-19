package com.example.rover.drivingadapters;

import com.example.rover.core.applesauce.Position;
import com.example.rover.core.applesauce.RoverService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RoverController {

    private final RoverService roverService;

    public RoverController(RoverService roverService) {
        this.roverService = roverService;
    }

    @GetMapping
    String viewIndex(Model model) {
        return "index";
    }

    @PostMapping
    ModelAndView viewRoverPosition(Model model) {
        ModelAndView modelAndView = new ModelAndView("rover-position");
        roverService.placeRover();
        Position position = roverService.roverPosition();
        modelAndView.addObject("position", position.display());
        return modelAndView;
    }
}
