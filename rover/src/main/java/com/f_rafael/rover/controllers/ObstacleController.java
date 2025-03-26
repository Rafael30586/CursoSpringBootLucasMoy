package com.f_rafael.rover.controllers;

import com.f_rafael.rover.dto.ObstacleDto;
import com.f_rafael.rover.dto.RoverDto;
import com.f_rafael.rover.models.Obstacle;
import com.f_rafael.rover.services.ObstacleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class ObstacleController {

    @Autowired
    private ObstacleService service;

    @PostMapping("/obstacle")
    public void create(@RequestBody ObstacleDto obstacle){
        System.out.println(obstacle);

    }

    @GetMapping("/obstacle")
    public List<Obstacle> getAll(){
        return service.findAll();
    }
}
