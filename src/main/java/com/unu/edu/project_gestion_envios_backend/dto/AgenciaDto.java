package com.unu.edu.project_gestion_envios_backend.dto;

import com.unu.edu.project_gestion_envios_backend.model.Agencia;

public record AgenciaDto(
        Integer id,
        Integer ciudadId,
        String nombre,
        String direccion) {

    public static AgenciaDto fromEntity(Agencia agencia) {
        return new AgenciaDto(
                agencia.getId(),
                agencia.getCiudadId(),
                agencia.getNombre(),
                agencia.getDireccion()
        );
    }
}