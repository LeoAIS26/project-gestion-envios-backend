package com.unu.edu.project_gestion_envios_backend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter 
@AllArgsConstructor 
@NoArgsConstructor 
@EqualsAndHashCode (callSuper = true)
@Entity
@Table(name = "usuarios")
public class Usuario extends BaseModel{

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

    @Column(nullable = false)
    private Boolean activo = Boolean.TRUE;

}