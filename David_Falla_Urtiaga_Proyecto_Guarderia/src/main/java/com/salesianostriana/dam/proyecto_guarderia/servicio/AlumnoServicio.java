package com.salesianostriana.dam.proyecto_guarderia.servicio;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.proyecto_guarderia.modelo.ActividadComplementaria;
import com.salesianostriana.dam.proyecto_guarderia.modelo.Alumno;
import com.salesianostriana.dam.proyecto_guarderia.modelo.Observacion;
import com.salesianostriana.dam.proyecto_guarderia.modelo.Profesor;
import com.salesianostriana.dam.proyecto_guarderia.modelo.Usuario;
import com.salesianostriana.dam.proyecto_guarderia.repositorio.AlumnoRepositorio;
import com.salesianostriana.dam.proyecto_guarderia.repositorio.UsuarioRepositorio;
import com.salesianostriana.dam.proyecto_guarderia.servicio.base.ServicioBaseImpl;

@Service
public class AlumnoServicio extends ServicioBaseImpl<Alumno, Long, AlumnoRepositorio>{

	@Autowired
	private AlumnoRepositorio repositorio;
	
	@Autowired
	private ObservacionServicio obServicio;
	
	public AlumnoServicio(UsuarioRepositorio repo) {
		super(repo);
		// TODO Auto-generated constructor stub
	}

	
// PANTALLA DE ALUMNOS (USUARIO) ---------------------------------------------------------------------------------------------
	
	public List<Alumno> filtrarAlumnosPorUsuario (Usuario usuario){
		List<Alumno> alumnosFiltrados = repositorio.findAlumnoByUsuario(usuario);
		return alumnosFiltrados;
	}
	
// ---------------------------------------------------------------------------------------------------------------------------
	

// BOTÓN OBSERVACIONES (ALUMNO) ----------------------------------------------------------------------------------------------
	
	public List<Observacion> filtrarObservacionesPorAlumnoId (long id) {
		List<Observacion> observacionesFiltradasAlumno = repositorio.findObservacionesByAlumno(id);
		return observacionesFiltradasAlumno;
	}
	
// ---------------------------------------------------------------------------------------------------------------------------
	
	
// BOTÓN TUTOR LEGAL (ALUMNO) ------------------------------------------------------------------------------------------------
	
	public Usuario findUsuarioByAlumnoId (long id) {
		Usuario obtenerUsuarioEncontrado = repositorio.findUsuarioByAlumnoId(id);
		return obtenerUsuarioEncontrado;
	}
	
// ---------------------------------------------------------------------------------------------------------------------------
	
	
// BOTÓN HORARIO (ALUMNO) ----------------------------------------------------------------------------------------------------
	
	public List<ActividadComplementaria> filtrarActividadesPorAlumnoId (long id){
		List<ActividadComplementaria> actividadesFiltradas = repositorio.findHorarioByAlumnoId(id);
		return actividadesFiltradas;
	}

// ---------------------------------------------------------------------------------------------------------------------------
	
	
// MÉTODO QUE DESASOCIA UN PROFESOR DE UNA OBSERVACIÓN PARA PERIMITR QUE EL ALUMNO PUEDA SER BORRADO -------------------------
	
	public void desvincularProfesoresDeObservacion (Optional<Alumno> alumnoAEditar, long id) {
		
		List<Observacion> observacionesAlumno = alumnoAEditar.get().getObservaciones();
		List<Profesor> listaProfesoresObs = obServicio.buscarProfesoresPorObservacionAlumno(id);
		
		for (Observacion observacion : observacionesAlumno) {
			for (Profesor profesor : listaProfesoresObs) {
				observacion.removeFromProfesor(profesor);
			}
		}
		
	}
	
// ---------------------------------------------------------------------------------------------------------------------------
	
	
// MÉTODO QUE HACE QUE LOS ALUMNOS CUMPLAN AÑOS ------------------------------------------------------------------------------
	
	public void cumplirAnios () {
		
		LocalDate cumple = LocalDate.now();
		int uno = 1;
		
		for (Alumno alumno : repositorio.findAll()) {
			
			if(alumno.getDatos().getFechaNacimiento() == cumple) {
				alumno.getDatos().setEdad(alumno.getDatos().getEdad()+uno);
			}	
		}
	}
	
// ---------------------------------------------------------------------------------------------------------------------------
	
	
// ---------------------------------------------------------------------------------------------------------------------------

	public void resetearPrecioMatricula (Alumno alumno) {
		double trescientos = 300.00;
		alumno.setPrecioMatricula(trescientos);
	}
	
// ---------------------------------------------------------------------------------------------------------------------------
	
	
// ---------------------------------------------------------------------------------------------------------------------------
	
	public double calcularPrecioFinalMatricula (Alumno alumno) {
		double precioBase = alumno.getPrecioMatricula();
		double precioAct = 0.00;
		
		for (ActividadComplementaria ac : alumno.getHorario()) {
			precioAct += ac.getPrecio();
		}
		
		return precioBase + precioAct;
	}
	
// ---------------------------------------------------------------------------------------------------------------------------
	
	
// ---------------------------------------------------------------------------------------------------------------------------
	
	public double calcularDescuento (Usuario usuario, double precioFinalMatricula) {
		
		double precioConDescuento = 0.00;
		double diez = 10.00, quince = 15.00, veinte = 20.00, vienticinco = 25.00, cien = 100.00;
		
	    switch (usuario.getNumHijos()) {
		    case 0:
	        	precioConDescuento = precioFinalMatricula;
	            break;
	        case 1:
	        	precioConDescuento = precioFinalMatricula - (precioFinalMatricula * diez/cien);
	            break;
	        case 2:
	        	precioConDescuento = precioFinalMatricula - (precioFinalMatricula * quince/cien);
	            break;
	        case 3:
	        	precioConDescuento = precioFinalMatricula - (precioFinalMatricula * veinte/cien);
	            break;
	        case 4 :
	        	precioConDescuento = precioFinalMatricula - (precioFinalMatricula * vienticinco/cien);
	            break;
	        default:
	        	precioConDescuento = precioFinalMatricula - (precioFinalMatricula * vienticinco/cien);
	            break;
	    }
	    return precioConDescuento;
	}
	
// ---------------------------------------------------------------------------------------------------------------------------
	
}
