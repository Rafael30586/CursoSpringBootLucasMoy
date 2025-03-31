package com.f_rafael.gestionclientes.repositories;

import com.f_rafael.gestionclientes.dto.ClienteSearchCriteria;
import com.f_rafael.gestionclientes.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    @Query("SELECT c FROM Cliente c WHERE "+
    "c.nombre LIKE CONCAT('%', :nombreCompleto, '%') " +
    "OR c.email LIKE CONCAT('%', :email, '%') "+
    "OR c.telefono LIKE CONCAT('%', :telefono, '%')")
    List<Cliente> buscarClientes(@Param("nombreCompleto") String nombreCompleto,
                                 @Param("email") String email,
                                 @Param("telefono") String telefono);

}
