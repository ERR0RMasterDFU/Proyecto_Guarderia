package com.salesianostriana.dam.proyecto_guarderia.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.salesianostriana.dam.proyecto_guarderia.servicio.CursoServicio;

@Controller
public class CursoControlador {

	@Autowired
	private CursoServicio servicio;
	
	
	//MOSTRAR LA LISTA DE ALUMNOS DEL USUARIO -----------------------------------------------------------------------------
	
	@GetMapping("/admin/cursos")
	public String mostrarCursos(Model model) {
			
		model.addAttribute("listaCursos", servicio.findAll());
		
		return "admin/cursosAdmin";
	}
		
}
