package com.salesianostriana.dam.proyecto_guarderia.modelo;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter 
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Data
public class TutorLegal extends Usuario {

	private String nombre;
	private String primerApellido;
	private String segundoApellido;
	private String numTelefono;
	private int numHijos;
	private Progenitor progenitor;
	
	
	//CONSTRUCTOR ---------------------------------------------------------------------------------------------------------------
	
	public TutorLegal(long idUsuario, String dni, String password, String email, String nombre, String primerApellido,
			String segundoApellido, String numTelefono, int numHijos, Progenitor progenitor, List<Alumno> hijos,
			List<Horario> horarios, List<Observacion> observaciones) {
		super(idUsuario, dni, password, email);
		this.nombre = nombre;
		this.primerApellido = primerApellido;
		this.segundoApellido = segundoApellido;
		this.numTelefono = numTelefono;
		this.numHijos = numHijos;
		this.progenitor = progenitor;
		this.hijos = hijos;
		this.horarios = horarios;
		this.observaciones = observaciones;
	}
	
	
	// ONE TO MANY (ALUMNO) -----------------------------------------------------------------------------------------------------------------

	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@OneToMany(mappedBy="tutorLegal", fetch = FetchType.EAGER)
	@Builder.Default
	private List<Alumno> hijos = new ArrayList<>();

	
	// ONE TO MANY (HORARIO) ----------------------------------------------------------------------------------------------------------------

	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@OneToMany(mappedBy="tutorLegal", fetch = FetchType.EAGER)
	@Builder.Default
	private List<Horario> horarios = new ArrayList<>();
	
	
	// MANY TO MANY (OBSERVACIÓN) ----------------------------------------------------------------------------------------------------------------
	
	@ManyToMany(fetch = FetchType.EAGER)
	/*@JoinTable(
		name = "matricula",
		joinColumns = @JoinColumn(name="tutor_legal_id"),
		inverseJoinColumns = @JoinColumn(name="observacion_id")
	)*/
	@Builder.Default
	private List<Observacion> observaciones = new ArrayList<>();

	
	// Alumno - Asignaturas
	public void agregarObservacion(Observacion o) {
		this.observaciones.add(o);
		o.getTutoresLegales().add(this);
	}
	
	public void removeAsignatura(Observacion o) {
		o.getTutoresLegales().remove(this);
		this.observaciones.remove(o);
	}

	
	//SEGURIDAD (HERENCIA CON ROL USUARIO) --------------------------------------------------------------------------------------
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
	}
	
}

	

	
