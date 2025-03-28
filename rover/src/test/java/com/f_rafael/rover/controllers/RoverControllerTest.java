package com.f_rafael.rover.controllers;

import com.f_rafael.rover.dto.CommandDto;
import com.f_rafael.rover.services.RoverService;
//import org.junit.jupiter.api.Test;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class RoverControllerTest {

    @Mock //Indica que el objeto va a ser falso
    private RoverService roverService;

    @InjectMocks
    private RoverController controller;

    
    @Test
    public void whenSendCommand_callService(){
        controller = new RoverController();

        CommandDto commandDto = new CommandDto();

        List<String> commandsList = new ArrayList<>();
        commandsList.add("F");
        commandDto.setCommands(commandsList);
        controller.sendCommand(commandDto);

        verify(roverService, times(1)).sendCommand("F");

    }
}
