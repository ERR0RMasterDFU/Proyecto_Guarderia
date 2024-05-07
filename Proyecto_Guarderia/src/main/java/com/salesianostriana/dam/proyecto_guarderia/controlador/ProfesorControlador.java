package com.salesianostriana.dam.proyecto_guarderia.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.dam.proyecto_guarderia.modelo.Profesor;
import com.salesianostriana.dam.proyecto_guarderia.servicio.ProfesorServicio;


@Controller
@RequestMapping("/admin")
public class ProfesorControlador {

	@Autowired
	private ProfesorServicio servicio;
	

	
// MUESTRA LA PÁGINA DE PROFESORES -------------------------------------------------------------
	
	@GetMapping("/profesores")
	public String mostrarProfesores(Model model) {
		
		model.addAttribute("profesor", servicio.findAll());
	
		return "profesoresAdmin";
	}


	
// MUESTRA EL FORMULARIO PARA AÑADIR PROFESORES VACÍO ------------------------------------------
	
	@GetMapping("/nuevoProfesor")
	public String mostrarFormularioProfesor(Model model) {
		
		Profesor profesor = new Profesor();
		model.addAttribute("agregarProfesoresAdmin", profesor );
		
		return "agregarProfesoresAdmin";
	}	

	
	
// AÑADE EL NUEVO PROFESOR A LA BASE DE DATOS --------------------------------------------------
	
	@PostMapping("/nuevoProfesor/submit")
	public String registrarNuevoProfesor(@ModelAttribute("agregarProfesoresAdmin") Profesor profesor) {
		
			servicio.save(profesor);		
			
		return "redirect:/profesores";
	} 

	
	
// MUESTRA EL FORMULARIO PARA AÑADIR PROFESORES RELLENO ----------------------------------------

	@GetMapping("/editarProfesor/{id}")
	public String mostrarFormularioEdicion(@PathVariable("id") long id, Model model) {
		
		if(servicio.findById(id)!= null) {
			
			model.addAttribute("profesor");
			return "agregarProfesoresAdmin";
		} else {
			
			return "redirect:/Profesores";
		}
	}
	

		
// GUARDA LOS NUEVOS CAMBIOS AL PROFESOR -------------------------------------------------------
	
	@PostMapping("/editarProfesor/submit")
	public String registrarProfesorEditado(@ModelAttribute("agregarProfesoresAdmin") Profesor profesor) {
			
		servicio.edit(profesor);		
				
		return "redirect:/profesores";
	} 
	
	
	
// BORRA AL PROFESOR ELGIDO POR ID -------------------------------------------------------------

	@GetMapping("/borrarProfesor/{id}")
	public String borrarProfesor(@PathVariable("id") long id) {
		
		servicio.deleteById(id);
		
		return "redirect:/profesores";
	}
	
	//----------------------------------------------------------------------------------------------
	
}
