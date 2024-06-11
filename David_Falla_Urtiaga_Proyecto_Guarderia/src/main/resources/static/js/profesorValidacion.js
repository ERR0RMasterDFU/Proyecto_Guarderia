document.getElementById("profesorForm").addEventListener("submit", function(event) {
    event.preventDefault();
    
    let error = [];

// VALIDACIÓN DEL TELÉFONO ---------------------------------------------------------------------------------------------------------------------------------------

    const telefono = document.getElementById("numTelefono").value;
    const telefonoRegex = /^[0-9]{9}$/;

    if (!telefonoRegex.test(telefono)) {
        error.push("El teléfono debe contener 9 dígitos sin espacios, guiones ni el prefijo +34.");
    }

//----------------------------------------------------------------------------------------------------------------------------------------------------------------


// VALIDACIÓN DEL DNI / NIE --------------------------------------------------------------------------------------------------------------------------------------

    const dniNie = document.getElementById("dniNie").value;

    if (!dniValido(dniNie) && !nieValido(dniNie)) {
        error.push("El DNI o NIE no es válido.");
    }

//----------------------------------------------------------------------------------------------------------------------------------------------------------------


// ALERT QUE MUESTRA ERRORES -------------------------------------------------------------------------------------------------------------------------------------

    const alertError = document.getElementById("alertError");
    const spanError = document.getElementById("spanError");

    alertError.classList.add("d-none");                         // OCULTA EL ALERT
    spanError.innerHTML = "";

    if (error.length > 0) {error
        spanError.innerHTML = error.join("<br>");
        alertError.classList.remove("d-none");                  // MUESTRA EL ALERT
    } else {
        
        // Mostrar modal de confirmación

        const modalConfirmacion = new bootstrap.Modal(document.getElementById('modalConfirmacion'), {});
        modalConfirmacion.show();

        // Cierra el modal después de 2 segundos

        setTimeout(() => {
            modalConfirmacion.hide();
        }, 2000);

        event.target.submit();
        
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