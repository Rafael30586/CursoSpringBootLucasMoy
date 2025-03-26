package com.f_rafael.rover.services;

import com.f_rafael.rover.dto.ObstacleDto;
import com.f_rafael.rover.models.Obstacle;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ObstacleService {
    public List<Obstacle> findAll();
}
