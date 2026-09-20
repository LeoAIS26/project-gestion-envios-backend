package com.unu.edu.project_gestion_envios_backend.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "usuarios")
public class UsuarioEntity extends BaseEntity{

    @Column(name = "nombre", nullable = false, length = 20)
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

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Rol rol;

    @Size(max = 10)
    @Column(name = "username", length = 10)
    private String username;

    @Size(max = 255)
    @Column(name = "password")
    private String password;

}