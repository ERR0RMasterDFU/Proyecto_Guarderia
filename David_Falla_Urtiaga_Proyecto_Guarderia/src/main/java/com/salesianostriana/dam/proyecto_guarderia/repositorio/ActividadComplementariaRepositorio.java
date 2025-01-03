package com.salesianostriana.dam.proyecto_guarderia.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.salesianostriana.dam.proyecto_guarderia.modelo.ActividadComplementaria;
import com.salesianostriana.dam.proyecto_guarderia.modelo.Alumno;
import com.salesianostriana.dam.proyecto_guarderia.modelo.Profesor;

public interface ActividadComplementariaRepositorio extends JpaRepository<ActividadComplementaria, Long> {

	
// BOTÓN PROFESORES (ACTIVIDAD COMPLEMENTARIA) -------------------------------------------------------------------------------
	
	@Query("""
			SELECT p
			FROM Profesor p
			WHERE encargado.id = :actividad
			""")
	List<Profesor> findProfesoresByActividad(@Param("actividad") long id);
	
// ---------------------------------------------------------------------------------------------------------------------------
	
	
// BOTÓN PROFESORES (ACTIVIDAD COMPLEMENTARIA) -------------------------------------------------------------------------------
	
	@Query("""
			SELECT p
			FROM Profesor p
			WHERE encargado.id = :actividad
			ORDER BY curso.id asc
			""")
	List<Profesor> findProfesoresByActividadUsuario(@Param("actividad") long id);
		
// ---------------------------------------------------------------------------------------------------------------------------
	

// BOTÓN ALUMNOS (ACTIVIDAD COMPLEMENTARIA) ----------------------------------------------------------------------------------
	
	@Query("""
			SELECT a
			FROM Alumno a JOIN a.horario h
			WHERE h.id = :actividad
			""")
	List<Alumno> findAlumnosByActividad(@Param("actividad") long id);

// ---------------------------------------------------------------------------------------------------------------------------
		
		
// CUENTA LOS PROFESORES QUE HAY EN UNA ACTIVIDAD ----------------------------------------------------------------------------
	
	@Query("""
			SELECT count(p)
			FROM Profesor p
			WHERE encargado.id = :actividad
			""")
	public int findNumProfesoresByActividad(@Param("actividad") long id);
	
// ---------------------------------------------------------------------------------------------------------------------------

	
// CUENTA LOS ALUMNOS QUE HAY EN UNA ACTIVIDAD -------------------------------------------------------------------------------
	
		@Query("""
				SELECT count(a)
				FROM Alumno a JOIN a.horario h
				WHERE h.id = :actividad
				""")
		public int findNumAlumnosByActividad(@Param("actividad") long id);
	
// ---------------------------------------------------------------------------------------------------------------------------
		
}
