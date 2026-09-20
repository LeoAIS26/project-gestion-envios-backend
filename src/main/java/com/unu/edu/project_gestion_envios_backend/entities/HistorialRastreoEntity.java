package com.unu.edu.project_gestion_envios_backend.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "historial_rastreo")
public class HistorialRastreoEntity extends BaseEntity{

    @Column(name = "paquete_id", nullable = false)
    private Integer paqueteId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "paquete_id", referencedColumnName = "id", insertable = false, updatable = false)
    private PaqueteEntity paquete;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false)
    private EstadoPaquete estado;

    @NotNull
    @Column(name = "mensaje_estado", nullable = false, columnDefinition = "text")
    private String mensajeEstado;

    @Column(name = "agencia_id", nullable = false)
    private Integer agenciaId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "agencia_id", referencedColumnName = "id", insertable = false, updatable = false)
    private AgenciaEntity agencia;

    @Column(name = "empleado_id", nullable = false)
    private Integer empleadoId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "empleado_id", referencedColumnName = "id", insertable = false, updatable = false)
    private UsuarioEntity empleado;

    @NotNull
    @Column(name = "fecha_hora", nullable = false)
    private LocalDateTime fechaHora;

}