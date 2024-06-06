package com.salesianostriana.dam.proyecto_guarderia.servicio;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.proyecto_guarderia.modelo.Usuario;
import com.salesianostriana.dam.proyecto_guarderia.repositorio.UsuarioRepositorio;
import com.salesianostriana.dam.proyecto_guarderia.servicio.base.ServicioBaseImpl;

@Service
public class UsuarioServicio extends ServicioBaseImpl<Usuario, Long, UsuarioRepositorio>{

	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	private UsuarioRepositorio repositorio;
	
	
	public UsuarioServicio(UsuarioRepositorio repo) {
		super(repo);
	}

	public Optional<Usuario> buscarPorDni(String username) {
		return repository.findFirstByUsername(username);
	}

	
	public Usuario saveNewUsuario(Usuario u) {
		u.setPassword(encoder.encode(u.getPassword()));
		return save(u);
	}
	
	//public Usuario editarUsuario(Usuario u) {
		
		// Editar el usuario sin cambiarle la contraseña
		
		// 1. Rescato el usuario de la bd.
		// 2. Actualizo "todos" los atributos menos el password.
		// 3. Guardo el usuario en la base de datos.
		// 4. Actualizo el contexto de seguridad con el nuevo usuario (Carlos Román)
		
		
		
		
	//}
	
	public int contarAlumnosdeUnUsuario(long id) {
		return repositorio.findNumAlumnosByUsuario(id);
		
	}
	
}

	