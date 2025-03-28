package com.f_rafael.gestionclientes.controllers;

import com.f_rafael.gestionclientes.models.Cliente;
import com.f_rafael.gestionclientes.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @GetMapping("/cliente/{id}")
    public Cliente getById(@PathVariable Integer id){
        return service.getById(id);
    }


    @DeleteMapping("/cliente/{id}")
    public void removeById(@PathVariable Integer id){
        service.removeById(id);
    }

}
