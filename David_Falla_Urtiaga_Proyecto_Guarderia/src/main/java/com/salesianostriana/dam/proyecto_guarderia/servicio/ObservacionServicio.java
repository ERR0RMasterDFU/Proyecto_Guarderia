package com.salesianostriana.dam.proyecto_guarderia.servicio;

import com.salesianostriana.dam.proyecto_guarderia.modelo.Observacion;
import com.salesianostriana.dam.proyecto_guarderia.repositorio.ObservacionRepositorio;
import com.salesianostriana.dam.proyecto_guarderia.repositorio.UsuarioRepositorio;
import com.salesianostriana.dam.proyecto_guarderia.servicio.base.ServicioBaseImpl;

public class ObservacionServicio extends ServicioBaseImpl<Observacion, Long, ObservacionRepositorio> {

	public ObservacionServicio(UsuarioRepositorio repo) {
		super(repo);
		// TODO Auto-generated constructor stub
	}

}
