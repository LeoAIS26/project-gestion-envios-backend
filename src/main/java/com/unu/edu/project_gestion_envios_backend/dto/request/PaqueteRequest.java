package com.unu.edu.project_gestion_envios_backend.dto.request;

import com.unu.edu.project_gestion_envios_backend.model.EstadoPaquete;
import com.unu.edu.project_gestion_envios_backend.utils.messages.PaqueteMensajes;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record PaqueteRequest(
        @NotBlank(message = PaqueteMensajes.NUMERO_RASTREO_OBLIGATORIO)
        @Size(max = 10, message = PaqueteMensajes.NUMERO_RASTREO_MAX_LENGTH)
        String nroRastreo,

        @NotNull(message = PaqueteMensajes.REMITENTE_ID_OBLIGATORIO)
        @Positive(message = PaqueteMensajes.REMITENTE_ID_INVALIDO)
        Integer remitenteId,

        @Positive(message = PaqueteMensajes.DESTINATARIO_ID_INVALIDO)
        Integer destinatarioId,

        @NotBlank(message = PaqueteMensajes.DESTINATARIO_NOMBRE_OBLIGATORIO)
        @Size(max = 20, message = PaqueteMensajes.DESTINATARIO_NOMBRE_MAX_LENGTH)
        String destinatarioNombre,

        @NotBlank(message = PaqueteMensajes.DESTINATARIO_APELLIDO_OBLIGATORIO)
        @Size(max = 30, message = PaqueteMensajes.DESTINATARIO_APELLIDO_MAX_LENGTH)
        String destinatarioApellido,

        @NotBlank(message = PaqueteMensajes.DESTINATARIO_DNI_OBLIGATORIO)
        @Pattern(regexp = "^\\d{8}$", message = PaqueteMensajes.DESTINATARIO_DNI_FORMATO)
        String destinatarioDni,

        @NotNull(message = PaqueteMensajes.AGENCIA_ENVIO_ID_OBLIGATORIO)
        @Positive(message = PaqueteMensajes.AGENCIA_ENVIO_ID_INVALIDO)
        Integer agenciaEnvioId,

        @NotNull(message = PaqueteMensajes.AGENCIA_DESTINO_ID_OBLIGATORIO)
        @Positive(message = PaqueteMensajes.AGENCIA_DESTINO_ID_INVALIDO)
        Integer agenciaDestinoId,

        @NotNull(message = PaqueteMensajes.PESO_OBLIGATORIO)
        @DecimalMin(value = "0.01", message = PaqueteMensajes.PESO_MINIMO)
        @Digits(integer = 8, fraction = 2, message = PaqueteMensajes.PESO_DIGITOS)
        BigDecimal peso,

        @NotNull(message = PaqueteMensajes.ES_FRAGIL_OBLIGATORIO)
        Boolean esFragil,

        @NotNull(message = PaqueteMensajes.ESTADO_ACTUAL_OBLIGATORIO)
        EstadoPaquete estadoActual,

        String observaciones
) {
}