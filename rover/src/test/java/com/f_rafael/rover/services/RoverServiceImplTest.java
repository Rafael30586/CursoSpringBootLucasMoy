package com.f_rafael.rover.services;

import com.f_rafael.rover.controllers.RoverController;
import com.f_rafael.rover.dto.CommandDto;
import com.f_rafael.rover.models.Direction;
import com.f_rafael.rover.models.Rover;
import com.f_rafael.rover.repository.RoverRepository;
import com.f_rafael.rover.services.RoverService;
//import org.junit.jupiter.api.Test;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class RoverServiceImplTest {

    @Mock //Indica que el objeto va a ser falso
    private RoverRepository roverRepository;

    @InjectMocks
    private RoverServiceImpl service;


    @Test
    public void whenSendCommand_callService(){

        Rover rover = new Rover();
        rover.setX(5);
        rover.setY(5);
        rover.setDirection(Direction.NORTH);
        List<Rover> roverList = new ArrayList<>();
        roverList.add(rover);

        when(roverRepository.findAll()).thenReturn(roverList);


        service.sendCommand("F");
        rover.setY(4);



        verify(roverRepository, times(1)).save(rover);
        /*
        service = new RoverController();

        CommandDto commandDto = new CommandDto();

        List<String> commandsList = new ArrayList<>();
        commandsList.add("F");
        commandDto.setCommands(commandsList);
        service.sendCommand(commandDto);

        verify(roverService, times(1)).sendCommand("F");*/

    }


}
