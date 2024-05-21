package com.salesianostriana.dam.proyecto_guarderia.servicio;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.proyecto_guarderia.modelo.Observacion;
import com.salesianostriana.dam.proyecto_guarderia.modelo.ObservacionPK;
import com.salesianostriana.dam.proyecto_guarderia.repositorio.ObservacionRepositorio;
import com.salesianostriana.dam.proyecto_guarderia.repositorio.UsuarioRepositorio;
import com.salesianostriana.dam.proyecto_guarderia.servicio.base.ServicioBaseImpl;

@Service
public class ObservacionServicio extends ServicioBaseImpl<Observacion, ObservacionPK, ObservacionRepositorio>{

	public ObservacionServicio(UsuarioRepositorio repo) {
		super(repo);
		// TODO Auto-generated constructor stub
	}

}
