package com.salesianostriana.dam.proyecto_guarderia.modelo;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
public class Profesor {

	@Id @GeneratedValue
	private long id;
	
	private String nombre;
	private String primerApellido;
	private String segundoApellido;
	private String dni;
	private String numTelefono;

	
// OTM (OBSERVACION) ------------------------------------------------------------------------	
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@OneToMany(mappedBy="profesor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Builder.Default
	private List<Observacion> observaciones = new ArrayList<>();
	
	
	
// MTO (CURSO) ------------------------------------------------------------------------	

	@ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name="fk_curso_profesor"))
	private Curso curso;
	
	
// MTO (ACTIVIDAD COMPLEMENTARIA) ------------------------------------------------------------------------	

	@ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name="fk_encargo_profesor"))
	private ActividadComplementaria encargado;
	
	

// MÉTODOS HELPER ---------------------------------------------------------------------------	
	
	// CURSO - PROFESOR
	
	public void addToCurso(Curso curso) {
		this.curso = curso;
		curso.getProfesores().add(this);
	}
	
	public void removeFromCurso(Curso curso) {
		curso.getProfesores().remove(this);
		this.curso = null;		
	}
	
	
	
	// ACTIVIDAD COMPLEMENTARIA - PROFESOR
	
	public void addToActividad(ActividadComplementaria actividad) {
		this.encargado = actividad;
		actividad.getProfesores().add(this);
	}
	
	public void removeFromActividad(ActividadComplementaria actividad) {
		encargado.getProfesores().remove(this);
		this.encargado = null;		
	}
	
	
	
	
}


























