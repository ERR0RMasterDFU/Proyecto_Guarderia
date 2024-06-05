package com.salesianostriana.dam.proyecto_guarderia.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.proyecto_guarderia.modelo.Curso;
import com.salesianostriana.dam.proyecto_guarderia.modelo.Profesor;
import com.salesianostriana.dam.proyecto_guarderia.repositorio.CursoRepositorio;
import com.salesianostriana.dam.proyecto_guarderia.repositorio.UsuarioRepositorio;
import com.salesianostriana.dam.proyecto_guarderia.servicio.base.ServicioBaseImpl;

@Service
public class CursoServicio extends ServicioBaseImpl<Curso, Long, CursoRepositorio> {

	@Autowired
	private CursoRepositorio repositorio;
	
	
	public CursoServicio(UsuarioRepositorio repo) {
		super(repo);
	}

	
	// MÉTODO QUE FILTRA PROFESORES POR CURSO
	public List<Profesor>findProfesoresByCurso(long id){
		List <Profesor> profesoresFiltradosPorCurso = repositorio.findProfesoresByCurso(id);
		return profesoresFiltradosPorCurso;
	}


	// MÉTODO QUE CUENTA CUÁNTOS PROFESORES HAY EN UN CURSO
	public int contarProfesoresDeUnCurso(long id) {
		int numProfesores = repositorio.findNumProfesoresByCurso(id);
		return numProfesores;
	}
	
}
