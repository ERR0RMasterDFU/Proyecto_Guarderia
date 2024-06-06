package com.salesianostriana.dam.proyecto_guarderia.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.salesianostriana.dam.proyecto_guarderia.modelo.Alumno;
import com.salesianostriana.dam.proyecto_guarderia.modelo.Profesor;

public interface ProfesorRepositorio extends JpaRepository<Profesor, Long>{

	@Query("""
			SELECT a
			FROM Alumno a JOIN ActividadComplementaria ac 
			WHERE a.curso.id = ?1 AND ac.id = ?2
			""")
	public List<Alumno> findAlumnosByActividadIdYCursoId (long idCurso, long idActividad);
}


//SELECT * FROM ALUMNO a JOIN HORARIO h ON (a.id = h.alumno_id) WHERE a.curso_id = 2 AND h.actividad_id = 6
