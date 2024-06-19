package com.salesianostriana.dam.proyecto_guarderia.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.salesianostriana.dam.proyecto_guarderia.modelo.Alumno;
import com.salesianostriana.dam.proyecto_guarderia.modelo.Observacion;
import com.salesianostriana.dam.proyecto_guarderia.modelo.Profesor;

public interface ProfesorRepositorio extends JpaRepository<Profesor, Long>{


// BOTÓN ALUMNOS (PROFESOR) --------------------------------------------------------------------------------------------------
	
	@Query("""
			SELECT a
			FROM Alumno a JOIN a.horario h
			WHERE a.curso.id = ?1 AND h.id = ?2
			""")
	public List<Alumno> findAlumnosByActividadIdYCursoId (long idCurso, long idActividad);
	
// ---------------------------------------------------------------------------------------------------------------------------
	
	
// CUENTA CUÁNTAS OBSERVACIONES TIENE UN PROFESOR ----------------------------------------------------------------------------
	
	@Query("""
			SELECT count(o)
			FROM Observacion o
			WHERE o.profesor.id = ?1
			""")
	public int countObservacionesByProfesorId (long id);
	
// ---------------------------------------------------------------------------------------------------------------------------


// BOTÓN OBSERVACIONES (PROFESOR) --------------------------------------------------------------------------------------------
	
	@Query("""
			SELECT o
			FROM Observacion o
			WHERE o.profesor.id = ?1
			""")
	public List<Observacion> findObservacionesByProfesorId (long id);
	
// ---------------------------------------------------------------------------------------------------------------------------
	
}
	