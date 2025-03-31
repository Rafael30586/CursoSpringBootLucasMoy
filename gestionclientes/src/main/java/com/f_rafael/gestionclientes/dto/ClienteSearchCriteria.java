package com.f_rafael.gestionclientes.dto;

import lombok.Data;

@Data
public class ClienteSearchCriteria {
    private String nombreCompleto;
    private String email;
    private String telefono;
}
