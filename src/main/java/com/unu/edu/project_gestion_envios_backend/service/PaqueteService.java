package com.unu.edu.project_gestion_envios_backend.service;

import com.unu.edu.project_gestion_envios_backend.controller.request.PaqueteRequest;
import com.unu.edu.project_gestion_envios_backend.model.Paquete;

import java.util.List;

public abstract class PaqueteService {

    public abstract List<Paquete> listar();

    public abstract Paquete upsert(PaqueteRequest paqueteRequest);
}
