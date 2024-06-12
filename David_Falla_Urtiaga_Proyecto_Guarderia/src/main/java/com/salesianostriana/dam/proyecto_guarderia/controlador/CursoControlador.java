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
import com.salesianostriana.dam.proyecto_guarderia.servicio.ObservacionServicio;

@Controller
@RequestMapping("/admin/cursos")
public class CursoControlador {

	@Autowired
	private CursoServicio servicio;
	
	@Autowired
	private ObservacionServicio obServicio;
	
	
// PANTALLA CON LOS CURSOS ---------------------------------------------------------------------------------------------------
	
	@GetMapping("/")
	public String mostrarCursos(Model model) {
			
		model.addAttribute("listaCursos", servicio.findAll());
		model.addAttribute("listaAsideAdmin", obServicio.tresObservacionesMasRecientes());
		
		return "admin/cursosAdmin";
	}

// ---------------------------------------------------------------------------------------------------------------------------
	
	
// FORMULARIO PARA AÑADIR CURSOS ---------------------------------------------------------------------------------------------
	
	@GetMapping("/nuevoCurso")
	public String mostrarFormulariCursosAgregar(Model model) {
			
		Curso curso = new Curso();
		model.addAttribute("curso", curso);
		model.addAttribute("listaAsideAdmin", obServicio.tresObservacionesMasRecientes());
			
		return "admin/agregarEditarCursosAdmin";
	}	
	
// ---------------------------------------------------------------------------------------------------------------------------
		
		
// GUARDA EL CURSO EN LA BASE DE DATOS ---------------------------------------------------------------------------------------
		
	@PostMapping("/nuevoCurso/submit")
	public String registrarNuevoCurso(@ModelAttribute("curso") Curso curso) {
			
		servicio.save(curso);		
			
		return "redirect:/admin/cursos/";
	} 

// ---------------------------------------------------------------------------------------------------------------------------
	
	
// FORMULARIO PARA EDITAR CURSOS ---------------------------------------------------------------------------------------------

	@GetMapping("/editarCurso/{id}")
	public String mostrarFormularioCursosEditar(@PathVariable("id") long id, Model model) {
			
		Optional<Curso> cursoAEditar = servicio.findById(id);
		model.addAttribute("listaAsideAdmin", obServicio.tresObservacionesMasRecientes());
			
		if(cursoAEditar.isPresent()) {
				
			model.addAttribute("curso", cursoAEditar.get());
			return "admin/agregarEditarCursosAdmin";
				
		} else {
				
			return "redirect:/admin/cursos/";
		}
	}

// ---------------------------------------------------------------------------------------------------------------------------
		
		
// GUARDA LOS NUEVOS CAMBIOS SOBRE LOS CURSOS EN LA BASE DE DATOS ------------------------------------------------------------
		
	@PostMapping("/editarCurso/submit")
	public String registrarCursoEditado(@ModelAttribute("curso") Curso curso) {
			
		servicio.save(curso);
			
		return "redirect:/admin/cursos/";	
	}
	
// ---------------------------------------------------------------------------------------------------------------------------
		
		
		
// BORRA EL CURSO POR ID -----------------------------------------------------------------------------------------------------

	@GetMapping("/borrarCurso/{id}")
	public String borrarCurso(@PathVariable("id") long id, Model model) {

		Optional<Curso> cursoABorrar = servicio.findById(id);
		model.addAttribute("listaAsideAdmin", obServicio.tresObservacionesMasRecientes());
		
		if(cursoABorrar.isPresent()) {
		
			if(servicio.contarProfesoresDeUnCurso(id) == 0 && servicio.contarAlumnosDeUnCurso(id) == 0) {
				servicio.deleteById(id);
			}else {
				return "redirect:/admin/cursos/?error=true";
			}
		}
			
		return "redirect:/admin/cursos/";
	}

// ---------------------------------------------------------------------------------------------------------------------------
		
	
// BOTÓN PROFESORES (CURSO) --------------------------------------------------------------------------------------------------

	@GetMapping("/profesores/{id}")
	public String mostrarProfesoresFiltradosPorCursos(@PathVariable("id") long id, Model model) {
			
		model.addAttribute("listaProfesores", servicio.filtrarProfesoresPorCurso(id));
		model.addAttribute("listaAsideAdmin", obServicio.tresObservacionesMasRecientes());
		
		return "admin/profesoresAdmin";
	}
	
// ---------------------------------------------------------------------------------------------------------------------------
	
	
// BOTÓN ALUMNOS (CURSO) -----------------------------------------------------------------------------------------------------
	
	@GetMapping("/alumnos/{id}")
	public String mostrarAlumnosFiltradosPorCursos(@PathVariable("id") long id, Model model) {
			
		model.addAttribute("listaAlumnos", servicio.filtrarAlumnosPorCurso(id));
		model.addAttribute("listaAsideAdmin", obServicio.tresObservacionesMasRecientes());
		
		return "admin/alumnosAdmin";
	}
	
// ---------------------------------------------------------------------------------------------------------------------------
	
}
