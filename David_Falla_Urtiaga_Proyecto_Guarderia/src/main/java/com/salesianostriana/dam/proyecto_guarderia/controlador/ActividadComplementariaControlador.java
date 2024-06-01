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

import com.salesianostriana.dam.proyecto_guarderia.modelo.ActividadComplementaria;
import com.salesianostriana.dam.proyecto_guarderia.servicio.ActividadComplementariaServicio;

@Controller
@RequestMapping("/admin/actividades")
public class ActividadComplementariaControlador {
	
	@Autowired
	private ActividadComplementariaServicio servicio;
	
	
	//MOSTRAR LA LISTA DE ACTIVIDADES COMPLEMENTARIAS -----------------------------------------------------------------------------
	
	@GetMapping("")
	public String mostrarActividades(Model model) {
			
		model.addAttribute("listaActividades", servicio.findAll());
		
		return "admin/actsComplementariasAdmin";
	}
	
	
	// MUESTRA EL FORMULARIO PARA AÑADIR ACTIVIDADES COMPLEMENTARIAS VACÍO -------------------------------------------------------
	
	@GetMapping("/nuevaActividad")
	public String mostrarFormularioActividadesAgregar(Model model) {
			
		ActividadComplementaria actividad = new ActividadComplementaria();
		model.addAttribute("actividad", actividad);
			
		return "admin/agregarEditarActsComplementariasAdmin";
	}	

		
		
	// AÑADE LA NUEVA ACTIVIDAD COMPLEMENTARIA A LA BASE DE DATOS ---------------------------------------------------------------
		
	@PostMapping("/nuevaActividad/submit")
	public String registrarNuevaActividad(@ModelAttribute("actividad") ActividadComplementaria actividad) {
			
			servicio.save(actividad);		
			
		return "redirect:/admin/actividades";
	} 

	
	// MUESTRA EL FORMULARIO PARA AÑADIR ACTIVIDADES COMPLEMENTARIAS RELLENO ---------------------------------------------------

	@GetMapping("/editarActividad/{id}")
	public String mostrarFormularioActividadesEditar(@PathVariable("id") long id, Model model) {
			
		Optional<ActividadComplementaria> actividadAEditar = servicio.findById(id);
			
		if(actividadAEditar.isPresent()) {
				
			model.addAttribute("actividad", actividadAEditar.get());
			return "admin/agregarEditarActsComplementariasAdmin";
				
		} else {
				
			return "redirect:/admin/actividades";
		}
			
	}
		
		
		
	// GUARDA LOS NUEVOS CAMBIOS A LA ACTIVIDAD COMPLEMENTARIA ----------------------------------------------------------------
		
	@PostMapping("/editarActividad/submit")
	public String registrarActividadEditada(@ModelAttribute("actividad") ActividadComplementaria actividad) {
			
		servicio.save(actividad);
			
		return "redirect:/admin/actividades";	
	}
		
		
		
	//BORRA A LA ACTIVIDAD COMPLEMENTARIA ELEGIDA POR ID ----------------------------------------------------------------------

	@GetMapping("/borrarActividad/{id}")
	public String borrarActividad(@PathVariable("id") long id) {
			
		servicio.deleteById(id);
			
		return "redirect:/admin/actividades";
	}
	
		
}
