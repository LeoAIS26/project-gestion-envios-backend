package com.unu.edu.project_gestion_envios_backend.repository;

import com.unu.edu.project_gestion_envios_backend.model.Ciudad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CiudadRepository extends JpaRepository<Ciudad, Integer> {
}
