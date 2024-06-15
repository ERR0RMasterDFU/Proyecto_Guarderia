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

import com.salesianostriana.dam.proyecto_guarderia.modelo.DatosAlumno;
import com.salesianostriana.dam.proyecto_guarderia.modelo.Usuario;
import com.salesianostriana.dam.proyecto_guarderia.servicio.DatosAlumnoServicio;
import com.salesianostriana.dam.proyecto_guarderia.servicio.ObservacionServicio;

@Controller
@RequestMapping("/usuario/DatosAlumnos")
public class DatosAlumnoControlador {

	@Autowired
	private DatosAlumnoServicio servicio;
	
	@Autowired
	private ObservacionServicio obServicio;
	
	
// PANTALLA CON LOS DATOS ENVIADOS -------------------------------------------------------------------------------------------
	
	@GetMapping("/enviados")
	public String mostrarDatosEnviados(Model model, @AuthenticationPrincipal Usuario usuario) {
			
		model.addAttribute("listaDatosAlumnos", servicio.filtrarDatosPorUsuario(usuario));
		model.addAttribute("listaAsideUsuario", obServicio.tresObservacionesMasRecientesUsuario(usuario));
			
		return "usuario/datosAlumnosUsuario";
	}
		
// ---------------------------------------------------------------------------------------------------------------------------
	
	
// FORMULARIO PARA AÑADIR DATOS ----------------------------------------------------------------------------------------------
	
	@GetMapping("/nuevosDatosAlumno")
	public String mostrarFormularioAgregarDatosAlumno(Model model, @AuthenticationPrincipal Usuario usuario) {
				
		model.addAttribute("listaAsideUsuario", obServicio.tresObservacionesMasRecientesUsuario(usuario));
			
		DatosAlumno datos = new DatosAlumno();
		model.addAttribute("datos", datos);
				
		return "usuario/agregarEditarDatosAlumnos";
	}	

// ---------------------------------------------------------------------------------------------------------------------------
			
			
// GUARDA LOS DATOS EN LA BASE DE DATOS --------------------------------------------------------------------------------------
			
	@PostMapping("/nuevosDatosAlumno/submit")
	public String registrarDatosDeAlumnoNuevo(@ModelAttribute("datos") DatosAlumno datos, @AuthenticationPrincipal Usuario usuario) {
				
		datos.setProgenitor(usuario);
		servicio.save(datos);		
				
		return "redirect:/usuario/DatosAlumnos/enviados";
	} 

// ---------------------------------------------------------------------------------------------------------------------------
	
	
// FORMULARIO EDITAR DATOS ---------------------------------------------------------------------------------------------------

	@GetMapping("/editarDatosAlumno/{id}")
	public String mostrarFormularioEdicion(@PathVariable("id") long id, Model model, @AuthenticationPrincipal Usuario usuario) {
			
		model.addAttribute("listaAsideUsuario", obServicio.tresObservacionesMasRecientesUsuario(usuario));
		
		Optional<DatosAlumno> datosAEditar = servicio.findById(id);
			
		if(datosAEditar.isPresent()) {
			model.addAttribute("datos", datosAEditar.get());
		}
			return "usuario/agregarEditarDatosAlumnos";
	}
	
// ---------------------------------------------------------------------------------------------------------------------------
		
			
// GUARDA LOS CAMBIOS REALIZADOS SOBRE LOS DATOS EN LA BASE DE DATOS ---------------------------------------------------------
		
	@PostMapping("/editarDatosAlumno/submit")
	public String registrarAlumnoEditado(@ModelAttribute("datos") DatosAlumno datos) {
			
		servicio.CambiarEstadoDatosEditar(datos);
		servicio.save(datos);
			
		return "redirect:/usuario/DatosAlumnos/enviados";	
	}
		
// ---------------------------------------------------------------------------------------------------------------------------

	
// BORRA LOS DATOS (ENVIADOS) POR ID -----------------------------------------------------------------------------------------

	@GetMapping("/borrarDatosAlumno/{id}")
	public String borrarDatosEnviados(@PathVariable("id") long id, Model model, @AuthenticationPrincipal Usuario usuario) {

		model.addAttribute("listaAsideUsuario", obServicio.tresObservacionesMasRecientesUsuario(usuario));
		
		Optional<DatosAlumno> datosABorrar = servicio.findById(id);
		
		if(datosABorrar.isPresent()) {
			servicio.deleteById(id);
		}
			
		return "redirect:/usuario/DatosAlumnos/enviados";
	}
	
// ---------------------------------------------------------------------------------------------------------------------------	
	
	
	
}
