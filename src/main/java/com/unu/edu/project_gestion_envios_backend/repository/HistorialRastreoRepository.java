package com.unu.edu.project_gestion_envios_backend.repository;

import com.unu.edu.project_gestion_envios_backend.model.HistorialRastreo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistorialRastreoRepository extends JpaRepository<HistorialRastreo, Integer> {
}
