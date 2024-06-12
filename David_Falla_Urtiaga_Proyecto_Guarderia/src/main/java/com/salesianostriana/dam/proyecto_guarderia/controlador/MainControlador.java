package com.salesianostriana.dam.proyecto_guarderia.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainControlador {

// MUESTRA LA PÁGINA DE HISTORIA ---------------------------------------------------------------------------------------------
	
	@GetMapping("/")
	public String mostrarPaginaHistroria() {
		return "paginaPrincipalHistoria";
	}
	
// ---------------------------------------------------------------------------------------------------------------------------
		
		
// MUESTRA LA PÁGINA DE EMPLAZAMIENTO ----------------------------------------------------------------------------------------
		
	@GetMapping("/emplazamiento")
	public String mostrarPaginaEmplazamiento() {
		return "paginaPrincipalEmplazamiento";
	}
	
// ---------------------------------------------------------------------------------------------------------------------------
		
	
// MUESTRA LA PÁGINA DE NORMAS Y SEGURIDAD -----------------------------------------------------------------------------------
		
	@GetMapping("/normas")
	public String mostrarPaginaNormasYSeguridad() {
		return "paginaPrincipalNormasYSeguridad";
	}
	
// ---------------------------------------------------------------------------------------------------------------------------
	
}
