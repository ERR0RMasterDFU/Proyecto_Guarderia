package com.salesianostriana.dam.proyecto_guarderia.controlador;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.dam.proyecto_guarderia.modelo.Alumno;
import com.salesianostriana.dam.proyecto_guarderia.modelo.DatosAlumno;
import com.salesianostriana.dam.proyecto_guarderia.modelo.Usuario;
import com.salesianostriana.dam.proyecto_guarderia.servicio.ActividadComplementariaServicio;
import com.salesianostriana.dam.proyecto_guarderia.servicio.AlumnoServicio;
import com.salesianostriana.dam.proyecto_guarderia.servicio.CursoServicio;
import com.salesianostriana.dam.proyecto_guarderia.servicio.DatosAlumnoServicio;
import com.salesianostriana.dam.proyecto_guarderia.servicio.ObservacionServicio;
import com.salesianostriana.dam.proyecto_guarderia.servicio.UsuarioServicio;

@Controller
public class AlumnoControlador {

	@Autowired
	private AlumnoServicio servicio;
	
	@Autowired
	private UsuarioServicio userServicio;
	
	@Autowired
	private CursoServicio cursoServicio;
	
	@Autowired
	private ActividadComplementariaServicio actServicio;
	
	@Autowired
	private ObservacionServicio obServicio;
	
	@Autowired
	private DatosAlumnoServicio datosServicio;
	

// PANTALLA CON LOS ALUMNOS --------------------------------------------------------------------------------------------------
	
	// USUARIO
	@GetMapping("/usuario/alumnos")
	public String mostrarAlumnosUsuario(@AuthenticationPrincipal Usuario usuario, Model model) {
		
		model.addAttribute("listaAlumnos", servicio.filtrarAlumnosPorUsuario(usuario));
		model.addAttribute("listaAsideUsuario", obServicio.tresObservacionesMasRecientesUsuario(usuario));
		
		LocalDate cumpleanos = LocalDate.now();
		model.addAttribute("cumpleanos", cumpleanos);
		model.addAttribute("alumnos", servicio.contarHijosMatriculadosPorUsuario(usuario));
	
		return "usuario/alumnosUsuario";
	}

	
	// ADMINISTRADOR 
	@GetMapping("/admin/alumnos")
	public String mostrarAlumnosAdmin(Model model) {
			
		model.addAttribute("listaAlumnos", servicio.findAll());
		model.addAttribute("listaAsideAdmin", obServicio.tresObservacionesMasRecientes());
		
		LocalDate cumpleanos = LocalDate.now();
		model.addAttribute("cumpleanos", cumpleanos);
		
		return "admin/alumnosAdmin";
	}
	
// ---------------------------------------------------------------------------------------------------------------------------
		
		
// BORRA AL ALUMNO POR ID ----------------------------------------------------------------------------------------------------

	@GetMapping("/admin/alumnos/borrarAlumno/{id}")
	public String borrarAlumno(@PathVariable("id") long id, Model model) {
			
		model.addAttribute("listaAsideAdmin", obServicio.tresObservacionesMasRecientes());
		
		Optional<Alumno> alumnoAEditar = servicio.findById(id);
			
		if(alumnoAEditar.isPresent()) {
			
			servicio.desvincularProfesoresDeObservacion(alumnoAEditar, id);
			userServicio.restarNumHijos(alumnoAEditar.get().getDatos().getProgenitor());
			servicio.delete(alumnoAEditar.get());
				
		} else {
				
			return "redirect:/admin/alumnos";
		}
		
		return "redirect:/admin/alumnos";	
	}

// ---------------------------------------------------------------------------------------------------------------------------
	
	
// BOTÓN OBSERVACIONES (ALUMNO) ----------------------------------------------------------------------------------------------
	
	//ADMINISTRADOR
	@GetMapping("/admin/alumnos/observaciones/{id}")
	public String mostrarObservacionesFiltradas(@PathVariable("id") long idAlumno, Model model) {
		
		model.addAttribute("listaObservaciones", servicio.filtrarObservacionesPorAlumnoId(idAlumno));
		model.addAttribute("listaAsideAdmin", obServicio.tresObservacionesMasRecientes());
	
		return "admin/observacionesAdmin";
	}
	
	
	//USUARIO
	@GetMapping("/usuario/alumnos/observaciones/{id}")
	public String mostrarObservacionesFiltradasUsuario(@PathVariable("id") long idAlumno, Model model, @AuthenticationPrincipal Usuario usuario) {
		
		model.addAttribute("listaObservaciones", servicio.filtrarObservacionesPorAlumnoId(idAlumno));
		model.addAttribute("listaAsideUsuario", obServicio.tresObservacionesMasRecientesUsuario(usuario));
	
		return "usuario/observacionesUsuario";
	}
	
// ---------------------------------------------------------------------------------------------------------------------------
	
	
// BOTÓN TUTOR LEGAL (ALUMNO) ------------------------------------------------------------------------------------------------
	
	@GetMapping("/admin/alumnos/tutorLegal/{id}")
	public String mostrarTutorLegalDeAlumno(@PathVariable("id") long idAlumno, Model model) {
		
		model.addAttribute("listaUsuarios", servicio.findUsuarioByAlumnoId(idAlumno));
		model.addAttribute("listaAsideAdmin", obServicio.tresObservacionesMasRecientes());
	
		return "admin/tablaUsuariosAdmin";
	}
	
// ---------------------------------------------------------------------------------------------------------------------------
	

// BOTÓN HORARIO (ALUMNO) ----------------------------------------------------------------------------------------------------
	
	// ADMINISTRADOR
	@GetMapping("/admin/alumnos/actividades/{id}")
	public String mostrarActividadesFiltradasPorAlumno(@PathVariable("id") long id, Model model) {
			
		model.addAttribute("listaActividades", servicio.filtrarActividadesPorAlumnoId(id));
		model.addAttribute("listaAsideAdmin", obServicio.tresObservacionesMasRecientes());
		
		return "admin/actsComplementariasAdmin";
	}
	
	
	// USUARIO
	@GetMapping("/usuario/alumnos/horario/{id}")
	public String mostrarActividadesFiltradasPorAlumnoUsuario(@PathVariable("id") long id, Model model, @AuthenticationPrincipal Usuario usuario) {
			
		model.addAttribute("listaActividades", servicio.filtrarActividadesPorAlumnoId(id));
		model.addAttribute("listaAsideUsuario", obServicio.tresObservacionesMasRecientesUsuario(usuario));
		
		return "usuario/horarioUsuario";
	}
	
// ---------------------------------------------------------------------------------------------------------------------------
	
	
	
	
	
	
	
	
// FORMULARIO AÑADIR ALUMNOS -------------------------------------------------------------------------------------------------

	@GetMapping("/usuario/nuevoAlumno/{id}")
	public String mostrarMatricula(@PathVariable("id") long id, Model model, @AuthenticationPrincipal Usuario usuario) {
		
		model.addAttribute("listaAsideUsuario", obServicio.tresObservacionesMasRecientesUsuario(usuario));
			
		Alumno alumno = new Alumno();
		
		model.addAttribute("alumno", alumno);
		model.addAttribute("numHijos", servicio.contarHijosMatriculadosPorUsuario(usuario));
		model.addAttribute("datosAlumno", datosServicio.filtrarDatosPorId(id)); 	//DATOS DEL ALUMNO
		model.addAttribute("listaCursos", cursoServicio.findAll()); 	//LISTA DE CURSOS PARA ALUMNO
		model.addAttribute("listaActividades", actServicio.findAll());	//LISTA DE ACTIVIDADES PARA ALUMNO
		
		
		servicio.resetearPrecioMatricula(alumno);
			
		return "usuario/agregarEditarAlumnoUsuario";
	}

// ---------------------------------------------------------------------------------------------------------------------------
	
	
// GUARDA EL ALUMNO EN LA BASE DE DATOS --------------------------------------------------------------------------------------
	
	@PostMapping("/usuario/nuevoAlumno/submit")
	public String registroMatriculaFormulario(@ModelAttribute("alumno") Alumno alumno) {
		
		alumno.getDatos().setValidos(true);
		alumno.getDatos().setMatriculado(true);
		
		servicio.resetearPrecioMatricula(alumno);
	
		alumno.setPrecioMatricula(servicio.calcularDescuento(alumno.getDatos().getProgenitor(), servicio.calcularPrecioFinalMatricula(alumno)));
		
		userServicio.aumentarNumHijos(alumno.getDatos().getProgenitor());
		
		servicio.save(alumno);
			
		return "redirect:/usuario/alumnos";
	}
	
// ---------------------------------------------------------------------------------------------------------------------------
	
	
// PANTALLA DE MATRÍCULAS (USUARIO) ------------------------------------------------------------------------------------------

	@GetMapping("/usuario/matriculas")
	public String mostrarListaMatriculas(Model model, @AuthenticationPrincipal Usuario usuario) {
		
		model.addAttribute("listaAsideUsuario", obServicio.tresObservacionesMasRecientesUsuario(usuario));
		
		model.addAttribute("listaMatriculas", servicio.filtrarAlumnosPorUsuario(usuario)); 	//DATOS DEL ALUMNO
		model.addAttribute("listaCursos", cursoServicio.findAll()); 	//LISTA DE CURSOS PARA ALUMNO
		model.addAttribute("listaActividades", actServicio.findAll());	//LISTA DE ACTIVIDADES PARA ALUMNO
			
		return "usuario/matriculasUsuario";
	}

// ---------------------------------------------------------------------------------------------------------------------------
	
	
// FORMULARIO EDITAR ALUMNOS -------------------------------------------------------------------------------------------------

	@GetMapping("/usuario/editarAlumno/{id}")
	public String mostrarFormularioEdicion(@PathVariable("id") long id, Model model, @AuthenticationPrincipal Usuario usuario) {
			
		model.addAttribute("listaAsideUsuario", obServicio.tresObservacionesMasRecientesUsuario(usuario));
		
		Optional<Alumno> alumnoAEditar = servicio.findById(id);
			
		if(alumnoAEditar.isPresent()) {
				
			model.addAttribute("alumno", alumnoAEditar.get());
			model.addAttribute("numHijos", servicio.contarHijosMatriculadosPorUsuario(usuario));	
			model.addAttribute("datosAlumno", datosServicio.filtrarDatosPorId(id)); 	//DATOS DEL ALUMNO
			model.addAttribute("listaCursos", cursoServicio.findAll()); 	//LISTA DE CURSOS PARA ALUMNO
			model.addAttribute("listaActividades", actServicio.findAll());	//LISTA DE ACTIVIDADES PARA ALUMNO

			return "usuario/agregarEditarAlumnoUsuario";
				
		} else {
				
			return "redirect:/usuario/matriculas";
		}
	}
	
// ---------------------------------------------------------------------------------------------------------------------------
		
		
// GUARDA LOS CAMBIOS REALIZADOS SOBRE EL ALUMNO EN LA BASE DE DATOS ---------------------------------------------------------
		
	@PostMapping("/usuario/editarAlumno/submit")
	public String registrarAlumnoEditado(@ModelAttribute("alumno") Alumno alumno) {
		
		servicio.resetearPrecioMatricula(alumno);
		
		alumno.setPrecioMatricula(servicio.calcularDescuento(alumno.getDatos().getProgenitor(), servicio.calcularPrecioFinalMatricula(alumno)));
		
		servicio.save(alumno);
			
		return "redirect:/usuario/matriculas";	
	}
		
// ---------------------------------------------------------------------------------------------------------------------------
	
	
	
	
	
}
