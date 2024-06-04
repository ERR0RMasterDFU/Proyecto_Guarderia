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
import com.salesianostriana.dam.proyecto_guarderia.modelo.Progenitor;
import com.salesianostriana.dam.proyecto_guarderia.modelo.Usuario;
import com.salesianostriana.dam.proyecto_guarderia.servicio.UsuarioServicio;


@Controller
@RequestMapping("/admin")
public class AdminControlador {

	@Autowired
	private UsuarioServicio servicio;
	
	
	// MUESTRA LA PÁGINA DE BIENVENIDA (ADMIN) -------------------------------------------------------------------------------------------------------------------------------

	@GetMapping("/")
	public String muestraBienvenidaAdmin() {
		
		return "admin/bienvenidaAdmin";
	}
	
	
	@GetMapping("/usuarios")
	public String mostrarListaUsuarios(Model model) {
		
		
			
		model.addAttribute("listaUsuarios", servicio.findAll());
		
		return "admin/tablaUsuariosAdmin";
		
	}			
			
			
	/* BORRA EL USUARIO ELEGIDO POR ID ----------------------------------------------------------------------

	@GetMapping("/borrarUsuario/{id}")
	public String borrarUsuario(@PathVariable("id") long id) {

		Optional<Usuario> usuarioABorrar = servicio.findById(id);
			
		if(usuarioABorrar.isPresent()) {
			
			if(servicio.contarAlumnosdeUnUsuario(id) == 0) {
				servicio.deleteById(id);
			}else {
				return "redirect:/admin/usuarios?error=true";
			}
		}
				
			return "redirect:/admin/usuarios";
	}
		
			
		
		/* FILTRA A LOS PROFESORES POR CURSO -----------------------------------------------------------------
		
		@GetMapping("/profesores/{id}")
		public String mostrarProfesoresFiltradosPorCursos(@PathVariable("id") long id, Model model) {
				
			model.addAttribute("listaProfesores", servicio.findProfesoresByCurso(id));
			
			return "admin/profesoresAdmin";
		}
		
		
		
	}*/

	
	
}


	
	

