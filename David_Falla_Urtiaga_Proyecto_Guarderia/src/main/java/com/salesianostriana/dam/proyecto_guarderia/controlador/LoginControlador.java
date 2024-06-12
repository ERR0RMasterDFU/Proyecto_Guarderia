package com.salesianostriana.dam.proyecto_guarderia.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.dam.proyecto_guarderia.modelo.Usuario;

@Controller
public class LoginControlador {
	
// PANTALLA DE INICIO DE SESIÓN ----------------------------------------------------------------------------------------------
	
	@GetMapping("/login")
	public String mostrarPaginaLogin(Usuario usuario) {
		
		if(usuario.isCredentialsNonExpired() == false) {
			return "redirect:/login?error=true";
		}else {
			return "login";
		}
	}
	
// ---------------------------------------------------------------------------------------------------------------------------

	
// BOTÓN DE CERRAR SESIÓN ----------------------------------------------------------------------------------------------------
	
	@PostMapping("/logout")
	public String devolverPaginaLogin() {
		
		return "redirect:/login";
	}
	
// ---------------------------------------------------------------------------------------------------------------------------

}
