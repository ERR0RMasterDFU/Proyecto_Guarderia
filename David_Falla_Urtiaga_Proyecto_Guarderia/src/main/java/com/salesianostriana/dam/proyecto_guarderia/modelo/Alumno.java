package com.salesianostriana.dam.proyecto_guarderia.modelo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter 
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Alumno{

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private double precioMatricula;
	

// MTO (USUARIO) -----------------------------------------------------------------------------------

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "datos_id", referencedColumnName = "id")
	private DatosAlumno datos;
	
// OTM (OBSERVACION) -------------------------------------------------------------------------------	
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@OneToMany(mappedBy="alumno", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
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
	private Set<ActividadComplementaria> horario = new HashSet<>();

	
	
// MTO (CURSO) -----------------------------------------------------------------------------------
	
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name="fk_curso_alumno"))
	private Curso curso;
	
	
// MÉTODOS HELPER ------------------------------------------------------------------------------------------------------------------------------
	
	
	/*USUARIO - ALUMNO
	
	public void addToProgenitor(Usuario progenitor) {
		this.progenitor = progenitor;
		progenitor.getHijos().add(this);
	}
	
	public void removeFromProgenitor(Usuario progenitor) {
		progenitor.getHijos().remove(this);
		this.progenitor = null;		
	}*/
	

	// ALUMNO - ACTIVIDAD COMPLEMENTARIA
	
	public void addActividad(ActividadComplementaria ac) {
		this.horario.add(ac);
		ac.getAlumnos().add(this);
	}
	
	public void removeActividad(ActividadComplementaria ac) {
		ac.getAlumnos().remove(this);
		this.horario.remove(ac);
	}

	
	//ALUMNO - CURSO
	
	public void addToCurso(Curso curso) {
		this.curso = curso;
		curso.getAlumnos().add(this);
	}
	
	public void removeFromCurso(Curso curso) {
		curso.getAlumnos().remove(this);
		this.curso = null;		
	}
	
	
	
}	