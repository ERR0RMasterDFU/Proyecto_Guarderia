package com.salesianostriana.dam.proyecto_guarderia.modelo;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ForeignKey;
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
	
	
	// MANY TO ONE (TUTOR LEGAL) ----------------------------------------------------------------------------------------------------------------
	
	@ManyToOne
	private TutorLegal tutorLegal;
	
	
	// MANY TO ONE (HORARIO) ----------------------------------------------------------------------------------------------------------------

	@ManyToOne 
    @JoinColumn(foreignKey = @ForeignKey(name="fk_alumno_horario"))
    private Horario horario;
	
	
	// CONSTRUCTOR SIN SEGUNDO APELLIDO ------------------------------------------------------------------------------------------------------------
	
	/*public Alumno(String nombre, String apellido1, int edad, int curso, 
				  LocalDate fechaNacimiento, String direccion, TutorLegal tutorLegal) {
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.edad = edad;
		this.curso = curso;
		this.fechaNacimiento = fechaNacimiento;
		this.direccion = direccion;
		this.tutorLegal = tutorLegal;
	}*/
	
	
	// MÉTODOS HELPER ------------------------------------------------------------------------------------------------------------------------------
	
	public void agregarATutorLegal(TutorLegal tutorLegal) {
		this.tutorLegal = tutorLegal;
		tutorLegal.getHijos().add(this);
	}
	
	public void eliminarDeTutorLegal(TutorLegal tutorLegal) {
		tutorLegal.getHijos().remove(this);
		this.tutorLegal = null;		
	}
	
	
	public void agregarAHorario(Horario horario) {
		this.horario = horario;
		horario.getAlumnos().add(this);
	}
		
	public void eliminarDeHorario(Horario horario) {
		horario.getAlumnos().remove(this);
		this.horario = null;		
	}
	
}