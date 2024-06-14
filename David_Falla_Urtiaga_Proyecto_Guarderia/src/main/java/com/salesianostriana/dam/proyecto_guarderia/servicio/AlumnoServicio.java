package com.salesianostriana.dam.proyecto_guarderia.servicio;

import java.time.LocalDate;
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

	
// PANTALLA DE ALUMNOS (USUARIO) ---------------------------------------------------------------------------------------------
	
	public List<Alumno> filtrarAlumnosPorUsuario (Usuario usuario){
		List<Alumno> alumnosFiltrados = repositorio.findAlumnoByUsuario(usuario);
		return alumnosFiltrados;
	}
	
// ---------------------------------------------------------------------------------------------------------------------------
	

// BOTÓN OBSERVACIONES (ALUMNO) ----------------------------------------------------------------------------------------------
	
	public List<Observacion> filtrarObservacionesPorAlumnoId (long idAlumno) {
		List<Observacion> observacionesFiltradasAlumno = repositorio.findObservacionesByAlumno(idAlumno);
		return observacionesFiltradasAlumno;
	}
	
// ---------------------------------------------------------------------------------------------------------------------------
	
	
// BOTÓN TUTOR LEGAL (ALUMNO) ------------------------------------------------------------------------------------------------
	
	public Usuario findUsuarioByAlumnoId (long idAlumno) {
		Usuario obtenerUsuarioEncontrado = repositorio.findUsuarioByAlumnoId(idAlumno);
		return obtenerUsuarioEncontrado;
	}
	
// ---------------------------------------------------------------------------------------------------------------------------
	
	
// BOTÓN HORARIO (ALUMNO) ----------------------------------------------------------------------------------------------------
	
	public List<ActividadComplementaria> filtrarActividadesPorAlumnoId (long id){
		List<ActividadComplementaria> actividadesFiltradas = repositorio.findHorarioByAlumnoId(id);
		return actividadesFiltradas;
	}

// ---------------------------------------------------------------------------------------------------------------------------
	
	
// MÉTODO QUE DESASOCIA UN PROFESOR DE UNA OBSERVACIÓN PARA PERIMITR QUE EL ALUMNO PUEDA SER BORRADO -------------------------
	
	public void desvincularProfesoresDeObservacion (Optional<Alumno> alumnoAEditar, long id) {
		
		List<Observacion> observacionesAlumno = alumnoAEditar.get().getObservaciones();
		List<Profesor> listaProfesoresObs = obServicio.buscarProfesoresPorObservacionAlumno(id);
		
		for (Observacion observacion : observacionesAlumno) {
			for (Profesor profesor : listaProfesoresObs) {
				observacion.removeFromProfesor(profesor);
			}
		}
		
	}
	
// ---------------------------------------------------------------------------------------------------------------------------
	
	
// MÉTODO QUE HACE QUE LOS ALUMNOS CUMPLAN AÑOS ------------------------------------------------------------------------------
	
	public void cumplirAnios () {
		
		LocalDate cumple = LocalDate.now();
		int uno = 1;
		
		for (Alumno alumno : repositorio.findAll()) {
			
			if(alumno.getFechaNacimiento() == cumple) {
				alumno.setEdad(alumno.getEdad()+uno);
			}	
		}
	}
	
// ---------------------------------------------------------------------------------------------------------------------------
	
}
