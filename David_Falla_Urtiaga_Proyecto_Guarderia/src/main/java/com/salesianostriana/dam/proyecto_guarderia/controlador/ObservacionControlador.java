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

import com.salesianostriana.dam.proyecto_guarderia.modelo.Observacion;
import com.salesianostriana.dam.proyecto_guarderia.servicio.ActividadComplementariaServicio;
import com.salesianostriana.dam.proyecto_guarderia.servicio.AlumnoServicio;
import com.salesianostriana.dam.proyecto_guarderia.servicio.ObservacionServicio;
import com.salesianostriana.dam.proyecto_guarderia.servicio.ProfesorServicio;

@Controller
@RequestMapping("/admin/observaciones")
public class ObservacionControlador {

	@Autowired
	private ObservacionServicio servicio;
	
	@Autowired 
	private AlumnoServicio alumnoServicio;
	
	@Autowired 
	private ProfesorServicio profeServicio;
	
	@Autowired 
	private ActividadComplementariaServicio actServicio;
	
	
	//MOSTRAR LA LISTA DE OBSERVACIONES -----------------------------------------------------------------------------
	
	@GetMapping("/")
	public String mostrarObservaciones(Model model) {
		
		model.addAttribute("listaObservaciones", servicio.findAll());
		model.addAttribute("listaAsideAdmin", servicio.tresObservacionesMasRecientes());
		
		return "admin/observacionesAdmin";
	}
	
	
	// MUESTRA EL FORMULARIO PARA AÑADIR OBSERVACIONES VACÍO -------------------------------------------------------
	
	@GetMapping("/nuevaObservacion")
	public String mostrarFormularioObservacionAgregar(Model model) {
			
		Observacion observacion = new Observacion();
		model.addAttribute("observacion", observacion);
		model.addAttribute("listaAsideAdmin", servicio.tresObservacionesMasRecientes());
		
		model.addAttribute("listaAlumnos", alumnoServicio.findAll()); 		//LISTA DE ALUMNOS PARA OBSERVACIÓN
		model.addAttribute("listaProfesores", profeServicio.findAll()); 	//LISTA DE PROFESORES PARA OBSERVACIÓN
		model.addAttribute("listaActividades", actServicio.findAll()); 		//LISTA DE ACTIVIDADES PARA OBSERVACIÓN
			
		return "admin/agregarEditarObservacionesAdmin";
	}	

		
		
	// AÑADE LA NUEVA OBSERVACIÓN A LA BASE DE DATOS ---------------------------------------------------------------
		
	@PostMapping("/nuevaObservacion/submit")
	public String registrarNuevoCurso(@ModelAttribute("observacion") Observacion observacion) {
			
		servicio.introducirFechaInstante(observacion);
		servicio.save(observacion);		
			
		return "redirect:/admin/observaciones/";
	} 

	
	// MUESTRA EL FORMULARIO PARA AÑADIR CURSOS RELLENO ---------------------------------------------------

	@GetMapping("/editarObservacion/{id}")
	public String mostrarFormularioObservacionEditar(@PathVariable("id") long id, Model model) {
			
		Optional<Observacion> observacionAEditar = servicio.findById(id);
		model.addAttribute("listaAsideAdmin", servicio.tresObservacionesMasRecientes());
		
		model.addAttribute("listaAlumnos", alumnoServicio.findAll()); 		//LISTA DE ALUMNOS PARA OBSERVACIÓN
		model.addAttribute("listaProfesores", profeServicio.findAll()); 	//LISTA DE PROFESORES PARA OBSERVACIÓN
		model.addAttribute("listaActividades", actServicio.findAll()); 		//LISTA DE ACTIVIDADES PARA OBSERVACIÓN
			
		if(observacionAEditar.isPresent()) {
				
			model.addAttribute("observacion", observacionAEditar.get());
			return "admin/agregarEditarObservacionesAdmin";
				
		} else {
				
			return "redirect:/admin/observaciones/";
		}
			
	}
		
		
		
	// GUARDA LOS NUEVOS CAMBIOS A LOS CURSOS ----------------------------------------------------------------
		
	@PostMapping("/editarObservacion/submit")
	public String registrarObservacionEditada(@ModelAttribute("observacion") Observacion observacion) {
		
		servicio.save(observacion);
			
		return "redirect:/admin/observaciones/";	
	}
		
		
		
	//BORRA EL CURSO ELEGIDO POR ID ----------------------------------------------------------------------

	@GetMapping("/borrarObservacion/{id}")
	public String borrarObservacion(@PathVariable("id") long id, Model model) {

		Optional<Observacion> observacionAEditar = servicio.findById(id);
		model.addAttribute("listaAsideAdmin", servicio.tresObservacionesMasRecientes());
		
		if(observacionAEditar.isPresent()) {
			
				servicio.deleteById(id);
				
			}else {
				
				return "redirect:/admin/observaciones/?error=true";
			}
			
		return "redirect:/admin/observaciones/";
	}
	
		
	
	// FILTRA AL ALUMNO ELEGIDO EN LA OBSERVACIÓN  -----------------------------------------------------------------
	
	@GetMapping("/alumno/{id}")
	public String mostrarAlumnoFiltradoPorId(@PathVariable("id") long id, Model model) {
			
		model.addAttribute("listaAlumnos", servicio.encontrarAlumnoPorId(id));
		model.addAttribute("listaAsideAdmin", servicio.tresObservacionesMasRecientes());
		
		return "admin/alumnosAdmin";
	}


}
