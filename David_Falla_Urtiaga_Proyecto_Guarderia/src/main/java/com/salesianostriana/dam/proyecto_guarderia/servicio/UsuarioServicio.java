package com.salesianostriana.dam.proyecto_guarderia.servicio;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.proyecto_guarderia.modelo.Usuario;
import com.salesianostriana.dam.proyecto_guarderia.repositorio.UsuarioRepositorio;
import com.salesianostriana.dam.proyecto_guarderia.servicio.base.ServicioBaseImpl;

@Service
public class UsuarioServicio extends ServicioBaseImpl<Usuario, Long, UsuarioRepositorio>{

	public UsuarioServicio(UsuarioRepositorio repo) {
		super(repo);
	}

	public Optional<Usuario> buscarPorDni(String username) {
		return repository.findFirstByUsername(username);
	}
}

	