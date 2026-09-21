package com.unu.edu.project_gestion_envios_backend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter 
@Setter 
@AllArgsConstructor 
@NoArgsConstructor 
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "historial_rastreo")
public class HistorialRastreo extends BaseModel{

    @Column(name = "paquete_id", nullable = false)
    private Integer paqueteId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "paquete_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Paquete paquete;

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
    private Agencia agencia;

    @Column(name = "empleado_id", nullable = false)
    private Integer empleadoId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "empleado_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Empleado empleado;

    @NotNull
    @Column(name = "fecha_hora", nullable = false)
    private LocalDateTime fechaHora;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by", referencedColumnName = "id", insertable = false, updatable = false)
    private Empleado creador;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "updated_by", referencedColumnName = "id", insertable = false, updatable = false)
    private Empleado modificador;
}