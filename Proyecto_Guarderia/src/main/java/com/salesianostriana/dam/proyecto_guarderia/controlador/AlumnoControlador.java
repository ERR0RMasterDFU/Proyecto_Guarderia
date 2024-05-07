package com.salesianostriana.dam.proyecto_guarderia.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.dam.proyecto_guarderia.modelo.Alumno;
import com.salesianostriana.dam.proyecto_guarderia.servicio.AlumnoServicio;

@Controller
public class AlumnoControlador {

	@Autowired
	private AlumnoServicio servicio;
	
	
//FORMULARIO DE MATRÍCULA VACÍA --------------------------------------------------------------------

	@GetMapping("/matriculaAlumno")
	public String mostrarMatricula(Model model) {
		
		Alumno alumno = new Alumno();
		model.addAttribute("formularioEnvioDeDatos", alumno);
		
		return "formularioEnvioDeDatos";
	}

//--------------------------------------------------------------------------------------------------
	
	
//ENVIAMOS LOS DATOS DEL FORMULARIO A LA BASE DE DATOS ---------------------------------------------
	
	@PostMapping("/envioMatriculaAlumno")
	public String submit(@ModelAttribute("formularioEnvioDeDatos") Alumno alumno) {
		
			servicio.save(alumno);		
			
		return "redirect:/matriculaAlumno";
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
		
	
	
	
	
	
	
