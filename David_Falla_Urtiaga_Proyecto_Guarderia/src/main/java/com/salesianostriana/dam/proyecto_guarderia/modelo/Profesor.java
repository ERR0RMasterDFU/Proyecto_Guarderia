package com.salesianostriana.dam.proyecto_guarderia.modelo;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
public class Profesor {

	@Id @GeneratedValue
	private long id;
	
	private String nombre;
	private String primerApellido;
	private String segundoApellido;
	private String dni;
	private String numTelefono;

	
// MTM (ALUMNO) ---------------------------------------------------------------------------
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name = "alumno",
			joinColumns = @JoinColumn(name="profesor_id"),
			inverseJoinColumns = @JoinColumn(name="alumno_id")
	)
	@Builder.Default
	private List<Alumno> alumnos = new ArrayList<>();
	
	
	
// OTM (OBSERVACION) ------------------------------------------------------------------------	
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@OneToMany(mappedBy="profesor", fetch = FetchType.EAGER)
	@Builder.Default
	private List<Observacion> observaciones = new ArrayList<>();
	
	
	
// OTO (CURSO) ------------------------------------------------------------------------	

	@OneToOne(mappedBy = "profesor", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Curso curso;
	
	
// OTO (ACTIVIDAD COMPLEMENTARIA) ------------------------------------------------------------------------	

	@OneToOne(mappedBy = "profesor", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private ActividadComplementaria encargado;
	
	

// MÉTODOS HELPER ---------------------------------------------------------------------------
	
	// ALUMNO - PROFESOR
	
	public void agregarAlumno(Alumno a) {
		this.alumnos.add(a);
		a.getProfesores().add(this);
	}
		
	public void eliminarAlumno(Alumno a) {
		a.getProfesores().remove(this);
		this.alumnos.remove(a);
	}
	
	
	
	
	
	
	
	
	
	
}


























