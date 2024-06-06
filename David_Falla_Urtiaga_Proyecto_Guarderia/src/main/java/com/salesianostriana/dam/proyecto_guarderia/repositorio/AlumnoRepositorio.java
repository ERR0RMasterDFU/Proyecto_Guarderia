package com.salesianostriana.dam.proyecto_guarderia.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.salesianostriana.dam.proyecto_guarderia.modelo.Alumno;
import com.salesianostriana.dam.proyecto_guarderia.modelo.Usuario;

public interface AlumnoRepositorio extends JpaRepository<Alumno, Long>{

	
	// FILTRA ALUMNOS POR USUARIO 
	@Query("""
			SELECT a
			FROM Alumno a
			WHERE a.progenitor = :progenitor
			""")
	public List<Alumno> findAlumnoByUsuario(@Param("progenitor") Usuario usuario);
	
}
