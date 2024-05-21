package com.salesianostriana.dam.proyecto_guarderia.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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
public class Alumno {

	@Id @GeneratedValue
	private long id;
	
	private String nombre;
	private String primerApellido;
	private String segundoApellido;
	private int edad;
	private String direccion;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaNacimiento;
	

// MTO (USUARIO) -----------------------------------------------------------------------------------
	
	@ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name="fk_progenitor_alumno"))
	private Usuario progenitor;
	
	
// OTM (OBSERVACION) -------------------------------------------------------------------------------	
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@OneToMany(mappedBy="alumno", fetch = FetchType.EAGER)
	@Builder.Default
	private List<Observacion> observaciones = new ArrayList<>();
	
	
	
// MTM (ACTIVIDADES COMPLEMENTARIAS) ------------------------------------------------------------
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name = "horario",
			joinColumns = @JoinColumn(name="alumno_id"),
			inverseJoinColumns = @JoinColumn(name="actividad_id")
	)
	@Builder.Default
	private List<ActividadComplementaria> horario = new ArrayList<>();
	
	
	
	
// MTM (PROFESOR) -------------------------------------------------------------------------------
	
	@ManyToMany(mappedBy="alumnos", fetch = FetchType.EAGER)
	@Builder.Default
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	private List<Profesor> profesores = new ArrayList<>();
	
	
// MTO (USUARIO) -----------------------------------------------------------------------------------
	
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name="fk_curso_alumno"))
	private Curso curso;
	
	
// MÉTODOS HELPER ------------------------------------------------------------------------------------------------------------------------------
	
	
	//USUARIO - ALUMNO
	
	public void agregarprogenitor(Usuario progenitor) {
		this.progenitor = progenitor;
		progenitor.getHijos().add(this);
	}
	
	public void eliminarProgenitor(Usuario progenitor) {
		progenitor.getHijos().remove(this);
		this.progenitor = null;		
	}
	

	// ALUMNO - ACTIVIDAD COMPLEMENTARIA
	
	public void agregarActividad(ActividadComplementaria ac) {
		this.horario.add(ac);
		ac.getAlumnos().add(this);
	}
	
	public void eliminarActividad(ActividadComplementaria ac) {
		ac.getAlumnos().remove(this);
		this.horario.remove(ac);
	}

	
	//ALUMNO - CURSO
	
	public void agregarCurso(Curso curso) {
		this.curso = curso;
		curso.getAlumnos().add(this);
	}
	
	public void eliminarCurso(Curso curso) {
		curso.getAlumnos().remove(this);
		this.curso = null;		
	}
	
	
	
}	