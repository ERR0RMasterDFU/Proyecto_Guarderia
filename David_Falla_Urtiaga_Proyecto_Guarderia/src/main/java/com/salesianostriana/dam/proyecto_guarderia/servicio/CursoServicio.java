package com.salesianostriana.dam.proyecto_guarderia.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.proyecto_guarderia.modelo.Alumno;
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

	
// BOTÓN PROFESORES (CURSO) --------------------------------------------------------------------------------------------------
	
	public List<Profesor>filtrarProfesoresPorCurso(long id){
		List <Profesor> profesoresFiltradosPorCurso = repositorio.findProfesoresByCurso(id);
		return profesoresFiltradosPorCurso;
	}
	
// ---------------------------------------------------------------------------------------------------------------------------

	
// BOTÓN ALUMNOS (CURSO) -----------------------------------------------------------------------------------------------------
	
	public List<Alumno>filtrarAlumnosPorCurso(long id){
		List<Alumno> alumnosFiltradosPorCurso = repositorio.findAlumnosByCurso(id);
		return alumnosFiltradosPorCurso;
		}
	
// ---------------------------------------------------------------------------------------------------------------------------
	
	
// CUENTA LOS PROFESORES QUE HAY EN UN CURSO ---------------------------------------------------------------------------------
	
	public int contarProfesoresDeUnCurso(long id) {
		int numProfesores = repositorio.findNumProfesoresByCurso(id);
		return numProfesores;
	}
	
// ---------------------------------------------------------------------------------------------------------------------------
	
					
// CUENTA LOS ALUMNOS QUE HAY EN UN CURSO ------------------------------------------------------------------------------------
	
	public int contarAlumnosDeUnCurso(long id) {
		int numAlumnos = repositorio.findNumAlumnosByCurso(id);
		return numAlumnos;
	}
	
// ---------------------------------------------------------------------------------------------------------------------------
	
}
