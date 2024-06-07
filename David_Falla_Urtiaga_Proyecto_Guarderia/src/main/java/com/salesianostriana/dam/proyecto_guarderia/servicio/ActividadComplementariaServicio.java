package com.salesianostriana.dam.proyecto_guarderia.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.proyecto_guarderia.modelo.ActividadComplementaria;
import com.salesianostriana.dam.proyecto_guarderia.modelo.Alumno;
import com.salesianostriana.dam.proyecto_guarderia.modelo.Profesor;
import com.salesianostriana.dam.proyecto_guarderia.repositorio.ActividadComplementariaRepositorio;
import com.salesianostriana.dam.proyecto_guarderia.repositorio.UsuarioRepositorio;
import com.salesianostriana.dam.proyecto_guarderia.servicio.base.ServicioBaseImpl;

@Service
public class ActividadComplementariaServicio extends ServicioBaseImpl<ActividadComplementaria, Long, ActividadComplementariaRepositorio> {

	@Autowired
	private ActividadComplementariaRepositorio repositorio;
	
	public ActividadComplementariaServicio(UsuarioRepositorio repo) {
		super(repo);
		// TODO Auto-generated constructor stub
	}
	
	// MÉTODO QUE FILTRA PROFESORES POR ACTIVIDAD
	public List<Profesor>filtrarProfesoresPorActividad(long id){
		List<Profesor> profesoresFiltradosPorActividad = repositorio.findProfesoresByActividad(id);
		return profesoresFiltradosPorActividad;
	}
	
	
	// MÉTODO QUE FILTRA PROFESORES POR ACTIVIDAD
	public List<Alumno>filtrarAlumnosPorActividad(long id){
		List<Alumno> alumnosFiltradosPorActividad = repositorio.findAlumnosByActividad(id);
		return alumnosFiltradosPorActividad;
	}
	
	
	// MÉTODO QUE CUENTA CUÁNTOS PROFESORES HAY EN UNA ACTIVIDAD
	public int contarProfesoresDeUnaActividad(long id) {
		return repositorio.findNumProfesoresByActividad(id);
		 
	}
		
		
}
