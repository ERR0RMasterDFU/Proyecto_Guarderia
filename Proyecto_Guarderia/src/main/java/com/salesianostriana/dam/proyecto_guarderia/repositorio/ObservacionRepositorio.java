package com.salesianostriana.dam.proyecto_guarderia.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.proyecto_guarderia.modelo.Observacion;
import com.salesianostriana.dam.proyecto_guarderia.modelo.ObservacionPK;

public interface ObservacionRepositorio extends JpaRepository<Observacion, ObservacionPK>{

}
