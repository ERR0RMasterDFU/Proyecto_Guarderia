package com.salesianostriana.dam.proyecto_guarderia.modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/*import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;*/

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
import lombok.experimental.SuperBuilder;

@Getter 
@Setter
/*@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)*/
@AllArgsConstructor
@NoArgsConstructor
@Entity
//@SuperBuilder
@Builder
@Data
public class Usuario implements UserDetails {

	@Id @GeneratedValue
	private long id;
	
	private String username;
	private String dni;
	private String password;
	private String email;
	
	private String nombre;
	private String primerApellido;
	private String segundoApellido;
	private String numTelefono;
	private int numHijos;
	
	@Enumerated(EnumType.STRING)
	private Progenitor progenitor;
	
	private boolean admin;
	
	
	// ONE TO MANY (ALUMNO) -----------------------------------------------------------------------------------------------------------------

	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@OneToMany(mappedBy="usuario", fetch = FetchType.EAGER)
	@Builder.Default
	private List<Alumno> hijos = new ArrayList<>();

	
	// ONE TO MANY (HORARIO) ----------------------------------------------------------------------------------------------------------------

	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@OneToMany(mappedBy="usuario", fetch = FetchType.EAGER)
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
		o.getUsuarios().add(this);
	}
	
	public void removeAsignatura(Observacion o) {
		o.getUsuarios().remove(this);
		this.observaciones.remove(o);
	}

	
	//SEGURIDAD (HERENCIA CON ROL USUARIO) --------------------------------------------------------------------------------------
	
	/*@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
	}*/
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		String role = "ROLE_";
		role += (admin) ? "ADMIN" : "USER";
		return List.of(new SimpleGrantedAuthority(role));
	}	


	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}
	
}

	

	
