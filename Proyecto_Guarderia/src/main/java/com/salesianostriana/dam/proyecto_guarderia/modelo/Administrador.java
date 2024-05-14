package com.salesianostriana.dam.proyecto_guarderia.modelo;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
@Entity
@DiscriminatorValue("Admin")
public class Administrador extends Usuario {
	
	public Administrador(long idUsuario, String username, String password, String email) {
		super(idUsuario, username, password, email);
	}
	
}
