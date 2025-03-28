package com.f_rafael.rover.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "rover")
public class Rover {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "posx")
    private Integer x;
    @Column(name = "posy")
    private Integer y;
    @Column(name = "direction")
    @Enumerated(EnumType.STRING)
    private Direction direction;

    public void setId(Long id) {
        this.id = id;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void setY(Integer y) {
        this.y = y;
    }
}
