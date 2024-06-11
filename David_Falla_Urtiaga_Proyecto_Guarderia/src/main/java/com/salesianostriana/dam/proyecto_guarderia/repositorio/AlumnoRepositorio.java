package com.salesianostriana.dam.proyecto_guarderia.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.salesianostriana.dam.proyecto_guarderia.modelo.ActividadComplementaria;
import com.salesianostriana.dam.proyecto_guarderia.modelo.Alumno;
import com.salesianostriana.dam.proyecto_guarderia.modelo.Observacion;
import com.salesianostriana.dam.proyecto_guarderia.modelo.Profesor;
import com.salesianostriana.dam.proyecto_guarderia.modelo.Usuario;

public interface AlumnoRepositorio extends JpaRepository<Alumno, Long>{

	
	// FILTRA ALUMNOS POR USUARIO 
	@Query("""
			SELECT a
			FROM Alumno a
			WHERE a.progenitor = :progenitor
			""")
	public List<Alumno> findAlumnoByUsuario(@Param("progenitor") Usuario usuario);
	
	
	//FILTRA LAS OBSERVACIONES DEL ALUMNO
	@Query("""
			SELECT o
			FROM Observacion o
			WHERE o.alumno.id = ?1
			""")
	public List<Observacion> findObservacionesByAlumno(long idAlumno);
	
	
	//FILTRA EL TUTOR LEGAL DEL ALUMNO
	@Query("""
			SELECT a.progenitor
			FROM Alumno a
			WHERE a.id = ?1
			""")
	public Usuario findUsuarioByAlumnoId(long idAlumno);
		
	
	//MUESTRA EL HORARIO DEL ALUMNO
	@Query("""
			SELECT a.horario
			FROM Alumno a 
			WHERE a.id = ?1
			""")
	public List<ActividadComplementaria> findHorarioByAlumnoId(long id);
	
	
	
	
//SELECT PROFESOR.* 
//FROM ALUMNO JOIN HORARIO ON (ALUMNO.ID = ALUMNO_ID) JOIN ACTIVIDAD_COMPLEMENTARIA ON (ACTIVIDAD_COMPLEMENTARIA.ID = ACTIVIDAD_ID) JOIN PROFESOR ON (ACTIVIDAD_ID=ENCARGADO_ID) 
//WHERE ALUMNO.ID = 1 AND ALUMNO.CURSO_ID = PROFESOR.CURSO_ID











}
