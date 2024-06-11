package com.salesianostriana.dam.proyecto_guarderia.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.salesianostriana.dam.proyecto_guarderia.modelo.Alumno;
import com.salesianostriana.dam.proyecto_guarderia.modelo.Observacion;
import com.salesianostriana.dam.proyecto_guarderia.modelo.Profesor;

public interface ProfesorRepositorio extends JpaRepository<Profesor, Long>{

	//SELECT * FROM ALUMNO a JOIN HORARIO h ON (a.id = h.alumno_id) WHERE a.curso_id = 2 AND h.actividad_id = 6
	// SELECT a FROM Alumno a JOIN a.horario h WHERE a.curso.id =?1 and h.id = ?2 
	
	@Query("""
			SELECT a
			FROM Alumno a JOIN a.horario h
			WHERE a.curso.id = ?1 AND h.id = ?2
			""")
	public List<Alumno> findAlumnosByActividadIdYCursoId (long idCurso, long idActividad);
	
	
	//SELECT COUNT (*) FROM OBSERVACION WHERE observacion.profesor_id = 2
	
	@Query("""
			SELECT count(o)
			FROM Observacion o
			WHERE o.profesor.id = ?1
			""")
	public int countObservacionesByProfesorId (long idProfesor);


	
	@Query("""
			SELECT o
			FROM Observacion o
			WHERE o.profesor.id = ?1
			""")
	public List<Observacion> findObservacionesByProfesorId (long idProfesor);

	
	
}

	