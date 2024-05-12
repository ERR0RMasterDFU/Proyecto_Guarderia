package com.salesianostriana.dam.proyecto_guarderia.modelo;

public enum Progenitor {
	MADRE("Madre"), PADRE("Padre"), TUTORLEGAL("Tutor legal");
	
	
	private final String displayValue;

    Progenitor (String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
    
}


	