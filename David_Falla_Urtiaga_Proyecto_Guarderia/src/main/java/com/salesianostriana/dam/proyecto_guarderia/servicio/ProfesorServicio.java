package com.salesianostriana.dam.proyecto_guarderia.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.proyecto_guarderia.modelo.Alumno;
import com.salesianostriana.dam.proyecto_guarderia.modelo.Observacion;
import com.salesianostriana.dam.proyecto_guarderia.modelo.Profesor;
import com.salesianostriana.dam.proyecto_guarderia.repositorio.ProfesorRepositorio;
import com.salesianostriana.dam.proyecto_guarderia.repositorio.UsuarioRepositorio;
import com.salesianostriana.dam.proyecto_guarderia.servicio.base.ServicioBaseImpl;

@Service
public class ProfesorServicio extends ServicioBaseImpl<Profesor, Long, ProfesorRepositorio>{

	@Autowired
	private ProfesorRepositorio repositorio;
	
	@Autowired
	private ObservacionServicio obServicio;
	
	public ProfesorServicio(UsuarioRepositorio repo) {
		super(repo);
		// TODO Auto-generated constructor stub
	}
	
	
// BOTÓN ALUMNOS (PROFESOR) --------------------------------------------------------------------------------------------------
	
	public List<Alumno> filtrarAlumnosPorCursoYActividad (long idCurso, long idActividad){
		List<Alumno> obtenerAlumnos = repositorio.findAlumnosByActividadIdYCursoId(idCurso, idActividad);
		return obtenerAlumnos;
	}
	
// ---------------------------------------------------------------------------------------------------------------------------


// CUENTA CUÁNTAS OBSERVACIONES TIENE UN PROFESOR ----------------------------------------------------------------------------
	
	public int contarObservacionesPorProfesor (long id){
		int obtenerObservaciones = repositorio.countObservacionesByProfesorId(id);
		return obtenerObservaciones;
	}
	
// ---------------------------------------------------------------------------------------------------------------------------
	
	
// BOTÓN OBSERVACIONES (PROFESOR) --------------------------------------------------------------------------------------------
	
	public List<Observacion> filtrarObservacionesPorProfesor (long id) {
		List <Observacion> obtenerObservacionesProfesor = repositorio.findObservacionesByProfesorId(id);
		return obtenerObservacionesProfesor;
	}
	
// ---------------------------------------------------------------------------------------------------------------------------
	
	
// MÉTODO QUE DESASOCIA UN ALUMNO DE UNA OBSERVACIÓN PARA PERIMITR QUE EL PROFESOR PUEDA SER BORRADO -------------------------
	
	public void desvincularAlumnoDeObservacion (Optional<Profesor> profesorAEditar, long idProfesor) {
		
		List<Observacion> observacionesProfesor = profesorAEditar.get().getObservaciones();
		List<Alumno> listaAlumnoObs = obServicio.buscarAlumnosPorObservacionProfesor(idProfesor);
		
		for (Observacion observacion : observacionesProfesor) {
			for (Alumno alumno : listaAlumnoObs) {
				observacion.removeFromAlumno(alumno);
			}
		}
	}
	
// ---------------------------------------------------------------------------------------------------------------------------

}
