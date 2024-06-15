package com.salesianostriana.dam.proyecto_guarderia.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity 
@Data 
@NoArgsConstructor 
@AllArgsConstructor 
@SuperBuilder
@Inheritance(strategy = InheritanceType.JOINED)
public class DatosAlumno {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String nombre;
	private String primerApellido;
	private String segundoApellido;
	private int edad;
	private String direccion;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaNacimiento;
	
	private boolean validos;
	
	
	// MTO (USUARIO) -----------------------------------------------------------------------------------
	
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name="fk_progenitor_Datosalumno"))
	private Usuario progenitor;
	

	
	// MÉTODOS HELPER ------------------------------------------------------------------------------------------------------------------------------
	
	
	//USUARIO - DATOS ALUMNO
		
	public void addToProgenitor(Usuario progenitor) {
		this.progenitor = progenitor;
		progenitor.getHijos().add(this);
	}
		
	public void removeFromProgenitor(Usuario progenitor) {
		progenitor.getHijos().remove(this);
		this.progenitor = null;		
	}
	
}
