package com.salesianostriana.dam.proyecto_guarderia.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.salesianostriana.dam.proyecto_guarderia.modelo.DatosAlumno;
import com.salesianostriana.dam.proyecto_guarderia.modelo.Usuario;

public interface DatosAlumnoRepositorio extends JpaRepository<DatosAlumno, Long> {

	
// PANTALLA DE DATOS DE ALUMNOS (USUARIO) -----------------------------------------------------------------------------------
	
	@Query("""
			SELECT da
			FROM DatosAlumno da 
			WHERE da.progenitor = ?1 AND da.matriculado = false
			""")
	public List<DatosAlumno> findDatosByUsuario(Usuario usuario);

// --------------------------------------------------------------------------------------------------------------------------
	
	
// PANTALLA DE DATOS DE ALUMNOS (ADMIN) -------------------------------------------------------------------------------------

	@Query("""
			SELECT da
			FROM DatosAlumno da 
			WHERE da.matriculado = false
			""")
	public List<DatosAlumno> findDatosSinMatricularByValidadosYMatriculados();

// --------------------------------------------------------------------------------------------------------------------------	

	
/* CONSULTA QUE RETORNA LOS DATOS QUE TIENEN EL MISMO ID QUE UN ALUMNO ------------------------------------------------------
	
	@Query("""
			SELECT da
			FROM DatosAlumno da
			WHERE da.id = ?1
			""")
	public DatosAlumno findDatosByIdAlumno(long id);
	
// --------------------------------------------------------------------------------------------------------------------------*/
	
	
// CONSULTA QUE RETORNA LOS DATOS POR ID ------------------------------------------------------------------------------------
	
	@Query("""
			SELECT da
			FROM DatosAlumno da
			WHERE da.id = ?1
			""")
	public DatosAlumno findDatosById(long id);
	
// --------------------------------------------------------------------------------------------------------------------------
	
}




