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
public class Periodo {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String nombre;
	private double precio;
	
	
// MANY TO ONE (USUARIO) ------------------------------------------------------------------------------------------

	@ManyToOne
	private Usuario usuario;

	
// ONE TO MANY (ALUMNO) -------------------------------------------------------------------------------------------

	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@OneToMany(mappedBy="horario", fetch = FetchType.EAGER)
	@Builder.Default
	private List<Alumno> alumnos = new ArrayList<>();
	
	
// MÉTODOS HELPER -------------------------------------------------------------------------------------------------

	public void agregarAUsuario(Usuario usuario) {
		this.usuario = usuario;
		usuario.getHorario().add(this);
	}
	
	public void eliminarDeUsuario(Usuario usuario) {
		usuario.getHorario().remove(this);
		this.usuario = null;		
	}
}

