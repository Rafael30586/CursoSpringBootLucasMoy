package com.f_rafael.rover.dto;

import lombok.Data;

import java.util.List;

@Data
public class CommandDto {

    private List<String> commands;

    public List<String> getCommands() {
        return commands;
    }

    public void setCommands(List<String> commands) {
        this.commands = commands;
    }
}
