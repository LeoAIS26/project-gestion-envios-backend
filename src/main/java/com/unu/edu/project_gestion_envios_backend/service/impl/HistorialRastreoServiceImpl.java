package com.unu.edu.project_gestion_envios_backend.service.impl;

import com.unu.edu.project_gestion_envios_backend.model.HistorialRastreo;
import com.unu.edu.project_gestion_envios_backend.repository.HistorialRastreoRepository;
import com.unu.edu.project_gestion_envios_backend.service.HistorialRastreoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HistorialRastreoServiceImpl extends HistorialRastreoService {

    private final HistorialRastreoRepository historialRastreoRepository;

    @Override
    @Transactional(readOnly = true)
    public List<HistorialRastreo> listar() {
        return historialRastreoRepository.findAll();
    }
}
