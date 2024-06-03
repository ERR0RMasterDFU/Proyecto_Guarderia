package com.salesianostriana.dam.proyecto_guarderia.modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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
public class Observacion {

	@Id @GeneratedValue
	private long id;
	
	private LocalDateTime fechaObservacion;
	private String mensaje;
	
	
// MTO (ALUMNO) --------------------------------------------------------
	
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name="fk_alumno_observacion"))
	private Alumno alumno;
	
	
// MTM (USUARIO) ---------------------------------------------------------
	
	@ManyToMany(mappedBy="observaciones", fetch = FetchType.EAGER)
	@Builder.Default
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	private List<Usuario> usuarios = new ArrayList<>();
	
	
// MTO (PROFESOR) ----------------------------------------------------------
	
	 @ManyToOne
	 @JoinColumn(foreignKey = @ForeignKey(name="fk_profesor_observacion"))
	 private Profesor profesor;
	
	
	
// MÉTODOS HELPER ------------------------------------------------------------------------------------------------------------------------------
	

	 
	// ALUMNO - OBSERVACION
	 
	public void addToAlumno(Alumno alumno) {
		this.alumno = alumno;
		alumno.getObservaciones().add(this);
	}
	
	public void removeFromAlumno(Alumno alumno) {
		alumno.getObservaciones().remove(this);
		this.alumno = null;		
	}
	
	
	// PROFESOR -OBSERVACION
	
	public void addToProfesor(Profesor profesor) {
		this.profesor = profesor;
		profesor.getObservaciones().add(this);
	}
	
	public void removeFromProfesor(Profesor profesor) {
		profesor.getObservaciones().remove(this);
		this.profesor = null;		
	}	
	
	
}
