package com.salesianostriana.dam.proyecto_guarderia.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.dam.proyecto_guarderia.modelo.Alumno;
import com.salesianostriana.dam.proyecto_guarderia.servicio.AlumnoServicio;

@Controller
@RequestMapping("/usuario")
public class AlumnoControlador {

	@Autowired
	private AlumnoServicio servicio;
	
	
//MOSTRAR LA LISTA DE ALUMNOS DEL USUARIO -----------------------------------------------------------------------------
	
	@GetMapping("/alumnos")
	public String mostrarProfesores(Model model) {
		
		model.addAttribute("listaAlumnos", servicio);
	
		return "usuario/alumnosUsuario";
	}
	
	
//FORMULARIO DE MATRÍCULA VACÍA ---------------------------------------------------------------------------------------

	@GetMapping("/rellenarMatriculaAlumno")
	public String mostrarMatricula(Model model) {
		
		Alumno alumno = new Alumno();
		model.addAttribute("alumno", alumno);
		
		return "usuario/formularioEnvioDeDatos";
	}

//---------------------------------------------------------------------------------------------------------------------
	
	
//ENVIAMOS LOS DATOS DEL FORMULARIO A LA BASE DE DATOS ---------------------------------------------
	
	@PostMapping("/envioMatriculaAlumno")
	public String registroFormulario(@ModelAttribute("alumno") Alumno alumno) {
		
			servicio.save(alumno);		
			
		return "redirect:/usuario/rellenarMatriculaAlumno";
	}
	
//--------------------------------------------------------------------------------------------------
	
	
//FORMULARIO DE MATRÍCULA RELLENO ------------------------------------------------------------------
	
	@GetMapping("matricularAlumno")
	public String mostrarMatriculaRellena(Model model) {

		model.addAttribute("matricularAlumnosAdmin", servicio.findAll());
		
		return "matricularAlumnosAdmin";
	}
	
	
	
}
	
	
	/*@PostMapping("/agregar")
	public String loquesea(@ModelAttribute("usuario") Usuario usuario){
		
		usuario.setNombreUsuario(usuario.getDni)*/
		
	
	
	
	
	
	
