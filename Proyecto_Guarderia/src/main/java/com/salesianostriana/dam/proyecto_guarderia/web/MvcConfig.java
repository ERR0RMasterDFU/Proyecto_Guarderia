package com.salesianostriana.dam.proyecto_guarderia.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

	
	//CAMBIAR SI HAY FALLO ----------------------------------------------------------------------------------------------------
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/login").setViewName("login");
		registry.addViewController("/usuario/bienvenida");
		registry.addViewController("/admin/bienvenidaAdmin");
		registry.addViewController("/logout");
		
	}
	
	//------------------------------------------------------------------------------------------------------------------------
	
	
	//PARA GUARDAR USUARIO EN EL PERFIL ------------------------------------------------------------------------
	
	/*@GetMapping("/me")
	publlic String perfil(Model model, @AuthenticationPrincipal Usuario, usuario) {
		model.addAtribute(método que trae usuario)
		
		return "profile";
	}*/
	
}