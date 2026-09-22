package com.unu.edu.project_gestion_envios_backend.service.impl;

import com.unu.edu.project_gestion_envios_backend.exception.NotFoundException;
import com.unu.edu.project_gestion_envios_backend.model.Cliente;
import com.unu.edu.project_gestion_envios_backend.repository.ClienteRepository;
import com.unu.edu.project_gestion_envios_backend.service.ClienteService;
import com.unu.edu.project_gestion_envios_backend.utils.messages.ClienteMensajes;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class ClienteServiceImpl extends ClienteService {

    private final ClienteRepository repository;

    @Override
    @Transactional(readOnly = true)
    public Cliente findByDniAndActivo(String dni) {
        return repository.findByDniAndActivo(dni).orElseThrow(() -> new NotFoundException(ClienteMensajes.NOT_FOUND_BY_DNI));
    }
}
