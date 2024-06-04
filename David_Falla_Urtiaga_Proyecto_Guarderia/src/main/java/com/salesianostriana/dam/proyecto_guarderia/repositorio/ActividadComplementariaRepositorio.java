package com.salesianostriana.dam.proyecto_guarderia.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.salesianostriana.dam.proyecto_guarderia.modelo.ActividadComplementaria;
import com.salesianostriana.dam.proyecto_guarderia.modelo.Profesor;

public interface ActividadComplementariaRepositorio extends JpaRepository<ActividadComplementaria, Long> {

	// FILTRA PROFESORES POR ACTIVIDAD 
	@Query("""
			SELECT p
			FROM Profesor p
			WHERE encargado.id = :actividad
			""")
	List<Profesor> findProfesoresByActividad(@Param("actividad") long id);
		
		
	// CUENTA LOS PROFESORES QUE HAY EN UNA ACTIVIDAD
	@Query("""
			SELECT count(p)
			FROM Profesor p
			WHERE encargado.id = :actividad
			""")
	public int findNumProfesoresByActividad(@Param("actividad") long id);
}
