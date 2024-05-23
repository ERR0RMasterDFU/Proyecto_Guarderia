package com.salesianostriana.dam.proyecto_guarderia.modelo;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity 
@Data 
@NoArgsConstructor 
@AllArgsConstructor 
@Builder
public class Curso {

	@Id @GeneratedValue
	private long id;
	
	private String nombre;
	
	
// OTM (ALUMNO) -----------------------------------------------------------------------
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@OneToMany(mappedBy="curso", fetch = FetchType.EAGER)
	@Builder.Default
	private List<Alumno> alumnos = new ArrayList<>();
	
	

// OTO (PROFESOR) ---------------------------------------------------------------------
	
    @JoinColumn(name = "profesor_id")
    @OneToOne(fetch = FetchType.EAGER)
    private Profesor profesor;	
    
}
