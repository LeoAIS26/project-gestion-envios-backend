package com.unu.edu.project_gestion_envios_backend.service;

import com.unu.edu.project_gestion_envios_backend.model.Cliente;

public abstract class ClienteService {

    public abstract Cliente findByDniAndActivo(String dni);
}
