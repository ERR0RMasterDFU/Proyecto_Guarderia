package com.salesianostriana.dam.proyecto_guarderia.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.proyecto_guarderia.modelo.Profesor;

public interface ProfesorRepositorio extends JpaRepository<Profesor, Long>{

	/*@Query("select p from Profesor p where p.encargado LIKE 'siesta'")
	public List <Profesor> encuentraProfesores();*/
}
