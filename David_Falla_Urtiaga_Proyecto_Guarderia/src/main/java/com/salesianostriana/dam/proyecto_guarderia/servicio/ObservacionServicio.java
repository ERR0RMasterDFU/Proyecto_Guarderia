package com.salesianostriana.dam.proyecto_guarderia.servicio;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.proyecto_guarderia.modelo.Observacion;
import com.salesianostriana.dam.proyecto_guarderia.repositorio.ObservacionRepositorio;
import com.salesianostriana.dam.proyecto_guarderia.repositorio.UsuarioRepositorio;
import com.salesianostriana.dam.proyecto_guarderia.servicio.base.ServicioBaseImpl;

@Service
public class ObservacionServicio extends ServicioBaseImpl<Observacion, Long, ObservacionRepositorio> {

	public ObservacionServicio(UsuarioRepositorio repo) {
		super(repo);
		// TODO Auto-generated constructor stub
	}
	
	
	public LocalDateTime introducirFechaInstante (Observacion observacion) {
		LocalDateTime fechaObservacion = LocalDateTime.now();
		observacion.setFechaObservacion(fechaObservacion);
		return fechaObservacion;
	}
	
	public LocalDateTime editarFechaInstante (Observacion observacion) {
		LocalDateTime fechaObservacion = observacion.getFechaObservacion();
		return fechaObservacion;
	}

}
