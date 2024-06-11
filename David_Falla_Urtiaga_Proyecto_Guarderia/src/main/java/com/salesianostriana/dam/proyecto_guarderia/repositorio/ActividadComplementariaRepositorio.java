package com.salesianostriana.dam.proyecto_guarderia.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.salesianostriana.dam.proyecto_guarderia.modelo.ActividadComplementaria;
import com.salesianostriana.dam.proyecto_guarderia.modelo.Alumno;
import com.salesianostriana.dam.proyecto_guarderia.modelo.Profesor;

public interface ActividadComplementariaRepositorio extends JpaRepository<ActividadComplementaria, Long> {

	// FILTRA PROFESORES POR ACTIVIDAD 
	@Query("""
			SELECT p
			FROM Profesor p
			WHERE encargado.id = :actividad
			""")
	List<Profesor> findProfesoresByActividad(@Param("actividad") long id);
	
	
	// FILTRA ALUMNOS POR ACTIVIDAD 
	@Query("""
			SELECT a
			FROM Alumno a JOIN a.horario h
			WHERE h.id = :actividad
			""")
	List<Alumno> findAlumnosByActividad(@Param("actividad") long id);
		
	//SELECT * FROM Alumno a JOIN Horario h ON (a.id = h.alumno_id)  WHERE h.actividad_id = 1
	
		
	// CUENTA LOS PROFESORES QUE HAY EN UNA ACTIVIDAD
	@Query("""
			SELECT count(p)
			FROM Profesor p
			WHERE encargado.id = :actividad
			""")
	public int findNumProfesoresByActividad(@Param("actividad") long id);
	
	
	
	// CUENTA LOS ALUMNOS QUE HAY EN UNA ACTIVIDAD
		@Query("""
				SELECT count(a)
				FROM Alumno a JOIN a.horario h
				WHERE h.id = :actividad
				""")
		public int findNumAlumnosByActividad(@Param("actividad") long id);
	
}
