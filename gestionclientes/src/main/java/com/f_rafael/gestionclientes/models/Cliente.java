package com.f_rafael.gestionclientes.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    private String email;
    private String telefono;
    private String direccion;

}
