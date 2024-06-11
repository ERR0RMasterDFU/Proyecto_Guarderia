package com.salesianostriana.dam.proyecto_guarderia.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.dam.proyecto_guarderia.modelo.Usuario;

@Controller
public class LoginControlador {
	
// SALE DE LA CUENTA DE USUARIO / ADMIN Y REDIRIGE A LA PÁGINA DE INICIO DE SESIÓN ---------------------------------------------------------------------------------------------------
	
	@GetMapping("/login")
	public String mostrarPaginaLogin(Usuario usuario) {
		
		if(usuario.isCredentialsNonExpired() == false) {
			return "redirect:/login?error=true";
		}else {
			return "login";
		}
	}	

	
	@PostMapping("/logout")
	public String devolverPaginaLogin() {
		
		return "redirect:/login";
	}

}