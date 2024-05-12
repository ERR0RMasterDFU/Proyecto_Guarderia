package com.salesianostriana.dam.proyecto_guarderia.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.dam.proyecto_guarderia.modelo.TutorLegal;
import com.salesianostriana.dam.proyecto_guarderia.modelo.Usuario;
import com.salesianostriana.dam.proyecto_guarderia.servicio.ProfesorServicio;

@Controller
//@RequestMapping("/admin")
public class InicioDeSesionControlador {

	
	// MUESTRA LA PÁGINA DE INICIO DE SESIÓN -------------------------------------------------------------------------------------
	
	@GetMapping("/inicioDeSesion")
	public String mostrarProfesores() {
		
		return "inicioDeSesion";
	}
	
}

