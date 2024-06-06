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

import com.salesianostriana.dam.proyecto_guarderia.modelo.Alumno;
import com.salesianostriana.dam.proyecto_guarderia.modelo.Usuario;
import com.salesianostriana.dam.proyecto_guarderia.servicio.ActividadComplementariaServicio;
import com.salesianostriana.dam.proyecto_guarderia.servicio.AlumnoServicio;
import com.salesianostriana.dam.proyecto_guarderia.servicio.CursoServicio;
import com.salesianostriana.dam.proyecto_guarderia.servicio.ProfesorServicio;

@Controller
public class AlumnoControlador {

	@Autowired
	private AlumnoServicio servicio;
	
	@Autowired
	private CursoServicio cursoServicio;
	
	@Autowired
	private ProfesorServicio profeServicio;
	
	@Autowired
	private ActividadComplementariaServicio actServicio;

//MOSTRAR LA LISTA DE ALUMNOS -----------------------------------------------------------------------------------------------------------
	
	// USUARIO
	
	@GetMapping("/usuario/alumnos")
	public String mostrarAlumnosUsuario(@AuthenticationPrincipal Usuario usuario, Model model) {
		
		model.addAttribute("listaAlumnos", servicio.filtrarAlumnosPorUsuario(usuario));
	
		return "usuario/alumnosUsuario";
	}

		
	// ADMINISTRADOR 
	
	@GetMapping("/admin/alumnos")
	public String mostrarAlumnosAdmin(Model model) {
			
		model.addAttribute("listaAlumnos", servicio.findAll());
		
		return "admin/alumnosAdmin";
	}
	
// --------------------------------------------------------------------------------------------------------------------------------------

	
	
	//FORMULARIO DE MATRÍCULA (PARA AÑADIR ALUMNOS) VACÍA ------------------------------------------------------------------------------

	@GetMapping("/usuario/matricula")
	public String mostrarMatricula(Model model) {
		
		Alumno alumno = new Alumno();
		model.addAttribute("alumno", alumno);
		
		model.addAttribute("listaCursos", cursoServicio.findAll()); 	//LISTA DE CURSOS PARA ALUMNO
		model.addAttribute("listaActividades", actServicio.findAll());	//LISTA DE ACTIVIDADES PARA ALUMNO
		
		return "agregarEditarAlumnos";
	}

	
	
	//ENVIAMOS LOS DATOS DEL ALUMNO A LA BASE DE DATOS -------------------------------------------------------------------
	
	@PostMapping("/usuario/matricula/submit")
	public String registroMatriculaFormulario(@ModelAttribute("alumno") Alumno alumno, @AuthenticationPrincipal Usuario usuario) {
		
		alumno.setProgenitor(usuario);
		servicio.save(alumno);		
			
		return "redirect:/usuario/alumnos";
	}
	
	
	
	// MUESTRA EL FORMULARIO PARA AÑADIR ALUMNOS RELLENO --------------------------------------------------------------

	@GetMapping("/admin/alumnos/editarAlumno/{id}")
	public String mostrarFormularioEdicion(@PathVariable("id") long id, Model model) {
			
		Optional<Alumno> AlumnoAEditar = servicio.findById(id);
			
		if(AlumnoAEditar.isPresent()) {
				
			model.addAttribute("alumno", AlumnoAEditar.get());
				
			model.addAttribute("listaCursos", cursoServicio.findAll()); 	//LISTA DE CURSOS PARA PROFESOR
			model.addAttribute("listaActividades", actServicio.findAll());	//LISTA DE ACTIVIDADES PARA ALUMNO

			return "agregarEditarAlumnos";
				
		} else {
				
			return "redirect:/admin/alumnos";
		}
			
	}
		
		
		
	// GUARDA LOS NUEVOS CAMBIOS AL PROFESOR -----------------------------------------------------------------------------
		
	@PostMapping("/admin/alumnos/editarAlumno/submit")
	public String registrarAlumnoEditado(@ModelAttribute("alumno") Alumno alumno) {
			
		servicio.save(alumno);
			
		return "redirect:/admin/alumnos";	
	}
		
		
		
	//BORRA AL PROFESOR ELGIDO POR ID ------------------------------------------------------------------------------------

	@GetMapping("/admin/alumnos/borrarAlumno/{id}")
	public String borrarAlumno(@PathVariable("id") long id) {
			
		servicio.deleteById(id);
			
		return "redirect:/admin/alumnos";
	}
				
	
	
	@GetMapping("/admin/alumnos/filtrados")
	public String mostrarAlumnosFiltrados(Model model, long idCurso, long idActividad) {
		
		model.addAttribute("listaAlumnos", profeServicio.filtrarAlumnosPorCursoYActividad(idCurso, idActividad));
	
		return "admin/profesoresAdmin";
	}

	
}
	

	
	
	
	
	
	
