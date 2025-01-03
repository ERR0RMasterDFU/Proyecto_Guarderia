package com.salesianostriana.dam.proyecto_guarderia.controlador;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.dam.proyecto_guarderia.modelo.Usuario;
import com.salesianostriana.dam.proyecto_guarderia.servicio.ObservacionServicio;
import com.salesianostriana.dam.proyecto_guarderia.servicio.UsuarioServicio;


@Controller
@RequestMapping("/admin/usuarios")
public class AdminControlador {

	@Autowired
	private UsuarioServicio servicio;
	
	@Autowired
	private ObservacionServicio obServicio;

	
// PANTALLA CON LA TABLA DE USUARIOS ------------------------------------------------------------------------------------
	
	@GetMapping("/")
	public String mostrarListaUsuarios(Model model) {
		
		model.addAttribute("listaUsuarios", servicio.findAll());
		model.addAttribute("listaAsideAdmin", obServicio.tresObservacionesMasRecientes());
		
		return "admin/tablaUsuariosAdmin";
	}		
	
// ----------------------------------------------------------------------------------------------------------------------
			
			
//BORRA EL USUARIO ELEGIDO POR ID ---------------------------------------------------------------------------------------

	@GetMapping("/borrarUsuario/{id}")
	public String borrarUsuario(@PathVariable("id") long id, Model model) {

		Optional<Usuario> usuarioABorrar = servicio.findById(id);
		model.addAttribute("listaAsideAdmin", obServicio.tresObservacionesMasRecientes());
			
		if(usuarioABorrar.isPresent()) {
			
			if(servicio.contarAlumnosdeUnUsuario(id) == 0) {
				servicio.deleteById(id);
			}else {
				return "redirect:/admin/usuarios/?error=true";
			}
		}	
		
			return "redirect:/admin/usuarios/";
	}
		
// ----------------------------------------------------------------------------------------------------------------------


// BOTÓN ALUMNOS (TABLA DE USUARIOS) ------------------------------------------------------------------------------------
	
	@GetMapping("/alumnos/{id}")
	public String mostrarAlumnosUsuario(@PathVariable("id") long id, Model model) {
		
		model.addAttribute("listaAlumnos", servicio.filtrarAlumnosDeUsuario(id));
		model.addAttribute("listaAsideAdmin", obServicio.tresObservacionesMasRecientes());
	
		return "admin/alumnosAdmin";
	}

// ----------------------------------------------------------------------------------------------------------------------
	
	
}
