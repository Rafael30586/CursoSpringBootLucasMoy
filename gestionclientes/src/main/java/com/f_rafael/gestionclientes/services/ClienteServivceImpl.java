package com.f_rafael.gestionclientes.services;

import com.f_rafael.gestionclientes.dto.ClienteSearchCriteria;
import com.f_rafael.gestionclientes.models.Cliente;
import com.f_rafael.gestionclientes.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServivceImpl implements ClienteService{

    @Autowired
    private ClienteRepository repository;

    @Override
    public Cliente getById(Integer id) {
        return repository.findById(id).get();
    }

    @Override
    public void removeById(Integer id) {
        repository.deleteById(id);
    }


    @Override
    public void save(Cliente cliente) {
        repository.save(cliente);
    }

    @Override
    public List<Cliente> buscar(ClienteSearchCriteria searchCriteria) {
        String nombreCompleto = searchCriteria.getNombreCompleto();
        String email = searchCriteria.getEmail();
        String telefono = searchCriteria.getTelefono();


        return repository.buscarClientes(nombreCompleto,email,telefono);
    }


}
