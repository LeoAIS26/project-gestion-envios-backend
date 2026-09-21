package com.unu.edu.project_gestion_envios_backend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter 
@Setter 
@AllArgsConstructor 
@NoArgsConstructor 
@EqualsAndHashCode (callSuper = true)
@Entity
@Table(name = "empleados")
public class Empleado extends Persona{

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Rol rol;

    @Size(max = 10)
    @Column(name = "username", length = 10, unique = true)
    private String username;

    @Size(max = 255)
    @Column(name = "password")
    private String password;

    @Column(name = "agencia_id")
    private Integer agenciaId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "agencia_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Agencia agencia;
}