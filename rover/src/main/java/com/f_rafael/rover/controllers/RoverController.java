package com.f_rafael.rover.controllers;

import com.f_rafael.rover.dto.CommandDto;
import com.f_rafael.rover.dto.RoverDto;
import com.f_rafael.rover.models.Rover;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RoverController {

    @GetMapping("/rover")
    public Rover get(){

        return null;
    }

    @PostMapping("/rover")
    public void create(@RequestBody RoverDto rover){
        System.out.println(rover);

    }

    @PostMapping("/rover/command")
    public void sendCommand(@RequestBody CommandDto commands){
        System.out.println(commands);

    }
}
