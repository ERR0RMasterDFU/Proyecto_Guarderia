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
	private long id;
	
	private String nombre;
	private String primerApellido;
	private String segundoApellido;
	private boolean edad;
	private int curso;
	private String direccion;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaNacimiento;
	
	
// MANY TO ONE (USUARIO) ----------------------------------------------------------------------------------------------------------------
	
	@ManyToOne
	private Usuario usuario;
	
	
// MANY TO ONE (HORARIO) ----------------------------------------------------------------------------------------------------------------

	@ManyToOne 
    @JoinColumn(foreignKey = @ForeignKey(name="fk_alumno_horario"))
    private Periodo horario;
	
	
// MÉTODOS HELPER ------------------------------------------------------------------------------------------------------------------------------
	
	public void agregarAUsuario(Usuario usuario) {
		this.usuario = usuario;
		usuario.getHijos().add(this);
	}
	
	public void eliminarDeUsuario(Usuario usuario) {
		usuario.getHijos().remove(this);
		this.usuario = null;		
	}
	
	
	public void agregarAHorario(Periodo horario) {
		this.horario = horario;
		horario.getAlumnos().add(this);
	}
		
	public void eliminarDeHorario(Periodo horario) {
		horario.getAlumnos().remove(this);
		this.horario = null;		
	}
	
}