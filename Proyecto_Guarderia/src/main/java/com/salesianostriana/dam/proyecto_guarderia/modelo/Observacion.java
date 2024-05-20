package com.salesianostriana.dam.proyecto_guarderia.modelo;

import java.time.LocalDateTime;

import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class Observacion {

	@Id @GeneratedValue
	private long id;
	
	private LocalDateTime fechaObservacion;
	private String mensaje;
	
	
// MTO (USUARIO) --------------------------------------------------------
	
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name="fk_alumno_observacion"))
	private Alumno alumno;
	
	
// MÉTODOS HELPER ------------------------------------------------------------------------------------------------------------------------------
	
	public void addToCurso(Alumno alumno) {
		this.alumno = alumno;
		alumno.getObservaciones().add(this);
	}
	
	public void removeFromCurso(Alumno alumno) {
		alumno.getObservaciones().remove(this);
		this.alumno = null;		
	}
	
	
	
}
