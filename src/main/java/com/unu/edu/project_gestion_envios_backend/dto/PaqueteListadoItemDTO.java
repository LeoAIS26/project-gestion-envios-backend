package com.unu.edu.project_gestion_envios_backend.dto;

import com.unu.edu.project_gestion_envios_backend.model.EstadoPaquete;
import com.unu.edu.project_gestion_envios_backend.model.Paquete;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record PaqueteListadoItemDTO(
        Integer id,
        String nroRastreo,
        Integer remitenteId,
        Integer destinatarioId,
        String destinatarioNombre,
        String destinatarioApellido,
        String destinatarioDni,
        Integer agenciaEnvioId,
        Integer agenciaDestinoId,
        BigDecimal peso,
        Boolean esFragil,
        EstadoPaquete estadoActual,
        String observaciones,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        Integer createdBy,
        Integer updatedBy) {

    public static PaqueteListadoItemDTO fromEntity(Paquete paquete) {
        return new PaqueteListadoItemDTO(
                paquete.getId(),
                paquete.getNroRastreo(),
                paquete.getRemitenteId(),
                paquete.getDestinatarioId(),
                paquete.getDestinatarioNombre(),
                paquete.getDestinatarioApellido(),
                paquete.getDestinatarioDni(),
                paquete.getAgenciaEnvioId(),
                paquete.getAgenciaDestinoId(),
                paquete.getPeso(),
                paquete.getEsFragil(),
                paquete.getEstadoActual(),
                paquete.getObservaciones(),
                paquete.getCreatedAt(),
                paquete.getUpdatedAt(),
                paquete.getCreatedBy(),
                paquete.getUpdatedBy());
    }
}
