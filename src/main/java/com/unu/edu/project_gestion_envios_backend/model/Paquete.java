package com.unu.edu.project_gestion_envios_backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter 
@Setter 
@AllArgsConstructor 
@NoArgsConstructor 
@EqualsAndHashCode (callSuper = true)
@Entity
@Table(name = "paquetes")
public class Paquete extends BaseModel{

    @Column(name = "numero_rastreo", nullable = false, length = 10, unique = true)
    private String numeroRastreo;

    @Column(name = "remitente_id", nullable = false)
    private Integer remitenteId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "remitente_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Cliente remitente;

    @Column(name = "destinatario_id")
    private Integer destinatarioId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "destinatario_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Cliente destinatario;

    @Column(name = "destinatario_nombre", nullable = false, length = 20)
    private String destinatarioNombre;

    @Column(name = "destinatario_apellido", nullable = false, length = 30)
    private String destinatarioApellido;

    @Column(name = "destinatario_dni", nullable = false, length = 8)
    private String destinatarioDni;

    @Column(name = "agencia_envio_id", nullable = false)
    private Integer agenciaEnvioId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "agencia_envio_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Agencia agenciaEnvio;

    @Column(name = "agencia_destino_id", nullable = false)
    private Integer agenciaDestinoId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "agencia_destino_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Agencia agenciaDestino;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal peso;

    @Column(name = "es_fragil", nullable = false)
    private Boolean esFragil = Boolean.FALSE;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado_actual", nullable = false)
    private EstadoPaquete estadoActual;

    @Column(columnDefinition = "text")
    private String observaciones;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by", referencedColumnName = "id", insertable = false, updatable = false)
    private Empleado creador;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "updated_by", referencedColumnName = "id", insertable = false, updatable = false)
    private Empleado modificador;

}