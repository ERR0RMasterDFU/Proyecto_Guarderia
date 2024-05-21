package com.salesianostriana.dam.proyecto_guarderia.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminControlador {

	
	// MUESTRA LA PÁGINA DE BIENVENIDA (ADMIN) -------------------------------------------------------------------------------------------------------------------------------

	@GetMapping("/")
	public String muestraBienvenidaAdmin() {
		
		return "admin/bienvenidaAdmin";
	}
}


	
	

