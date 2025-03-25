package com.f_rafael.rover.controllers;

import com.f_rafael.rover.dto.ObstacleDto;
import com.f_rafael.rover.dto.RoverDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ObstacleController {

    @PostMapping("/rover")
    public void create(@RequestBody ObstacleDto obstacle){
        System.out.println(obstacle);

    }
}
