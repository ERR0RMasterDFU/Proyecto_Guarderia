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

import com.salesianostriana.dam.proyecto_guarderia.modelo.Usuario;
import com.salesianostriana.dam.proyecto_guarderia.modelo.TutorLegal;
import com.salesianostriana.dam.proyecto_guarderia.servicio.UsuarioServicio;

@Controller
@RequestMapping("/usuario")
public class UsuarioControlador {


	@Autowired
	private UsuarioServicio servicio;		

		
	/* MUESTRA LA PÁGINA DE PROFESORES -------------------------------------------------------------
		
	@GetMapping("/profesores")
	public String mostrarProfesores(Model model) {
			
		model.addAttribute("listaProfesores", servicio.findAll());
		
		return "admin/profesoresAdmin";
	}*/

	
	// MUESTRA EL FORMULARIO DE REGISTRO (PARA AÑADIR USUARIO / TUTOR LEGAL) VACÍO --------------------------------------------------------
		
	@GetMapping("/registro")
	public String mostrarFormularioRegistro(Model model) {
			
		Usuario utl = new TutorLegal();
		model.addAttribute("tutorLegal", utl);
			
		return "paginaRegistro";
	}	

		
	// AÑADE EL NUEVO USUARIO / TUTOR LEGAL A LA BASE DE DATOS ----------------------------------------------------------------------------
		
	@PostMapping("nuevoUsuario/submit")
	public String registrarNuevoUsuarioTL(@ModelAttribute("tutorLegal") Usuario utl) {
			
			servicio.save(utl);		
				
		return "redirect:/inicioDeSesion";
	} 

	
	//MUESTRA LA PÁGINA DE LOS DATOS DE USUARIO (MI PERFIL) ---------------------------------------------------------------------
	
	@GetMapping("/miPerfil")
	public String mostrarPerfilUsuarioTL(long idUsuario, Model model) {
			
		Optional <Usuario> tutorLegalEditar = servicio.findById(idUsuario);
			
		return "perfilUsuario";
	}	
	
		
	// MUESTRA EL FORMULARIO DE REGISTRO (PARA AÑADIR USUARIO / TUTOR LEGAL) RELLENO --------------------------------------------

	@GetMapping("/editarDatosTutorLegal/{id}")
	public String mostrarFormularioEdicionUsuarioTL(@PathVariable("id") long idUsuario, Model model) {
			
		Optional <Usuario> tutorLegalEditar = servicio.findById(idUsuario);
		
		if(tutorLegalEditar!= null) {
				
			model.addAttribute("tutorlegal", tutorLegalEditar);
			return "modificarPerfilUsuario";
				
		} else {
				
			return "perfilUsuario";
		}
	}
		
		
		
	// GUARDA LOS NUEVOS CAMBIOS AL PROFESOR ----------------------------------------------------------------------------------------------
		
		@PostMapping("/editarDatosTutorLegal/submit")
		public String registrarProfesorEditado(@ModelAttribute("tutorlegal") TutorLegal tl) {
			
			servicio.save(tl);
			
			return "redirect:/user/miPerfil";
			
		}
		
		
		
	// BORRA AL PROFESOR ELGIDO POR ID ----------------------------------------------------------------------------------------------------

		@GetMapping("/borrarProfesor/{id}")
		public String borrarProfesor(@PathVariable("id") long idProfesor) {
			
			servicio.deleteById(idProfesor);
			
			return "redirect:/admin/profesores";
		}
		
		//---------------------------------------------------------------------------------------------------------------------------------
		

}
