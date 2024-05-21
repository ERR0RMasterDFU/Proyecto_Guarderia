package com.salesianostriana.dam.proyecto_guarderia.modelo;

public enum Progenitor {
	MADRE("Madre"), PADRE("Padre"), TUTORLEGAL("Tutor legal");
	
	
	private final String tipoProgenitor;

    private Progenitor (String tipoProgenitor) {
        this.tipoProgenitor = tipoProgenitor;
    }

    public String getTipoProgenitor() {
        return tipoProgenitor;
    }
    
}


	