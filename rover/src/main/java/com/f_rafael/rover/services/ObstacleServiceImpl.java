package com.f_rafael.rover.services;

import com.f_rafael.rover.dto.ObstacleDto;
import com.f_rafael.rover.models.Obstacle;
import com.f_rafael.rover.repository.ObstacleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObstacleServiceImpl implements ObstacleService{

    @Autowired
    private ObstacleRepository repository;
    @Override
    public List<Obstacle> findAll() {
        return repository.findAll();
    }
}
