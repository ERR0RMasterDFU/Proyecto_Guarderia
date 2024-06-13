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
import com.salesianostriana.dam.proyecto_guarderia.servicio.ActividadComplementariaServicio;
import com.salesianostriana.dam.proyecto_guarderia.servicio.CursoServicio;
import com.salesianostriana.dam.proyecto_guarderia.servicio.ObservacionServicio;
import com.salesianostriana.dam.proyecto_guarderia.servicio.ProfesorServicio;

@Controller
@RequestMapping("/admin/profesores")
public class ProfesorControlador {

	@Autowired
	private ProfesorServicio servicio;
	
	@Autowired
	private CursoServicio CursoServicio;
	
	@Autowired
	private ActividadComplementariaServicio ActServicio;
	
	@Autowired
	private ObservacionServicio obServicio;

	
// PANTALLA DE PROFESORES ----------------------------------------------------------------------------------------------------
	
	@GetMapping("/")
	public String mostrarProfesores(Model model) {
		
		model.addAttribute("listaProfesores", servicio.findAll());
		model.addAttribute("listaAsideAdmin", obServicio.tresObservacionesMasRecientes());
	
		return "admin/profesoresAdmin";
	}

// ---------------------------------------------------------------------------------------------------------------------------

	
// FORMULARIO PARA AÑADIR PROFESORES -----------------------------------------------------------------------------------------
	
	@GetMapping("/nuevoProfesor")
	public String mostrarFormularioProfesor(Model model) {
		
		model.addAttribute("listaAsideAdmin", obServicio.tresObservacionesMasRecientes());
		
		Profesor profesor = new Profesor();
		model.addAttribute("profesor", profesor);
		
		model.addAttribute("listaCursos", CursoServicio.findAll()); 		//LISTA DE CURSOS PARA PROFESOR
		model.addAttribute("listaActividades", ActServicio.findAll()); 		//LISTA DE ACTIVIDADES PARA PROFESOR
		
		return "admin/agregarEditarProfesoresAdmin";
	}	

// ---------------------------------------------------------------------------------------------------------------------------
	
	
// GUARDA LOS PROFESORES A LA BASE DE DATOS ----------------------------------------------------------------------------------
	
	@PostMapping("/nuevoProfesor/submit")
	public String registrarNuevoProfesor(@ModelAttribute("profesor") Profesor profesor) {
		
		servicio.save(profesor);		
			
		return "redirect:/admin/profesores/";
	} 

// ---------------------------------------------------------------------------------------------------------------------------
	
	
// FORMULARIO PARA EDITAR PROFESORES -----------------------------------------------------------------------------------------

	@GetMapping("/editarProfesor/{id}")
	public String mostrarFormularioEdicion(@PathVariable("id") long idProfesor, Model model) {
		
		model.addAttribute("listaAsideAdmin", obServicio.tresObservacionesMasRecientes());
		
		Optional<Profesor> profesorEditar = servicio.findById(idProfesor);
		
		if(profesorEditar.isPresent()) {
			
			model.addAttribute("profesor", profesorEditar.get());
			
			model.addAttribute("listaCursos", CursoServicio.findAll()); 		//LISTA DE CURSOS PARA PROFESOR
			model.addAttribute("listaActividades", ActServicio.findAll()); 		//LISTA DE ACTIVIDADES PARA PROFESOR

			return "admin/agregarEditarProfesoresAdmin";
			
		} else {
			
			return "redirect:/admin/profesores/";
		}
		
	}
	
// ---------------------------------------------------------------------------------------------------------------------------
	
	
// GUARDA LOS CAMBIOS REALIZADOS SOBRE LOS PROFESORES EN LA BASE DE DATOS ----------------------------------------------------
	
	@PostMapping("/editarProfesor/submit")
	public String registrarProfesorEditado(@ModelAttribute("profesor") Profesor profesor) {
		
		servicio.save(profesor);
		
		return "redirect:/admin/profesores/";	
	}
	
// ---------------------------------------------------------------------------------------------------------------------------
	
	
//BORRA AL PROFESOR POR ID ---------------------------------------------------------------------------------------------------

	@GetMapping("/borrarProfesor/{id}")
	public String borrarProfesor(@PathVariable("id") long idProfesor, Model model) {
		
		model.addAttribute("listaAsideAdmin", obServicio.tresObservacionesMasRecientes());
		
		Optional<Profesor> profesorAEditar = servicio.findById(idProfesor);
				
		if(profesorAEditar.isPresent()) {
			
			servicio.desvincularAlumnoDeObservacion(profesorAEditar, idProfesor);
			servicio.delete(profesorAEditar.get());
			
		}else{
			return "redirect:/admin/profesores/?error=true";
		}
		
		return "redirect:/admin/profesores/";
	}
		
// ---------------------------------------------------------------------------------------------------------------------------

	
// BOTÓN ALUMNOS (PROFESOR) --------------------------------------------------------------------------------------------------
	
	@GetMapping("/curso/{id}/actividad/{idA}")
	public String mostrarAlumnos(@PathVariable("id") long idCurso, @PathVariable("idA") long idActividad, Model model) {
		
		model.addAttribute("listaAlumnos", servicio.filtrarAlumnosPorCursoYActividad(idCurso, idActividad));
		model.addAttribute("listaAsideAdmin", obServicio.tresObservacionesMasRecientes());
		
		return "admin/alumnosAdmin";
	}
	
// ---------------------------------------------------------------------------------------------------------------------------
	
	
// BOTÓN OBSERVACIONES (PROFESOR) --------------------------------------------------------------------------------------------
	
	@GetMapping("/observaciones/{id}")
	public String mostrarObservacionesProfesor(@PathVariable("id") long idProfesor, Model model) {
		
		model.addAttribute("listaObservaciones", servicio.filtrarObservacionesPorProfesor(idProfesor));
		model.addAttribute("listaAsideAdmin", obServicio.tresObservacionesMasRecientes());
		
		return "admin/observacionesAdmin";
	}
	
// ---------------------------------------------------------------------------------------------------------------------------
	
}
