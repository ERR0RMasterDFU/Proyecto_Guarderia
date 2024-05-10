package com.salesianostriana.dam.proyecto_guarderia.modelo;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity 
@Data 
@NoArgsConstructor 
@AllArgsConstructor 
@Builder
public class Alumno {

	@Id @GeneratedValue
	private long idAlumno;
	
	private String nombre;
	private String apellido1;
	private String apellido2;
	private int edad;
	private int curso;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaNacimiento;
	
	private String direccion;
	
	@ManyToOne
	private TutorLegal tutorLegal;
	
	
	// CONSTRUCTOR SIN SEGUNDO APELLIDO ------------------------------------------------------------------------------------------------------------
	
	public Alumno(String nombre, String apellido1, int edad, int curso, 
				  LocalDate fechaNacimiento, String direccion, TutorLegal tutorLegal) {
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.edad = edad;
		this.curso = curso;
		this.fechaNacimiento = fechaNacimiento;
		this.direccion = direccion;
		this.tutorLegal = tutorLegal;
	}
	
	
	// MÉTODOS HELPER ------------------------------------------------------------------------------------------------------------------------------
	
	public void addToCurso(TutorLegal tutorLegal) {
		this.tutorLegal = tutorLegal;
		tutorLegal.getHijos().add(this);
	}
	
	public void removeFromCurso(TutorLegal tutorLegal) {
		tutorLegal.getHijos().remove(this);
		this.tutorLegal = null;		
	}
	
}