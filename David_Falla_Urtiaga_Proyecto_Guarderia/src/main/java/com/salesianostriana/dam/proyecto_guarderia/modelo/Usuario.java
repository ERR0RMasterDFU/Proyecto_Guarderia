package com.salesianostriana.dam.proyecto_guarderia.modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
public class Usuario implements UserDetails {

	@Id @GeneratedValue
	private long id;
	
	@Column(unique = true)
	private String username;
	
	private String password;
	private String nombre;
	private String primerApellido;
	private String segundoApellido;
	
	@Column(unique = true)
	private String dni;
	
	private String email;
	private String numTelefono;
	private int numHijos;
	private boolean admin;
	
	@Enumerated(EnumType.STRING)
	private Progenitor progenitor;
	
 /*OTM (ALUMNOS) --------------------------------------------------------	
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@OneToMany(mappedBy="progenitor", fetch = FetchType.EAGER)
	@Builder.Default
	private List<Alumno> hijos = new ArrayList<>();*/
	
	
// OTM (DATOS ALUMNO) --------------------------------------------------------	
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@OneToMany(mappedBy="progenitor", fetch = FetchType.EAGER)
	@Builder.Default
	private List<DatosAlumno> hijos = new ArrayList<>(); 

	
//SEGURIDAD ----------------------------------------------------------------------------------------------------------------------------------
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		String role = "ROLE_";
		role += (admin) ? "ADMIN" : "USER";
		return List.of(new SimpleGrantedAuthority(role));
	}	

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	
}
