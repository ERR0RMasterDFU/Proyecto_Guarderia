package com.salesianostriana.dam.proyecto_guarderia.modelo;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
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
public class ActividadComplementaria {

	@Id @GeneratedValue
	private long id;
	
	private String nombre;
	private double precio;
	
	
	
	// MTM (ALUMNO) ----------------------------------------------------------------------------
	
	@ManyToMany(mappedBy="horario", fetch = FetchType.EAGER)
	@Builder.Default
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	private List<Alumno> alumnos = new ArrayList<>();
	
	

	// OTM (PROFESOR) ---------------------------------------------------------------------
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@OneToMany(mappedBy="encargado", fetch = FetchType.EAGER)
	@Builder.Default
	private List<Profesor> profesores = new ArrayList<>();
	
	
	// OTM (PROFESOR) ---------------------------------------------------------------------
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@OneToMany(mappedBy="actividad", fetch = FetchType.EAGER)
	@Builder.Default
	private List<Observacion> observaciones = new ArrayList<>();

	
	
	
}
