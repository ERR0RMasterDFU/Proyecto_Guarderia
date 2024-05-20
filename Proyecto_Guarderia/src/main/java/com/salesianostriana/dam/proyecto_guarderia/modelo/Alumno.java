package com.salesianostriana.dam.proyecto_guarderia.modelo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ForeignKey;
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
public class Alumno {

	@Id @GeneratedValue
	private long id;
	
	private String nombre;
	private String primerApellido;
	private String segundoApellido;
	private int edad;
	private String direccion;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaNacimiento;
	

// MTO (USUARIO) --------------------------------------------------------
	@ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name="fk_progenitor_alumno"))
	private Usuario progenitor;
	
	
// OTM (OBSERVACION) --------------------------------------------------------	
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@OneToMany(mappedBy="alumno", fetch = FetchType.EAGER)
	@Builder.Default
	private List<Observacion> observaciones = new ArrayList<>();
	
	
// MÉTODOS HELPER ------------------------------------------------------------------------------------------------------------------------------
	
	public void addToCurso(Usuario progenitor) {
		this.progenitor = progenitor;
		progenitor.getHijos().add(this);
	}
	
	public void removeFromCurso(Usuario progenitor) {
		progenitor.getHijos().remove(this);
		this.progenitor = null;		
	}
	


	
	
}	