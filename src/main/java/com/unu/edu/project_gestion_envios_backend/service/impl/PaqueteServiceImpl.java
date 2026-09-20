package com.unu.edu.project_gestion_envios_backend.service.impl;

import com.unu.edu.project_gestion_envios_backend.model.Paquete;
import com.unu.edu.project_gestion_envios_backend.repository.PaqueteRepository;
import com.unu.edu.project_gestion_envios_backend.service.PaqueteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaqueteServiceImpl extends PaqueteService {

    private final PaqueteRepository paqueteRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Paquete> listar() {
        return paqueteRepository.findAll();
    }
}
