package com.salesianostriana.dam.proyecto_guarderia.modelo;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data @NoArgsConstructor @AllArgsConstructor 
public class Alumno {

	@Id @GeneratedValue
	private long codAlumno;
	
	private String nombre;
	private String apellido1;
	private String apellido2;
	private int edad;
	private int curso;
	private LocalDate fechaNacimiento;
	private String direccion;
	
	
	public Alumno(String nombre, String apellido1, int edad, int curso, 
				  LocalDate fechaNacimiento, String direccion) {
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.edad = edad;
		this.curso = curso;
		this.fechaNacimiento = fechaNacimiento;
		this.direccion = direccion;
	}
	
}
