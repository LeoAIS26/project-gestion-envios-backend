package com.unu.edu.project_gestion_envios_backend.repository;

import com.unu.edu.project_gestion_envios_backend.model.Agencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgenciaRepository extends JpaRepository<Agencia, Integer> {


}
