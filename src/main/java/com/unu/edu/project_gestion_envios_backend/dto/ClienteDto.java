package com.unu.edu.project_gestion_envios_backend.dto;

import com.unu.edu.project_gestion_envios_backend.model.Cliente;

public record ClienteDto(
        Integer id,
        String nombre,
        String segundoNombre,
        String apellidoPaterno,
        String apellidoMaterno,
        String dni,
        String telefono,
        Boolean activo
) {

    public static ClienteDto fromEntity(Cliente cliente) {
        return new ClienteDto(
                cliente.getId(),
                cliente.getNombre(),
                cliente.getSegundoNombre(),
                cliente.getApellidoPaterno(),
                cliente.getApellidoMaterno(),
                cliente.getDni(),
                cliente.getTelefono(),
                cliente.getActivo()
        );
    }
}