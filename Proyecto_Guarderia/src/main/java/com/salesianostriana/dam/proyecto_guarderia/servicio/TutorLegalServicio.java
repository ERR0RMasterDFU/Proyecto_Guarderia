package com.salesianostriana.dam.proyecto_guarderia.servicio;

import java.util.List;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.proyecto_guarderia.modelo.Progenitor;
import com.salesianostriana.dam.proyecto_guarderia.modelo.TutorLegal;
import com.salesianostriana.dam.proyecto_guarderia.repositorio.TutorLegalRepositorio;
import com.salesianostriana.dam.proyecto_guarderia.servicio.base.ServicioBaseImpl;

@Service
public class TutorLegalServicio extends ServicioBaseImpl<TutorLegal, Long, TutorLegalRepositorio>{

	List <Progenitor> lista;
}