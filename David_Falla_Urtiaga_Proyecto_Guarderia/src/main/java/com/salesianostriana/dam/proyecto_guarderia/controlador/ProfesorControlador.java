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

	
	// MUESTRA LA PÁGINA DE PROFESORES -----------------------------------------------------------------------------------
	
	@GetMapping("/")
	public String mostrarProfesores(Model model) {
		
		model.addAttribute("listaProfesores", servicio.findAll());
		model.addAttribute("listaAsideAdmin", obServicio.tresObservacionesMasRecientes());
	
		return "admin/profesoresAdmin";
	}


	
	// MUESTRA EL FORMULARIO PARA AÑADIR PROFESORES VACÍO ----------------------------------------------------------------
	
	@GetMapping("/nuevoProfesor")
	public String mostrarFormularioProfesor(Model model) {
		
		Profesor profesor = new Profesor();
		model.addAttribute("profesor", profesor);
		model.addAttribute("listaAsideAdmin", obServicio.tresObservacionesMasRecientes());
		
		model.addAttribute("listaCursos", CursoServicio.findAll()); 		//LISTA DE CURSOS PARA PROFESOR
		model.addAttribute("listaActividades", ActServicio.findAll()); 		//LISTA DE ACTIVIDADES PARA PROFESOR
		
		return "admin/agregarEditarProfesoresAdmin";
	}	

	
	
	// AÑADE EL NUEVO PROFESOR A LA BASE DE DATOS ------------------------------------------------------------------------
	
	@PostMapping("/nuevoProfesor/submit")
	public String registrarNuevoProfesor(@ModelAttribute("profesor") Profesor profesor) {
		
			servicio.save(profesor);		
			
		return "redirect:/admin/profesores/";
	} 

	
	
	// MUESTRA EL FORMULARIO PARA AÑADIR PROFESORES RELLENO --------------------------------------------------------------

	@GetMapping("/editarProfesor/{id}")
	public String mostrarFormularioEdicion(@PathVariable("id") long idProfesor, Model model) {
		
		Optional<Profesor> profesorEditar = servicio.findById(idProfesor);
		model.addAttribute("listaAsideAdmin", obServicio.tresObservacionesMasRecientes());
		
		if(profesorEditar.isPresent()) {
			
			model.addAttribute("profesor", profesorEditar.get());
			
			model.addAttribute("listaCursos", CursoServicio.findAll()); 		//LISTA DE CURSOS PARA PROFESOR
			model.addAttribute("listaActividades", ActServicio.findAll()); 		//LISTA DE ACTIVIDADES PARA PROFESOR

			return "admin/agregarEditarProfesoresAdmin";
			
		} else {
			
			return "redirect:/admin/profesores/";
		}
		
	}
	
	
	// GUARDA LOS NUEVOS CAMBIOS AL PROFESOR -----------------------------------------------------------------------------
	
	@PostMapping("/editarProfesor/submit")
	public String registrarProfesorEditado(@ModelAttribute("profesor") Profesor profesor) {
		
		servicio.save(profesor);
		
		return "redirect:/admin/profesores/";	
	}
	
	
	//BORRA AL PROFESOR ELGIDO POR ID ------------------------------------------------------------------------------------

	@GetMapping("/borrarProfesor/{id}")
	public String borrarProfesor(@PathVariable("id") long idProfesor, Model model) {
		
		model.addAttribute("listaAsideAdmin", obServicio.tresObservacionesMasRecientes());
		
		servicio.deleteById(idProfesor);
		
		return "redirect:/admin/profesores/";
		
			/*if(profesorAEditar.isPresent()) {
			
			if(servicio.contarObservacionesPorProfesor(idProfesor) == 0) {
				servicio.deleteById(idProfesor);
			}else{
				return "redirect:/admin/profesores/?error=true";
			}
		}
		
		return "redirect:/admin/profesores/";*/
	}
		

	// MUESTRA LOS ALUMNOS DEL PROFESOR ------------------------------------------------------------------------------------
	
	@GetMapping("/curso/{id}/actividad/{idA}")
	public String mostrarAlumnos(@PathVariable("id") long idCurso, @PathVariable("idA") long idActividad, Model model) {
		
		model.addAttribute("listaAlumnos", servicio.filtrarAlumnosPorCursoYActividad(idCurso, idActividad));
		model.addAttribute("listaAsideAdmin", obServicio.tresObservacionesMasRecientes());
		
		return "admin/alumnosAdmin";
	}
	
	
	
	// MUESTRA LAS OBSERVACIONES DEL PROFESOR --------------------------------------------------------------------------------
	
	
	@GetMapping("/observaciones/{id}")
	public String mostrarObservacionesProfesor(@PathVariable("id") long idProfesor, Model model) {
		
		model.addAttribute("listaObservaciones", servicio.filtrarObservacionesPorProfesor(idProfesor));
		model.addAttribute("listaAsideAdmin", obServicio.tresObservacionesMasRecientes());
		
		return "admin/observacionesAdmin";
	}
	
	
	
}
