package com.unu.edu.project_gestion_envios_backend.model;

import jakarta.persistence.*;
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
@Table(name = "agencias")
public class Agencia extends BaseModel{

    @Column(name = "ciudad_id", nullable = false)
    private Integer ciudadId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ciudad_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Ciudad ciudad;
}
