package com.salesianostriana.dam.proyecto_guarderia.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.salesianostriana.dam.proyecto_guarderia.modelo.Profesor;

public interface ProfesorRepositorio extends JpaRepository<Profesor, Long>{

}
