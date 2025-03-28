package com.f_rafael.rover.services;

import com.f_rafael.rover.models.Rover;
import com.f_rafael.rover.repository.RoverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class RoverServiceImpl implements RoverService{

    @Autowired
    private RoverRepository repository;


    @Override
    public Rover get() {

        List<Rover> roverList = repository.findAll();
        return roverList.get(0);
    }

    @Override
    public void sendCommand(String command) {
        Rover rover = new Rover();
        repository.save(rover);

    }
}
