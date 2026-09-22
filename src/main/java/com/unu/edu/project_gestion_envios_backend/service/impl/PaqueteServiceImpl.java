package com.unu.edu.project_gestion_envios_backend.service.impl;

import com.unu.edu.project_gestion_envios_backend.dto.request.PaqueteRequest;
import com.unu.edu.project_gestion_envios_backend.model.Paquete;
import com.unu.edu.project_gestion_envios_backend.repository.PaqueteRepository;
import com.unu.edu.project_gestion_envios_backend.service.PaqueteService;
import com.unu.edu.project_gestion_envios_backend.utils.mapper.PaqueteMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class PaqueteServiceImpl extends PaqueteService {

    private final PaqueteRepository paqueteRepository;
    private final PaqueteMapper mapper;

    @Override
    @Transactional(readOnly = true)
    public List<Paquete> listar() {
        return paqueteRepository.findAll();
    }

    @Override
    public Paquete upsert(PaqueteRequest paqueteRequest) {
        Paquete paquete = mapper.mapToModel(paqueteRequest);

        paquete.setCreatedBy(1); //TODO FALTA TRAAER SEGUN EMPKEADO

        return paqueteRepository.save(paquete);
    }

}
