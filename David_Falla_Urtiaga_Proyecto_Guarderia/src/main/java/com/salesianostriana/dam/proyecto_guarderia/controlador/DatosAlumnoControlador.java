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

import com.salesianostriana.dam.proyecto_guarderia.modelo.DatosAlumno;
import com.salesianostriana.dam.proyecto_guarderia.modelo.Usuario;
import com.salesianostriana.dam.proyecto_guarderia.servicio.DatosAlumnoServicio;
import com.salesianostriana.dam.proyecto_guarderia.servicio.ObservacionServicio;


@Controller
public class DatosAlumnoControlador {

	@Autowired
	private DatosAlumnoServicio servicio;
	
	@Autowired
	private ObservacionServicio obServicio;
	
	
// PANTALLA CON LOS DATOS ENVIADOS -------------------------------------------------------------------------------------------
	
	//USUARIO
	@GetMapping("/usuario/datosAlumnos/enviados")
	public String mostrarDatosEnviadosUsuario(Model model, @AuthenticationPrincipal Usuario usuario) {
			
		model.addAttribute("listaDatosAlumnos", servicio.filtrarDatosPorUsuario(usuario));
		model.addAttribute("listaAsideUsuario", obServicio.tresObservacionesMasRecientesUsuario(usuario));
			
		return "usuario/datosAlumnosUsuario";
	}
	
	
	//ADMINISTRADOR
	@GetMapping("/admin/datosAlumnos/recibidos")
	public String mostrarDatosEnviadosAdmin(Model model) {
			
		model.addAttribute("listaDatosAlumnos", servicio.filtrarDatosAdmin());
		model.addAttribute("listaAsideAdmin", obServicio.tresObservacionesMasRecientes());
			
		return "admin/datosAlumnosAdmin";
	}
		
// ---------------------------------------------------------------------------------------------------------------------------
	
	
// FORMULARIO PARA AÑADIR DATOS ----------------------------------------------------------------------------------------------
	
	@GetMapping("/usuario/datosAlumnos/nuevosDatosAlumno")
	public String mostrarFormularioAgregarDatosAlumno(Model model, @AuthenticationPrincipal Usuario usuario) {
				
		model.addAttribute("listaAsideUsuario", obServicio.tresObservacionesMasRecientesUsuario(usuario));
			
		DatosAlumno datos = new DatosAlumno();
		model.addAttribute("datos", datos);
				
		return "usuario/agregarEditarDatosAlumnos";
	}	

// ---------------------------------------------------------------------------------------------------------------------------
	
	
// BOTÓN VALIDAR DATOS (ADMIN) -----------------------------------------------------------------------------------------------

	@GetMapping("/admin/datosAlumnos/validarDatos/{id}")
	public String validarDatos(@PathVariable("id") long id, Model model) {
				
		model.addAttribute("listaAsideAdmin", obServicio.tresObservacionesMasRecientes());
		
		Optional<DatosAlumno> datosAValidar = servicio.findById(id);
		
		if(datosAValidar.isPresent()) {
			datosAValidar.get().setValidos(true);
			servicio.save(datosAValidar.get());
		}		
		return "redirect:/admin/datosAlumnos/recibidos";
	}	

// ---------------------------------------------------------------------------------------------------------------------------
			
			
// GUARDA LOS DATOS EN LA BASE DE DATOS --------------------------------------------------------------------------------------
			
	@PostMapping("/usuario/datosAlumnos/nuevosDatosAlumno/submit")
	public String registrarDatosDeAlumnoNuevo(@ModelAttribute("datos") DatosAlumno datos, @AuthenticationPrincipal Usuario usuario) {
				
		datos.setProgenitor(usuario);
		servicio.save(datos);		
				
		return "redirect:/usuario/datosAlumnos/enviados";
	} 

// ---------------------------------------------------------------------------------------------------------------------------
	
	
// FORMULARIO EDITAR DATOS ---------------------------------------------------------------------------------------------------

	@GetMapping("/usuario/datosAlumnos/editarDatosAlumno/{id}")
	public String mostrarFormularioEdicion(@PathVariable("id") long id, Model model, @AuthenticationPrincipal Usuario usuario) {
			
		model.addAttribute("listaAsideUsuario", obServicio.tresObservacionesMasRecientesUsuario(usuario));
		
		Optional<DatosAlumno> datosAEditar = servicio.findById(id);
			
		if(datosAEditar.isPresent()) {
			model.addAttribute("datos", datosAEditar.get());
		}
			return "usuario/agregarEditarDatosAlumnos";
	}
	
// ---------------------------------------------------------------------------------------------------------------------------
	
	
// BOTÓN VER DETALLES (USUARIO) ----------------------------------------------------------------------------------------------

	@GetMapping("/usuario/matriculas/detalles/{id}")
	public String verDetalles(@PathVariable("id") long id, Model model, @AuthenticationPrincipal Usuario usuario) {
			
		model.addAttribute("listaAsideUsuario", obServicio.tresObservacionesMasRecientesUsuario(usuario));
		
		Optional<DatosAlumno> datosAEditar = servicio.findById(id);
			
		if(datosAEditar.isPresent()) {
			model.addAttribute("datos", datosAEditar.get());
		}
			return "usuario/datallesUsuario";
	}
	
// ---------------------------------------------------------------------------------------------------------------------------
		
			
// GUARDA LOS CAMBIOS REALIZADOS SOBRE LOS DATOS EN LA BASE DE DATOS ---------------------------------------------------------
		
	@PostMapping("/usuario/datosAlumnos/editarDatosAlumno/submit")
	public String registrarAlumnoEditado(@ModelAttribute("datos") DatosAlumno datos) {
			
		servicio.CambiarEstadoDatosEditar(datos);
		servicio.save(datos);
			
		return "redirect:/usuario/datosAlumnos/enviados";	
	}
		
// ---------------------------------------------------------------------------------------------------------------------------

	
// BORRA LOS DATOS (ENVIADOS) POR ID -----------------------------------------------------------------------------------------

	@GetMapping("/usuario/datosAlumnos/borrarDatosAlumno/{id}")
	public String borrarDatosEnviados(@PathVariable("id") long id, Model model, @AuthenticationPrincipal Usuario usuario) {

		model.addAttribute("listaAsideUsuario", obServicio.tresObservacionesMasRecientesUsuario(usuario));
		
		Optional<DatosAlumno> datosABorrar = servicio.findById(id);
		
		if(datosABorrar.isPresent()) {
			servicio.deleteById(id);
		}
			
		return "redirect:/usuario/datosAlumnos/enviados";
	}
	
// ---------------------------------------------------------------------------------------------------------------------------	
	
	
	
}
