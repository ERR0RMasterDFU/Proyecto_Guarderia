package com.salesianostriana.dam.proyecto_guarderia.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor
@Embeddable
public class ObservacionPK implements Serializable {
	    
	private static final long serialVersionUID = 1L;
		
	private long alumno_id;
	private long profesor_id;

}