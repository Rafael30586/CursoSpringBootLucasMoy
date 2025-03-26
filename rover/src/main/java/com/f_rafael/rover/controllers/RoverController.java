package com.f_rafael.rover.controllers;

import com.f_rafael.rover.dto.CommandDto;
import com.f_rafael.rover.dto.RoverDto;
import com.f_rafael.rover.models.Rover;
import com.f_rafael.rover.services.RoverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class RoverController {

    @Autowired
    private RoverService service;

    @GetMapping("/rover")
    public Rover get(){
        return service.get();
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
