package com.salesianostriana.dam.proyecto_guarderia.servicio.base;

import java.util.List;
import java.util.Optional;

public interface ServicioBase<T, ID>{
	
	List<T> findAll();
	
	Optional<T> findById(ID id);
	
	T save(T t);
	
	T edit(T t);
	
	void delete(T t);
	
	void deleteById(ID id);
	

}

