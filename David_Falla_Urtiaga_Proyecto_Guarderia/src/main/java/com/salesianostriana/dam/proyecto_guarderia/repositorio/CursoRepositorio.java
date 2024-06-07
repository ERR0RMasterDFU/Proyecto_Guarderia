package com.salesianostriana.dam.proyecto_guarderia.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.salesianostriana.dam.proyecto_guarderia.modelo.Alumno;
import com.salesianostriana.dam.proyecto_guarderia.modelo.Curso;
import com.salesianostriana.dam.proyecto_guarderia.modelo.Profesor;

public interface CursoRepositorio extends JpaRepository<Curso, Long>{

	// FILTRA PROFESORES POR CURSO 
	@Query("""
			SELECT p
			FROM Profesor p
			WHERE curso.id = :curso
			""")
	public List<Profesor> findProfesoresByCurso(@Param("curso") long id);
	
	
	// FILTRA ALUMNOS POR CURSO 
		@Query("""
				SELECT a
				FROM Alumno a
				WHERE curso.id = :curso
				""")
	public List<Alumno> findAlumnosByCurso(@Param("curso") long id);
	
	
	// CUENTA LOS PROFESORES QUE HAY EN UN CURSO
	@Query("""
			SELECT count(p)
			FROM Profesor p
			WHERE curso.id = :curso
			""")
	public int findNumProfesoresByCurso(@Param("curso") long id);
	
	
	// CUENTA LOS ALUMNOS QUE HAY EN UN CURSO
	@Query("""
			SELECT count(a)
			FROM Alumno a
			WHERE curso.id = :curso
			""")
	public int findNumAlumnosByCurso(@Param("curso") long id);
}


