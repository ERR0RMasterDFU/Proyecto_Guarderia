package com.salesianostriana.dam.proyecto_guarderia.servicio;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.proyecto_guarderia.modelo.Observacion;
import com.salesianostriana.dam.proyecto_guarderia.repositorio.ObservacionRepositorio;
import com.salesianostriana.dam.proyecto_guarderia.repositorio.UsuarioRepositorio;
import com.salesianostriana.dam.proyecto_guarderia.servicio.base.ServicioBaseImpl;

@Service
public class ObservacionServicio extends ServicioBaseImpl<Observacion, Long, ObservacionRepositorio> {

	@Autowired
	private ObservacionRepositorio repositorio;
	
	public ObservacionServicio(UsuarioRepositorio repo) {
		super(repo);
		// TODO Auto-generated constructor stub
	}
	
	
	public LocalDateTime introducirFechaInstante (Observacion observacion) {
		LocalDateTime fechaObservacion = LocalDateTime.now();
		observacion.setFechaObservacion(fechaObservacion);
		return fechaObservacion;
	}
	
	
	public List<Observacion> cuatroObservacionesMasRecientes () {
		//return repositorio.findTop7OrderByFechaObservacionDesc();
		//return repositorio.findFirst7AndSort(Sort.by(Direction.DESC, "fechaObservacion"));
		Page<Observacion> page = repositorio.findAll(PageRequest.of(0, 4,Sort.by("fechaObservacion").descending()));
		return page.toList();
	}

}
