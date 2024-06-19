document.getElementById("profesorForm").addEventListener("submit", function(event) {
    event.preventDefault();
    
    let error = false;

// VALIDACIÓN DEL TELÉFONO ---------------------------------------------------------------------------------------------------------------------------------------

    const telefono = document.getElementById("numTelefono").value;
    const telefonoRegex = /^[0-9]{9}$/;

    if (!telefonoRegex.test(telefono)) {
        alert("EL TELÉFONO DEBE CONTENER 9 DÍGITOS SIN ESPACIOS, GUIONES NI EL PREFIJO +34.");
        error=true;
    }

//----------------------------------------------------------------------------------------------------------------------------------------------------------------


// VALIDACIÓN DEL DNI / NIE --------------------------------------------------------------------------------------------------------------------------------------

    const dniNie = document.getElementById("dniNie").value;

    if (!dniValido(dniNie) && !nieValido(dniNie)) {
        alert("El DNI O NIE NO ES VÁLIDO.");
        error = true;
    }

//----------------------------------------------------------------------------------------------------------------------------------------------------------------


// ALERT QUE MUESTRA ERRORES -------------------------------------------------------------------------------------------------------------------------------------

    if(!error){
    	document.getElementById('profesorForm').submit();
    }

//----------------------------------------------------------------------------------------------------------------------------------------------------------------
    
});


// MÉTODO QUE VALIDA EL DNI --------------------------------------------------------------------------------------------------------------------------------------

function dniValido(dni) {

    const dniRegex = /^[0-9]{8}[A-Z]$/;

    if (!dniRegex.test(dni)) {
        return false;
    }

    const letras = "TRWAGMYFPDXBNJZSQVHLCKE";
    const numero = dni.substr(0, 8);
    const letra = dni.substr(8, 1);

    return letras.charAt(numero % 23) === letra;
}

//----------------------------------------------------------------------------------------------------------------------------------------------------------------


// MÉTODO QUE VALIDA EL NIE --------------------------------------------------------------------------------------------------------------------------------------

function nieValido(nie) {

    const nieRegex = /^[XYZ][0-9]{7}[A-Z]$/;

    if (!nieRegex.test(nie)) {
        return false;
    }

    let nieNumero = nie.substr(1, 7);

    switch (nie.charAt(0)) {
        case 'X': nieNumero = '0' + nieNumero; break;
        case 'Y': nieNumero = '1' + nieNumero; break;
        case 'Z': nieNumero = '2' + nieNumero; break;
    }

    const letras = "TRWAGMYFPDXBNJZSQVHLCKE";
    const letra = nie.substr(8, 1);

    return letras.charAt(nieNumero % 23) === letra;
}

//----------------------------------------------------------------------------------------------------------------------------------------------------------------