package com.salesianostriana.dam.proyecto_guarderia.repositorio;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.salesianostriana.dam.proyecto_guarderia.modelo.Alumno;
import com.salesianostriana.dam.proyecto_guarderia.modelo.Observacion;
import com.salesianostriana.dam.proyecto_guarderia.modelo.Profesor;
import com.salesianostriana.dam.proyecto_guarderia.modelo.Usuario;

public interface ObservacionRepositorio extends JpaRepository<Observacion, Long>{

	
// BOTÓN DATOS DEL ALUMNO (OBSERVACIÓN) --------------------------------------------------------------------------------------
	
	@Query("""
			SELECT a
			FROM Alumno a
			WHERE a.id = ?1
			""")
	public Alumno findAlumnoById(long id);
	
// ---------------------------------------------------------------------------------------------------------------------------
	
	
// PANTALLA DE OBSERVACIONES DEL USUARIO -------------------------------------------------------------------------------------
	
	@Query("""
			SELECT o
			FROM Observacion o 
			WHERE o.alumno.progenitor = ?1
			""")
	public List<Observacion> findObservacionesByUsuario(Usuario usuario);
	
// ---------------------------------------------------------------------------------------------------------------------------
	
	
// CONSULTA QUE DEVUELVE LOS ALUMNOS QUE ESTÁN ASOCIADOS CON ALGUNA OBSERVACIÓN DE UN PROFESOR -------------------------------
	
	@Query("""
			SELECT o.alumno
			FROM Observacion o
			WHERE o.profesor.id = ?1
			""")
	public List<Alumno> findAlumnosByObservaciones(long id);
	
// ---------------------------------------------------------------------------------------------------------------------------
	
	
// CONSULTA QUE DEVUELVE LOS PROFESORES QUE ESTÁN ASOCIADOS CON ALGUNA OBSERVACIÓN DE UN ALUMNO ------------------------------
	
	@Query("""
			SELECT o.profesor
			FROM Observacion o
			WHERE o.alumno.id = ?1
			""")
	public List<Profesor> findProfesoresByObservaciones(long id);
	
// ---------------------------------------------------------------------------------------------------------------------------
	
	
// ASIDE DEL USUARIO ---------------------------------------------------------------------------------------------------------
	
	@Query("""
			SELECT o
			FROM Observacion o 
			WHERE o.alumno.progenitor = ?1
			""")
	public Page<Observacion> observacionesDeUsuario(Usuario usuario, Pageable p);
	
// ---------------------------------------------------------------------------------------------------------------------------	

}
