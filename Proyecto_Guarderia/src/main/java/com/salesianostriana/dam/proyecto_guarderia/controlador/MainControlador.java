package com.salesianostriana.dam.proyecto_guarderia.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainControlador {

	
	// MUESTRA LA PÁGINA DE HISTORIA -------------------------------------------------------------------------------------------------------------------------------------------
	
	@GetMapping("/")
	public String mostrarPaginaHistroria() {
		return "paginaPrincipalHistoria";
	}
		
		
	// MUESTRA LA PÁGINA DE EMPLAZAMIENTO --------------------------------------------------------------------------------------------------------------------------------------
		
	@GetMapping("/emplazamiento")
	public String mostrarPaginaEmplazamiento() {
		return "paginaPrincipalEmplazamiento";
	}
	
		
	// MUESTRA LA PÁGINA DE NORMAS Y SEGURIDAD ---------------------------------------------------------------------------------------------------------------------------------
		
	@GetMapping("/normas")
	public String mostrarPaginaNormasYSeguridad() {
		return "paginaPrincipalNormasYSeguridad";
	}
	
	
	/* 
	 
	EN REPOSITORIO -------------------------------------------------------------------------------------------------------------------
	 
	@Query("""
	SELECT p
	FROM Producto p
	WHERE p.genero = :genero)
	List<Producto> filtrarProductoPorGenero(@Param("genero") String genero);
	 
	@Query("""
	SELECT p
	FROM Producto p
	WHERE p.genero = :genero AND p.categoria = :categoria)
	List<Producto> filtrarProductoPorCategoria(@Param("genero") String genero, @Param("categoria") String categoria;
	 
	
	
	EN SERVICIO ----------------------------------------------------------------------------------------------------------------------
	 
	List <Producto> FiltrarProductoPorGenero (String genero){
		List <Producto> obtenerPorductosfiltGen = repo.filtrarProductoPorGenero;
		return obtenerPorductosfiltGen;
	}
	 
	 
	List <Producto> FiltrarProductoPorGenero (String genero, String categoria){
		List <Producto> obtenerPorductosfiltCat = repo.filtrarProductoPorCategoria;
		return obtenerPorductosfiltCat;
	}
	 
	 
	*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
