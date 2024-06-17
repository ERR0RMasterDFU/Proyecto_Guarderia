package com.salesianostriana.dam.proyecto_guarderia.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.proyecto_guarderia.modelo.DatosAlumno;
import com.salesianostriana.dam.proyecto_guarderia.modelo.Usuario;
import com.salesianostriana.dam.proyecto_guarderia.repositorio.DatosAlumnoRepositorio;
import com.salesianostriana.dam.proyecto_guarderia.repositorio.UsuarioRepositorio;
import com.salesianostriana.dam.proyecto_guarderia.servicio.base.ServicioBaseImpl;

@Service
public class DatosAlumnoServicio extends ServicioBaseImpl<DatosAlumno, Long, DatosAlumnoRepositorio> {

	@Autowired
	private DatosAlumnoRepositorio repositorio;
	
	public DatosAlumnoServicio(UsuarioRepositorio repo) {
		super(repo);
	}
	
	
// PANTALLA DE ALUMNOS (USUARIO) ---------------------------------------------------------------------------------------------
	
	public List<DatosAlumno> filtrarDatosPorUsuario (Usuario usuario){
		List<DatosAlumno> datosFiltrados = repositorio.findDatosByUsuario(usuario);
		return datosFiltrados;
	}
		
// ---------------------------------------------------------------------------------------------------------------------------


// MÉTODO QUE RETORNA LOS DATOS QUE TIENEN EL MISMO ID QUE UN ALUMNO ---------------------------------------------------------
	
	public DatosAlumno filtrarDatosPorIdAlumno (long id) {
		DatosAlumno datosObtenidos = repositorio.findDatosByIdAlumno(id);
		return datosObtenidos;
	}
	
// ---------------------------------------------------------------------------------------------------------------------------

	
// MÉTODO QUE CAMBIA EL VÁLIDO A ESPERA AL HABERLOS EDITADO ------------------------------------------------------------------
	
	public void CambiarEstadoDatosEditar (DatosAlumno datos) {
		
		if(datos.isValidos()) {
			datos.setValidos(false);
		}
	}
	
// ---------------------------------------------------------------------------------------------------------------------------
	
	
	
	
	
	
	
	
	
	
	
	
}
