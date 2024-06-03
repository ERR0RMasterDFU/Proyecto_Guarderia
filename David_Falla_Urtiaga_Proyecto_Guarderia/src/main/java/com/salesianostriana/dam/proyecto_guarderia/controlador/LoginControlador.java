package com.salesianostriana.dam.proyecto_guarderia.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginControlador {
	
// SALE DE LA CUENTA DE USUARIO / ADMIN Y REDIRIGE A LA PÁGINA DE INICIO DE SESIÓN ---------------------------------------------------------------------------------------------------
	
	@GetMapping("/login")
	public String mostrarPaginaLogin() {
		return "login";
	}
	
	@PostMapping("/logout")
	public String devolverPaginaLogin() {
		
		return "redirect:/login";
	}

}