package com.salesianostriana.dam.proyecto_guarderia.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.proyecto_guarderia.modelo.ActividadComplementaria;
import com.salesianostriana.dam.proyecto_guarderia.modelo.Alumno;
import com.salesianostriana.dam.proyecto_guarderia.modelo.Observacion;
import com.salesianostriana.dam.proyecto_guarderia.modelo.Profesor;
import com.salesianostriana.dam.proyecto_guarderia.modelo.Usuario;
import com.salesianostriana.dam.proyecto_guarderia.repositorio.AlumnoRepositorio;
import com.salesianostriana.dam.proyecto_guarderia.repositorio.UsuarioRepositorio;
import com.salesianostriana.dam.proyecto_guarderia.servicio.base.ServicioBaseImpl;

@Service
public class AlumnoServicio extends ServicioBaseImpl<Alumno, Long, AlumnoRepositorio>{

	@Autowired
	private AlumnoRepositorio repositorio;
	
	@Autowired
	private ObservacionServicio obServicio;
	
	public AlumnoServicio(UsuarioRepositorio repo) {
		super(repo);
		// TODO Auto-generated constructor stub
	}


	public List<Alumno> filtrarAlumnosPorUsuario (Usuario usuario){
		List<Alumno> alumnosFiltrados = repositorio.findAlumnoByUsuario(usuario);
		return alumnosFiltrados;
	}
	
	
	public List<Observacion> filtrarObservacionesPorAlumnoId (long idAlumno) {
		List<Observacion> observacionesFiltradasAlumno = repositorio.findObservacionesByAlumno(idAlumno);
		return observacionesFiltradasAlumno;
	}
	
	
	public Usuario findUsuarioByAlumnoId (long idAlumno) {
		Usuario obtenerUsuarioEncontrado = repositorio.findUsuarioByAlumnoId(idAlumno);
		return obtenerUsuarioEncontrado;
	}
	
	
	public List<ActividadComplementaria> filtrarActividadesPorAlumnoId (long id){
		List<ActividadComplementaria> actividadesFiltradas = repositorio.findHorarioByAlumnoId(id);
		return actividadesFiltradas;
	}
	
	
	public void desvincularProfesoresDeObservacion (Optional<Alumno> alumnoAEditar, long id) {
		
		List<Observacion> observacionesAlumno = alumnoAEditar.get().getObservaciones();
		List<Profesor> listaProfesoresObs = obServicio.buscarProfesoresPorObservacionAlumno(id);
		
		for (Observacion observacion : observacionesAlumno) {
			for (Profesor profesor : listaProfesoresObs) {
				observacion.removeFromProfesor(profesor);
			}
		}
		
	}
	
}
