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
			WHERE da.progenitor = ?1
			""")
	public List<DatosAlumno> findDatosByUsuario(Usuario usuario);

//---------------------------------------------------------------------------------------------------------------------------
	
	

}




