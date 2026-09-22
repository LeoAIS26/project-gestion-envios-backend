package com.unu.edu.project_gestion_envios_backend.repository;

import com.unu.edu.project_gestion_envios_backend.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    @Query("select c from Cliente c" +
            "   where c.dni = :dni and c.activo = true")
    Optional<Cliente> findByDniAndActivo(String dni);
}
