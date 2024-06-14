package com.salesianostriana.dam.proyecto_guarderia.servicio;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.proyecto_guarderia.modelo.Alumno;
import com.salesianostriana.dam.proyecto_guarderia.modelo.Observacion;
import com.salesianostriana.dam.proyecto_guarderia.modelo.Profesor;
import com.salesianostriana.dam.proyecto_guarderia.modelo.Usuario;
import com.salesianostriana.dam.proyecto_guarderia.repositorio.ObservacionRepositorio;
import com.salesianostriana.dam.proyecto_guarderia.repositorio.UsuarioRepositorio;
import com.salesianostriana.dam.proyecto_guarderia.servicio.base.ServicioBaseImpl;

@Service
public class ObservacionServicio extends ServicioBaseImpl<Observacion, Long, ObservacionRepositorio> {

	@Autowired
	private ObservacionRepositorio repositorio;
	
	public ObservacionServicio(UsuarioRepositorio repo) {
		super(repo);
		// TODO Auto-generated constructor stub
	}
	

// MÉTODO QUE SETEA LA FECHA DE LA OBSERVACIÓN AL INSTANTE EN EL QUE SE PULSA AL SUBMIT --------------------------------------
	
	public LocalDateTime introducirFechaInstante (Observacion observacion) {
		LocalDateTime fechaObservacion = LocalDateTime.now();
		observacion.setFechaObservacion(fechaObservacion);
		return fechaObservacion;
	}
	
// ---------------------------------------------------------------------------------------------------------------------------
	

// MÉTODO QUE MUESTRA LAS 3 OBSERVACIONES MÁS RECIENTES POR FECHA DESCENDENTE (ASIDE DEL ADMIN) ------------------------------
	
	public List<Observacion> tresObservacionesMasRecientes () {
		
		/*return repositorio.findTop7OrderByFechaObservacionDesc();
		  return repositorio.findFirst7AndSort(Sort.by(Direction.DESC, "fechaObservacion"));*/
		
		Page<Observacion> page = repositorio.findAll(PageRequest.of(0, 3,Sort.by("fechaObservacion").descending()));
		return page.toList();
	}
	
// ---------------------------------------------------------------------------------------------------------------------------
	
	
// MÉTODO QUE MUESTRA LAS 3 OBSERVACIONES MÁS RECIENTES DE LOS ALUMNOS DEL USUARIO POR FECHA DESCENDENTE (ASIDE DEL USUARIO) -
	
	public List<Observacion> tresObservacionesMasRecientesUsuario (Usuario usuario) {
		
		/*return repositorio.findTop7OrderByFechaObservacionDesc();
		  return repositorio.findFirst7AndSort(Sort.by(Direction.DESC, "fechaObservacion"));*/
		
		Page<Observacion> page = repositorio.observacionesDeUsuario(usuario, PageRequest.of(0, 3,Sort.by("fechaObservacion").descending()));
		return page.toList();
	}
	
// ---------------------------------------------------------------------------------------------------------------------------

	
// BOTÓN DATOS DEL ALUMNO (OBSERVACIÓN) --------------------------------------------------------------------------------------
	
	public Alumno encontrarAlumnoPorId (long id) {
		Alumno alumnoBuscado = repositorio.findAlumnoById(id);
		return alumnoBuscado;
	}
	
// ---------------------------------------------------------------------------------------------------------------------------
	
	
// PANTALLA DE OBSERVACIONES DEL USUARIO -------------------------------------------------------------------------------------
	
	public List<Observacion> mostrarObservacionesPorUsuario (Usuario usuario){
		List<Observacion> observacionesUsuario = repositorio.findObservacionesByUsuario(usuario);
		return observacionesUsuario;
	}
	
// ---------------------------------------------------------------------------------------------------------------------------

	
// MÉTODO QUE DEVUELVE LOS ALUMNOS QUE ESTÁN ASOCIADOS CON ALGUNA OBSERVACIÓN DE UN PROFESOR ---------------------------------
	
	public List<Alumno> buscarAlumnosPorObservacionProfesor (long id) {
		return repositorio.findAlumnosByObservaciones(id);
	}
	
// ---------------------------------------------------------------------------------------------------------------------------

	
// CONSULTA QUE DEVUELVE LOS PROFESORES QUE ESTÁN ASOCIADOS CON ALGUNA OBSERVACIÓN DE UN ALUMNO ------------------------------
	
	public List<Profesor> buscarProfesoresPorObservacionAlumno (long id) {
		return repositorio.findProfesoresByObservaciones(id);
	}

// ---------------------------------------------------------------------------------------------------------------------------

}
