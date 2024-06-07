package com.salesianostriana.dam.proyecto_guarderia.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.proyecto_guarderia.modelo.Alumno;
import com.salesianostriana.dam.proyecto_guarderia.modelo.Profesor;
import com.salesianostriana.dam.proyecto_guarderia.repositorio.ProfesorRepositorio;
import com.salesianostriana.dam.proyecto_guarderia.repositorio.UsuarioRepositorio;
import com.salesianostriana.dam.proyecto_guarderia.servicio.base.ServicioBaseImpl;

@Service
public class ProfesorServicio extends ServicioBaseImpl<Profesor, Long, ProfesorRepositorio>{

	@Autowired
	private ProfesorRepositorio repositorio;
	
	public ProfesorServicio(UsuarioRepositorio repo) {
		super(repo);
		// TODO Auto-generated constructor stub
	}
	
	public List<Alumno> filtrarAlumnosPorCursoYActividad (long idCurso, long idActividad){
		List<Alumno> obtenerAlumnos = repositorio.findAlumnosByActividadIdYCursoId(idCurso, idActividad);
		return obtenerAlumnos;
	}

}
