package com.salesianostriana.dam.proyecto_guarderia.controlador;

import java.util.Optional;

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
		
		model.addAttribute("listaProfesores", servicio.findAll());
	
		return "admin/profesoresAdmin";
	}


	
// MUESTRA EL FORMULARIO PARA AÑADIR PROFESORES VACÍO ------------------------------------------
	
	@GetMapping("/nuevoProfesor")
	public String mostrarFormularioProfesor(Model model) {
		
		Profesor profesor = new Profesor();
		model.addAttribute("profesor", profesor);
		
		return "admin/agregarProfesoresAdmin";
	}	

	
	
// AÑADE EL NUEVO PROFESOR A LA BASE DE DATOS --------------------------------------------------
	
	@PostMapping("/nuevoProfesor/submit")
	public String registrarNuevoProfesor(@ModelAttribute("profesor") Profesor profesor) {
		
			servicio.save(profesor);		
			
		return "redirect:/admin/profesores";
	} 

	
	
// MUESTRA EL FORMULARIO PARA AÑADIR PROFESORES RELLENO ----------------------------------------

	@GetMapping("/editarProfesor/{id}")
	public String mostrarFormularioEdicion(@PathVariable("id") long idProfesor, Model model) {
		
		Optional <Profesor> profesorEditar = servicio.findById(idProfesor);
		
		if(profesorEditar!= null) {
			
			model.addAttribute("profesor", profesorEditar);
			return "admin/editarProfesoresAdmin";
			
		} else {
			
			return "redirect:/admin/profesores";
		}
	}
	
	
	
// GUARDA LOS NUEVOS CAMBIOS AL PROFESOR -------------------------------------------------------
	
	@PostMapping("/editarProfesor/submit")
	public String registrarProfesorEditado(@ModelAttribute("profesor") Profesor profesor) {
		
		servicio.save(profesor);
		
		return "redirect:/admin/profesores";
		
	}
	
	
	
// BORRA AL PROFESOR ELGIDO POR ID -------------------------------------------------------------

	@GetMapping("/borrarProfesor/{id}")
	public String borrarProfesor(@PathVariable("id") long idProfesor) {
		
		servicio.deleteById(idProfesor);
		
		return "redirect:/admin/profesores";
	}
	
	//----------------------------------------------------------------------------------------------
	
}
