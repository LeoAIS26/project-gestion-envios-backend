package com.unu.edu.project_gestion_envios_backend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@MappedSuperclass
public abstract class Persona extends BaseModel{

    @Column(nullable = false, length = 20)
    private String nombre;

    @Column(name = "segundo_nombre", length = 20)
    private String segundoNombre;

    @Column(name = "apellido_paterno", nullable = false, length = 30)
    private String apellidoPaterno;

    @Column(name = "apellido_materno", nullable = false, length = 30)
    private String apellidoMaterno;

    @Column( nullable = false, length = 8)
    private String dni;

    @Column( nullable = false, length = 9)
    private String telefono;

    @Column(nullable = false)
    private Boolean activo = Boolean.TRUE;

}