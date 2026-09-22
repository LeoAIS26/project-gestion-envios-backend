package com.unu.edu.project_gestion_envios_backend.dto.request;

import com.unu.edu.project_gestion_envios_backend.utils.messages.ClienteMensajes;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record ClienteRequest(
        @NotBlank(message = ClienteMensajes.NOMBRE_OBLIGATORIO)
        @Size(max = 20, message = ClienteMensajes.NOMBRE_SIZE)
        String nombre,

        @Size(max = 20, message = ClienteMensajes.SEGUNDO_NOMBRE_SIZE)
        String segundoNombre,

        @NotBlank(message = ClienteMensajes.APELLIDO_PATERNO_OBLIGATORIO)
        @Size(max = 30, message = ClienteMensajes.APELLIDO_PATERNO_SIZE)
        String apellidoPaterno,

        @NotBlank(message = ClienteMensajes.APELLIDO_MATERNO_OBLIGATORIO)
        @Size(max = 30, message = ClienteMensajes.APELLIDO_MATERNO_SIZE)
        String apellidoMaterno,

        @NotBlank(message = ClienteMensajes.DNI_OBLIGATORIO)
        @Pattern(regexp = "\\d{8}", message = ClienteMensajes.DNI_FORMATO)
        String dni,

        @NotBlank(message = ClienteMensajes.TELEFONO_OBLIGATORIO)
        @Pattern(regexp = "\\d{9}", message = ClienteMensajes.TELEFONO_FORMATO)
        String telefono
) {
}