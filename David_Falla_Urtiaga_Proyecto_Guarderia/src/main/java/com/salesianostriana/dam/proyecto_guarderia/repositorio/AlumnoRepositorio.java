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

	
// PANTALLA DE ALUMNOS (USUARIO) ---------------------------------------------------------------------------------------------

	@Query("""
			SELECT a
			FROM Alumno a
			WHERE a.datos.progenitor = ?1
			ORDER BY a.curso.id asc 
			""")
	public List<Alumno> findAlumnoByUsuario(Usuario usuario);
	
// ---------------------------------------------------------------------------------------------------------------------------
	
	
// BOTÓN OBSERVACIONES (ALUMNO) ----------------------------------------------------------------------------------------------
	
	@Query("""
			SELECT o
			FROM Observacion o
			WHERE o.alumno.id = ?1
			""")
	public List<Observacion> findObservacionesByAlumno(long id);
	
// ---------------------------------------------------------------------------------------------------------------------------
	
	
// BOTÓN TUTOR LEGAL (ALUMNO) ------------------------------------------------------------------------------------------------
	
	@Query("""
			SELECT a.datos.progenitor
			FROM Alumno a
			WHERE a.id = ?1
			""")
	public Usuario findUsuarioByAlumnoId(long id);
	
// ---------------------------------------------------------------------------------------------------------------------------
		
	
// BOTÓN HORARIO (ALUMNO) ----------------------------------------------------------------------------------------------------
	
	@Query("""
			SELECT a.horario
			FROM Alumno a 
			WHERE a.id = ?1
			""")
	public List<ActividadComplementaria> findHorarioByAlumnoId(long id);
	
// ---------------------------------------------------------------------------------------------------------------------------

}
