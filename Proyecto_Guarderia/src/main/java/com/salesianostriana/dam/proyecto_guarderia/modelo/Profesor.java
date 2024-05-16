package com.salesianostriana.dam.proyecto_guarderia.modelo;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
public class Profesor {

	@Id @GeneratedValue
	private long idProfesor;
	
	private String nombre;
	private String apellido1;
	private String apellido2;
	private boolean curso; 
	private String encargado;
	/*private List<Alumno> Alumno = new ArrayList<>();*/

	// ONE TO MANY (ALUMNO) ----------------------------------------------------------------------------------------------------------------
	
	@OneToMany(mappedBy="profesor", fetch = FetchType.EAGER)
	@Builder.Default
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private List<Observacion> observaciones = new ArrayList<>();
	

}