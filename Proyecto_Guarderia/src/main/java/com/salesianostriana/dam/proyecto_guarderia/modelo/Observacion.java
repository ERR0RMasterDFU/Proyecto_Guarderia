package com.salesianostriana.dam.proyecto_guarderia.modelo;

import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
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

	@EmbeddedId
	private ObservacionPK observacionPK = new ObservacionPK();
		
		
	public Observacion(Alumno a, Profesor p) {
		this.alumno = a;
		this.profesor = p;
	}

	@ManyToOne
	@MapsId("alumno_id")
	@JoinColumn(name = "alumno_id")
	private Alumno alumno;

	@ManyToOne
	@MapsId("profesor_id")
	@JoinColumn(name = "profesor_id")
	private Profesor profesor;

	private Periodo periodo;
	private LocalDateTime fechaObservacion;
	private String mensaje;

	
	// MANY TO MANY (TUTOR LEGAL) ----------------------------------------------------------------------------------------------------------------

	@ManyToMany(mappedBy="observaciones", fetch = FetchType.EAGER)
	@Builder.Default
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	private List<TutorLegal> tutoresLegales = new ArrayList<>();
	
	
	// MÉTODOS HELPER ------------------------------------------------------------------------------------------------------------------------------

	public void agregarAProfesor(Profesor p) {
		p.getObservaciones().add(this);
		this.profesor = p;
	}

	public void removeFromAlumno(Profesor p) {
		p.getObservaciones().remove(this);
		this.profesor = null;
	}

	
}

	
