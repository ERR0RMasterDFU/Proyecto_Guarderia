package com.salesianostriana.dam.proyecto_guarderia.modelo;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Data
public class TutorLegal extends Usuario {

	private String nombre;
	private String primerApellido;
	private String segundoApellido;
	private String dni;
	private String numTelefono;
	private int numHijos;
	private Progenitor progenitor;
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@OneToMany(mappedBy="tutorLegal", fetch = FetchType.EAGER)
	@Builder.Default
	private List<Alumno> hijos; //= new ArrayList<>();
		

	// CONSTRUCTOR -------------------------------------------------------------------------------------------
	
	/*public TutorLegal(long idUsuario, String username, String password, String email, String nombre,
			String primerApellido, String segundoApellido, String dni, String numTelefono, int numHijos,
			Progenitor progenitor) {
		super(idUsuario, username, password, email);
		this.nombre = nombre;
		this.primerApellido = primerApellido;
		this.segundoApellido = segundoApellido;
		this.dni = dni;
		this.numTelefono = numTelefono;
		this.numHijos = numHijos;
		this.progenitor = progenitor;
	}*/
	
	
	// CONSTRUCTOR SIN SEGUNDO APELLIDO ----------------------------------------------------------------------
	
	public TutorLegal(String nombre, String primerApellido, String dni, String numTelefono, int numHijos,
			Progenitor progenitor, List<Alumno> hijos) {
		super();
		this.nombre = nombre;
		this.primerApellido = primerApellido;
		this.dni = dni;
		this.numTelefono = numTelefono;
		this.numHijos = numHijos;
		this.progenitor = progenitor;
		this.hijos = hijos;
	}


	public TutorLegal() {
		super();
	}
	

}