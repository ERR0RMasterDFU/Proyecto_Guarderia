package com.salesianostriana.dam.proyecto_guarderia.modelo;

import java.util.ArrayList;
import java.util.List;

/*import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;*/

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
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

@Getter 
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Data
public class Usuario /*implements UserDetails*/ {

	@Id @GeneratedValue
	private long id;
	
	private String username;
	private String password;
	private String nombre;
	private String primerApellido;
	private String segundoApellido;
	private String dni;
	private String email;
	private String numTelefono;
	private int numHijos;
	private boolean admin;
	
	@Enumerated(EnumType.STRING)
	private Progenitor progenitor;
	
	
// OTM (ALUMNOS) --------------------------------------------------------	
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@OneToMany(mappedBy="progenitor", fetch = FetchType.EAGER)
	@Builder.Default
	private List<Alumno> hijos = new ArrayList<>();
	
	
	
// MTM (OBSERVACION) --------------------------------------------------------	
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name = "observacion",
			joinColumns = @JoinColumn(name="usuario_id"),
			inverseJoinColumns = @JoinColumn(name="observacion_id")
	)
	@Builder.Default
	private List<Observacion> observaciones = new ArrayList<>();

	
	
	
	
	
// MÉTODOS HELPER ----------------------------------------------------------------------------	
	
	public void agregarObservacion(Observacion o) {
		this.observaciones.add(o);
		o.getUsuarios().add(this);
	}
		
	public void eliminarObservacion(Observacion o) {
		o.getUsuarios().remove(this);
		this.observaciones.remove(o);
	}

	
/*SEGURIDAD ----------------------------------------------------------------------------------------------------------------------------------
	
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
	}*/
	
}
