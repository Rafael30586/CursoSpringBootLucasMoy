package com.f_rafael.gestionclientes.services;

import com.f_rafael.gestionclientes.dto.ClienteSearchCriteria;
import com.f_rafael.gestionclientes.models.Cliente;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ClienteService {

    public Cliente getById(Integer id);

    void removeById(Integer id);

    void save(Cliente cliente);

    public List<Cliente> buscar(ClienteSearchCriteria searchCtriteria);
}
