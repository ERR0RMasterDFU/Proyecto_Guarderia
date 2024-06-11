package com.salesianostriana.dam.proyecto_guarderia.repositorio;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.salesianostriana.dam.proyecto_guarderia.modelo.Alumno;
import com.salesianostriana.dam.proyecto_guarderia.modelo.Observacion;

public interface ObservacionRepositorio extends JpaRepository<Observacion, Long>{


	//public Page<Observacion> findAll(Pageable pageable);
	
	
	@Query("""
			SELECT a
			FROM Alumno a
			WHERE a.id = ?1
			""")
	public Alumno findAlumnoById(long id);

}
