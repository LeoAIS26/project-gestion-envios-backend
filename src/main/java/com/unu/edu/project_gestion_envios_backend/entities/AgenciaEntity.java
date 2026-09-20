package com.unu.edu.project_gestion_envios_backend.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "agencias")
public class AgenciaEntity extends BaseEntity{

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Ciudad ciudad;
}
