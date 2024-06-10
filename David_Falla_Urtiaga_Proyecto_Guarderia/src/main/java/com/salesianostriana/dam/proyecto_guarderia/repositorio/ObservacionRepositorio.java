package com.salesianostriana.dam.proyecto_guarderia.repositorio;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.proyecto_guarderia.modelo.Observacion;

public interface ObservacionRepositorio  extends JpaRepository<Observacion, Long>{


	//public Page<Observacion> findAll(Pageable pageable);

}
