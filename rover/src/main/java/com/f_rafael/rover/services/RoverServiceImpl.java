package com.f_rafael.rover.services;

import com.f_rafael.rover.models.Rover;
import com.f_rafael.rover.repository.RoverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoverServiceImpl implements RoverService{

    @Autowired
    private RoverRepository repository;


    @Override
    public Rover get() {
        List<Rover> roverList = repository.findAll();
        return roverList.get(0);
    }
}
