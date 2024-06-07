package com.salesianostriana.dam.proyecto_guarderia.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.salesianostriana.dam.proyecto_guarderia.modelo.ActividadComplementaria;
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
	
	
	
	
	/*@Query("""
			SELECT a
			FROM ActividadComplementaria a JOIN a.horario h
			WHERE h.id = ?1
			""")
	public List<ActividadComplementaria> findHorarioByAlumnoId(long id);*/

	
	//MOSTRAR ACTIVIDADES COMPLEMENTARIAS DEL NIÑO
	//SELECT * FROM ACTIVIDAD_COMPLEMENTARIA  ac JOIN HORARIO h ON (ac.id=h.actividad_id) JOIN Alumno a ON (h.alumno_id=a.id) WHERE h.actividad_id IN (2, 4) AND h.alumno_id = 1



	//MOSTRAR LOS PROFESORES DEL ALUMNO

	//SELECT * FROM Profesor p WHERE p.curso_ID = 1 AND p.encargado_ID IN (2, 4)










}
