package com.f_rafael.gestionclientes.controllers;

import com.f_rafael.gestionclientes.dto.ClienteSearchCriteria;
import com.f_rafael.gestionclientes.models.Cliente;
import com.f_rafael.gestionclientes.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping("/cliente")
    public void create(@RequestBody Cliente cliente){
        service.save(cliente);
    }

    @PutMapping("/cliente/{id}")
    public void update(@RequestBody Cliente cliente, @PathVariable Integer id){
        service.save(cliente);
    }


    @GetMapping("/cliente/buscar")
    public List<Cliente> buscar(@RequestBody ClienteSearchCriteria searchCtriteria){
        return service.buscar(searchCtriteria);
    }

}
