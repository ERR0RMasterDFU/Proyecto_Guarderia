package com.salesianostriana.dam.proyecto_guarderia.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.salesianostriana.dam.proyecto_guarderia.modelo.Alumno;
import com.salesianostriana.dam.proyecto_guarderia.modelo.Curso;
import com.salesianostriana.dam.proyecto_guarderia.modelo.Profesor;

public interface CursoRepositorio extends JpaRepository<Curso, Long>{

	
// BOTÓN PROFESORES (CURSO) --------------------------------------------------------------------------------------------------

	@Query("""
			SELECT p
			FROM Profesor p
			WHERE curso.id = ?1
			""")
	public List<Profesor> findProfesoresByCurso(long id);
	
// ---------------------------------------------------------------------------------------------------------------------------
	
	
// BOTÓN ALUMNOS (CURSO) -----------------------------------------------------------------------------------------------------
	
		@Query("""
				SELECT a
				FROM Alumno a
				WHERE curso.id = ?1
				""")
	public List<Alumno> findAlumnosByCurso(long id);
		
// ---------------------------------------------------------------------------------------------------------------------------
	
	
// CUENTA LOS PROFESORES QUE HAY EN UN CURSO ---------------------------------------------------------------------------------
		
	@Query("""
			SELECT count(p)
			FROM Profesor p
			WHERE curso.id = ?1
			""")
	public int findNumProfesoresByCurso(long id);
	
// ---------------------------------------------------------------------------------------------------------------------------
	
	
// CUENTA LOS ALUMNOS QUE HAY EN UN CURSO ------------------------------------------------------------------------------------
	
	@Query("""
			SELECT count(a)
			FROM Alumno a
			WHERE curso.id = ?1
			""")
	public int findNumAlumnosByCurso(long id);
	
// ---------------------------------------------------------------------------------------------------------------------------
	
}
