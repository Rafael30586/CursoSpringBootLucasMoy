package com.f_rafael.gestionclientes.services;

import com.f_rafael.gestionclientes.models.Cliente;
import org.springframework.web.bind.annotation.PathVariable;

public interface ClienteService {

    public Cliente getById(Integer id);

    void removeById(Integer id);
}
