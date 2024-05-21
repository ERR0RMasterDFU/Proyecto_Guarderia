package com.salesianostriana.dam.proyecto_guarderia.servicio;

import com.salesianostriana.dam.proyecto_guarderia.modelo.ActividadComplementaria;
import com.salesianostriana.dam.proyecto_guarderia.repositorio.ActividadComplementariaRepositorio;
import com.salesianostriana.dam.proyecto_guarderia.repositorio.UsuarioRepositorio;
import com.salesianostriana.dam.proyecto_guarderia.servicio.base.ServicioBaseImpl;

public class ActividadComplementariaServicio extends ServicioBaseImpl<ActividadComplementaria, Long, ActividadComplementariaRepositorio> {

	public ActividadComplementariaServicio(UsuarioRepositorio repo) {
		super(repo);
		// TODO Auto-generated constructor stub
	}

}
