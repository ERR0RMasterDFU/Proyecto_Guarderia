package com.salesianostriana.dam.proyecto_guarderia.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.salesianostriana.dam.proyecto_guarderia.modelo.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long>{

	Optional<Usuario> findFirstByUsername(String username);
	
	// CUENTA LOS USUARIOS QUE HAY EN UN CURSO
	/*@Query("""
			SELECT count(a)
			FROM Alumnos a
			WHERE progenitor.id = :progenitor
			""")
	public int findNumAlumnosByUsuario(@Param("progenitor") long id);*/
}

