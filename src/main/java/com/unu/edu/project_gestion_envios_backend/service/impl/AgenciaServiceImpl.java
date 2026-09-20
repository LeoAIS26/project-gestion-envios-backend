package com.unu.edu.project_gestion_envios_backend.service.impl;

import com.unu.edu.project_gestion_envios_backend.model.Agencia;
import com.unu.edu.project_gestion_envios_backend.repository.AgenciaRepository;
import com.unu.edu.project_gestion_envios_backend.service.AgenciaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AgenciaServiceImpl extends AgenciaService {

    private final AgenciaRepository agenciaRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Agencia> listar() {
        return agenciaRepository.findAll();
    }
}
