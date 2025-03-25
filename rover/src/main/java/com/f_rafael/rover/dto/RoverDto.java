package com.f_rafael.rover.dto;

import com.f_rafael.rover.models.Direction;
import lombok.Data;

@Data
public class RoverDto {
    private Integer x;
    private Integer y;
    private Direction direction;
}
