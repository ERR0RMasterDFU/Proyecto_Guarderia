package com.salesianostriana.dam.proyecto_guarderia.servicio;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.proyecto_guarderia.modelo.Curso;
import com.salesianostriana.dam.proyecto_guarderia.repositorio.CursoRepositorio;
import com.salesianostriana.dam.proyecto_guarderia.repositorio.UsuarioRepositorio;
import com.salesianostriana.dam.proyecto_guarderia.servicio.base.ServicioBaseImpl;

@Service
public class CursoServicio extends ServicioBaseImpl<Curso, Long, CursoRepositorio> {

	public CursoServicio(UsuarioRepositorio repo) {
		super(repo);
		// TODO Auto-generated constructor stub
	}



}
