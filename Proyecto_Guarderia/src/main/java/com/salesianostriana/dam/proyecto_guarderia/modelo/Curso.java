package com.salesianostriana.dam.proyecto_guarderia.modelo;

import java.time.LocalDate;

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
public class Curso {

	@Id @GeneratedValue
	private long id;
	
	private String nombre;
	
}
