package com.f_rafael.rover.controllers;

import com.f_rafael.rover.dto.CommandDto;
import com.f_rafael.rover.services.RoverService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class RoverControllerTest {

    @Mock //Indica que el objeto va a ser falso
    private RoverService roverService;

    private RoverController controller;
    @Test
    public void whenSendCommand_callService(){
        controller = new RoverController();

        CommandDto commandDto = new CommandDto();

        List<String> commandsList = new ArrayList<>();
        commandsList.add("F");
        commandDto.setCommands(commandsList);
        controller.sendCommand(commandDto);

    }
}
