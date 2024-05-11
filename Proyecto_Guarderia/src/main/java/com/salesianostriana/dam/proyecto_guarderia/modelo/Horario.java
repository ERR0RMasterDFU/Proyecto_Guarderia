package com.salesianostriana.dam.proyecto_guarderia.modelo;

import java.util.List;
import java.util.ArrayList;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class Horario {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private long idHorario;
	
	private double guarderia;
	private double aulaMatinal;
	private double comedor;
	private double siesta;
	private double extraescolares;
	
	
	// MANY TO ONE (TUTOR LEGAL) ----------------------------------------------------------------------------------------------------------------

	@ManyToOne
	private TutorLegal tutorLegal;

	
	// ONE TO MANY (ALUMNO) ----------------------------------------------------------------------------------------------------------------

	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@OneToMany(mappedBy="horario", fetch = FetchType.EAGER)
	@Builder.Default
	private List<Alumno> alumnos = new ArrayList<>();
	
	
	
	// MÉTODOS HELPER ------------------------------------------------------------------------------------------------------------------------------

	public void agregarATutorLegal(TutorLegal tutorLegal) {
		this.tutorLegal = tutorLegal;
		tutorLegal.getHorarios().add(this);
	}
	
	public void eliminarDeTutorLegal(TutorLegal tutorLegal) {
		tutorLegal.getHorarios().remove(this);
		this.tutorLegal = null;		
	}
}

