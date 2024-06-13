package com.salesianostriana.dam.proyecto_guarderia.controlador;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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
import com.salesianostriana.dam.proyecto_guarderia.servicio.ActividadComplementariaServicio;
import com.salesianostriana.dam.proyecto_guarderia.servicio.ObservacionServicio;
import com.salesianostriana.dam.proyecto_guarderia.servicio.UsuarioServicio;

@Controller
@RequestMapping("/usuario")
public class UsuarioControlador {

	@Autowired
	private UsuarioServicio servicio;
	
	@Autowired
	private ObservacionServicio obServicio;
	
	@Autowired
	private ActividadComplementariaServicio actServicio;
	
	
// FORMULARIO PARA AÑDIR USUARIOS --------------------------------------------------------------------------------------------
	
	@GetMapping("/registro")
	public String mostrarFormularioRegistro(Model model) {
					
		model.addAttribute("listaTipoProgenitor", Progenitor.values());	
				
		Usuario usuario = new Usuario();
		model.addAttribute("usuario", usuario);
						
		return "paginaRegistro";
	}
	
// ---------------------------------------------------------------------------------------------------------------------------
	
	
// GUARDA AL USUARIO EN LA BASE DE DATOS -------------------------------------------------------------------------------------
		
	@PostMapping("/registro/submit")
	public String registrarNuevoUsuario(@ModelAttribute("usuario") Usuario usuario) {
				
		servicio.saveNewUsuario(usuario);	
					
		return "redirect:/login";
	}
		
// ---------------------------------------------------------------------------------------------------------------------------
				
	
// PANTALLA CON PERFIL DE USUARIO --------------------------------------------------------------------------------------------

	@GetMapping("/miPerfil")
	public String mostrarFormularioEdicionUsuario(@AuthenticationPrincipal Usuario usuario, Model model) {
		
		model.addAttribute("listaAsideUsuario", obServicio.tresObservacionesMasRecientesUsuario(usuario));
		model.addAttribute("listaTipoProgenitor", Progenitor.values());	
		model.addAttribute("usuario", usuario);
			
		return "usuario/perfilUsuario";

	}
	
// ---------------------------------------------------------------------------------------------------------------------------
	
	
// FORMULARIO EDITAR USUARIO -------------------------------------------------------------------------------------------------
	
	@GetMapping("/editarPerfil/{id}")
	public String registrarProfesorEditado(@PathVariable("id") long id, @AuthenticationPrincipal Usuario usuario, Model model) {
		
		model.addAttribute("listaAsideUsuario", obServicio.tresObservacionesMasRecientesUsuario(usuario));
		
		Optional<Usuario> usuarioAEditar = servicio.findById(id);
			
		if(usuarioAEditar.isPresent()) {
				
			model.addAttribute("usuario", usuarioAEditar.get());
			model.addAttribute("listaTipoProgenitor", Progenitor.values());
			
			return "usuario/editarUsuario";
				
		} else {
				
			return "redirect:/usuario/miPerfil";
		}
	}
	
// ---------------------------------------------------------------------------------------------------------------------------
	
	
// GUARDA LOS CAMBIOS REALIZADOS SOBRE EL USUARIO EN LA BASE DE DATOS --------------------------------------------------------
	
	@PostMapping("/editarPerfil/submit")
	public String registrarCursoEditado(@ModelAttribute("usuario") @AuthenticationPrincipal Usuario usuario) {
					
		servicio.save(usuario);
					
		return "redirect:/logout";	
	}
			
// ---------------------------------------------------------------------------------------------------------------------------
	
	
// PANTALLA CON LAS OBSERVACIONES (USUARIO) ----------------------------------------------------------------------------------
	
	@GetMapping("/observaciones")
	public String mostrarObservaciones(@AuthenticationPrincipal Usuario usuario, Model model) {
		
		model.addAttribute("listaObservaciones", obServicio.mostrarObservacionesPorUsuario(usuario));
		model.addAttribute("listaAsideUsuario", obServicio.tresObservacionesMasRecientesUsuario(usuario));
		
		return "usuario/observacionesUsuario";
	}
	
// ---------------------------------------------------------------------------------------------------------------------------
	
	
// BOTÓN DATOS DEL ALUMNO (OBSERVACIÓN) USUARIO ------------------------------------------------------------------------------
	
	@GetMapping("/observaciones/alumno/{id}")
	public String mostrarAlumnoFiltradoPorId(@PathVariable("id") long id, Model model, @AuthenticationPrincipal Usuario usuario) {
				
		model.addAttribute("listaAsideUsuario", obServicio.tresObservacionesMasRecientesUsuario(usuario));
		model.addAttribute("listaAlumnos", obServicio.encontrarAlumnoPorId(id));
			
		return "usuario/alumnosUsuario";
	}
	
// ---------------------------------------------------------------------------------------------------------------------------

	
// BOTÓN PROFESORES (HORARIO) USUARIO ----------------------------------------------------------------------------------------
	
	@GetMapping("/horario/profesores/{id}")
	public String mostrarProfesoresFiltradosPorActividad(@PathVariable("id") long id, Model model, @AuthenticationPrincipal Usuario usuario) {
				
		model.addAttribute("listaProfesores", actServicio.filtrarProfesoresPorActividadUsuario(id));
		model.addAttribute("listaAsideUsuario", obServicio.tresObservacionesMasRecientesUsuario(usuario));
			
		return "usuario/profesoresUsuario";
	}
	
// ---------------------------------------------------------------------------------------------------------------------------
	
}
