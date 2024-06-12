package com.salesianostriana.dam.proyecto_guarderia.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.salesianostriana.dam.proyecto_guarderia.modelo.Alumno;
import com.salesianostriana.dam.proyecto_guarderia.modelo.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long>{

	Optional<Usuario> findFirstByUsername(String username);
	
	
// CUENTA LOS ALUMNOS QUE TIENE UN USUARIO -----------------------------------------------------------------------------------
	
	@Query("""
			SELECT count(a)
			FROM Alumno a
			WHERE a.progenitor.id = :progenitor
			""")
	public int findNumAlumnosByUsuario(@Param("progenitor") long id);
	
// ---------------------------------------------------------------------------------------------------------------------------
	
	
// BOTÓN ALUMNOS (TABLA DE USUARIOS) -----------------------------------------------------------------------------------------
	
	@Query("""
			SELECT a
			FROM Alumno a
			WHERE a.progenitor.id = ?1
			""")
	public List<Alumno> findAlumnosbyUsuario(long id);
	
// ---------------------------------------------------------------------------------------------------------------------------
	
}