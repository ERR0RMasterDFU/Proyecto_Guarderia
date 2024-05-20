package com.salesianostriana.dam.proyecto_guarderia.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LogoutControlador {
	
// SALE DE LA CUENTA DE USUARIO / ADMIN Y REDIRIGE A LA PÁGINA DE INICIO DE SESIÓN ---------------------------------------------------------------------------------------------------
	
	@PostMapping("/logout")
	public String mostrarPaginaLogin() {
		
		return "redirect:/login";
	}

}