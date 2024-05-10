package com.salesianostriana.dam.proyecto_guarderia.modelo;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Profesor {

	@Id @GeneratedValue
	private long idProfesor;
	
	private String nombre;
	private String apellido1;
	private String apellido2;
	private boolean curso; 
	private String encargado;
	
	//private List Alumno;
}
