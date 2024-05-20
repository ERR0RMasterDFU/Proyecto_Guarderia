package com.salesianostriana.dam.proyecto_guarderia.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity 
@Data 
@NoArgsConstructor 
@AllArgsConstructor 
@Builder
public class ActividadComplementaria {

	@Id @GeneratedValue
	private long id;
	
	private String nombre;
	private double precio;
}
