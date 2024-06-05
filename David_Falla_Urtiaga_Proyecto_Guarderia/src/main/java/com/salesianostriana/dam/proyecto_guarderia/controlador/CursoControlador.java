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

import com.salesianostriana.dam.proyecto_guarderia.modelo.Curso;
import com.salesianostriana.dam.proyecto_guarderia.servicio.CursoServicio;

@Controller
@RequestMapping("/admin/cursos")
public class CursoControlador {

	@Autowired
	private CursoServicio servicio;
	
	
	//MOSTRAR LA LISTA DE CURSOS -----------------------------------------------------------------------------
	
	@GetMapping("/")
	public String mostrarCursos(Model model) {
			
		model.addAttribute("listaCursos", servicio.findAll());
		
		return "admin/cursosAdmin";
	}
	
	
	// MUESTRA EL FORMULARIO PARA AÑADIR CURSOS VACÍO -------------------------------------------------------
	
	@GetMapping("/nuevoCurso")
	public String mostrarFormulariCursosAgregar(Model model) {
			
		Curso curso = new Curso();
		model.addAttribute("curso", curso);
			
		return "admin/agregarEditarCursosAdmin";
	}	

		
		
	// AÑADE EL NUEVO CURSO A LA BASE DE DATOS ---------------------------------------------------------------
		
	@PostMapping("/nuevoCurso/submit")
	public String registrarNuevoCurso(@ModelAttribute("curso") Curso curso) {
			
			servicio.save(curso);		
			
		return "redirect:/admin/cursos/";
	} 

	
	// MUESTRA EL FORMULARIO PARA AÑADIR CURSOS RELLENO ---------------------------------------------------

	@GetMapping("/editarCurso/{id}")
	public String mostrarFormularioCursosEditar(@PathVariable("id") long id, Model model) {
			
		Optional<Curso> cursoAEditar = servicio.findById(id);
			
		if(cursoAEditar.isPresent()) {
				
			model.addAttribute("curso", cursoAEditar.get());
			return "admin/agregarEditarCursosAdmin";
				
		} else {
				
			return "redirect:/admin/cursos/";
		}
			
	}
		
		
		
	// GUARDA LOS NUEVOS CAMBIOS A LOS CURSOS ----------------------------------------------------------------
		
	@PostMapping("/editarCurso/submit")
	public String registrarCursoEditado(@ModelAttribute("curso") Curso curso) {
			
		servicio.save(curso);
			
		return "redirect:/admin/cursos/";	
	}
		
		
		
	//BORRA EL CURSO ELEGIDO POR ID ----------------------------------------------------------------------

	@GetMapping("/borrarCurso/{id}")
	public String borrarCurso(@PathVariable("id") long id) {

		Optional<Curso> cursoABorrar = servicio.findById(id);
		
		if(cursoABorrar.isPresent()) {
		
			if(servicio.contarProfesoresDeUnCurso(id) == 0) {
				servicio.deleteById(id);
			}else {
				return "redirect:/admin/cursos/?error=true";
			}
		}
			
		return "redirect:/admin/cursos/";
	}
	
		
	
	// FILTRA A LOS PROFESORES POR CURSO -----------------------------------------------------------------
	
	@GetMapping("/profesores/{id}")
	public String mostrarProfesoresFiltradosPorCursos(@PathVariable("id") long id, Model model) {
			
		model.addAttribute("listaProfesores", servicio.findProfesoresByCurso(id));
		
		return "admin/profesoresAdmin";
	}
	
	
	
}
