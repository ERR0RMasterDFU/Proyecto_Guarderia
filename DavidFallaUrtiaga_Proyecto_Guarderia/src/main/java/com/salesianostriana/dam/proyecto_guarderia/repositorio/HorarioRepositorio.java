package com.salesianostriana.dam.proyecto_guarderia.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.proyecto_guarderia.modelo.Periodo;

public interface HorarioRepositorio extends JpaRepository<Periodo, Long> {

}