package com.salesianostriana.dam.proyecto_guarderia.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.dam.proyecto_guarderia.modelo.Alumno;
import com.salesianostriana.dam.proyecto_guarderia.servicio.AlumnoServicio;



@Controller
public class AlumnoControlador {

	@Autowired
	private AlumnoServicio servicio;
	
	@GetMapping("/alumno")
	public String showMatricula(Model model) {
		
		Alumno alumno = new Alumno();
		model.addAttribute("formularioEnvioDeDatos", alumno);
		
		return "formularioEnvioDeDatos";
	}
	
	
	/*@PostMapping("/addAlumno")
	public String submit showMatricula(Model model) {
		
		Alumno alumno = new Alumno();
		model.addAttribute("formularioEnvioDeDatos", alumno);
		
		return "formularioEnvioDeDatos";
	}*/
	
	
	
	
	
}
