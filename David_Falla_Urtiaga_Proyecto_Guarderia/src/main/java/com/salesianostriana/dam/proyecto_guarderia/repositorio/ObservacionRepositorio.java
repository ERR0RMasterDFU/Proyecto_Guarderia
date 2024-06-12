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


	//public Page<Observacion> findAll(Pageable pageable);
	
	
	@Query("""
			SELECT a
			FROM Alumno a
			WHERE a.id = ?1
			""")
	public Alumno findAlumnoById(long id);
	
	
	
	// MUESTRA LAS OBSERVACIONES DE LOS USUARIOS 
	@Query("""
			SELECT o
			FROM Observacion o 
			WHERE o.alumno.progenitor = ?1
			""")
	public List<Observacion> findObservacionesByUsuario(Usuario usuario);
	
	
	
	
	// MOSTRAR ALUMNOS DE LA OBSERVACIÓN DE UN PROFESOR
	@Query("""
			SELECT o.alumno
			FROM Observacion o
			WHERE o.profesor.id = ?1
			""")
	public List<Alumno> findAlumnosByObservaciones(long id);
	
	
	
	// MOSTRAR ALUMNOS DE LA OBSERVACIÓN DE UN PROFESOR
	@Query("""
			SELECT o.profesor
			FROM Observacion o
			WHERE o.alumno.id = ?1
			""")
	public List<Profesor> findProfesoresByObservaciones(long id);
	
	
	
	@Query("""
			SELECT o
			FROM Observacion o 
			WHERE o.alumno.progenitor = ?1
			""")
	public Page<Observacion> observacionesDeUsuario(Usuario usuario, Pageable p);
	

}
