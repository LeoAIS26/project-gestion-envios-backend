package com.unu.edu.project_gestion_envios_backend.service.impl;

import com.unu.edu.project_gestion_envios_backend.model.Ciudad;
import com.unu.edu.project_gestion_envios_backend.repository.CiudadRepository;
import com.unu.edu.project_gestion_envios_backend.service.CiudadService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CiudadServiceImpl extends CiudadService {

    private final CiudadRepository ciudadRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Ciudad> listar() {
        return ciudadRepository.findAll();
    }
}
