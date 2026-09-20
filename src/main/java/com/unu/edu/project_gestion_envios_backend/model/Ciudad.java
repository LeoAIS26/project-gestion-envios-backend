package com.unu.edu.project_gestion_envios_backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter 
@Setter 
@AllArgsConstructor 
@NoArgsConstructor 
@EqualsAndHashCode (callSuper = true)
@Entity 
@Table (name = "ciudades")
public class Ciudad extends BaseModel {

	@Column(nullable = false, unique = true, length = 100)
	private String nombre;

	@OneToMany(mappedBy = "ciudad")
	private List<Agencia> agencias;

}