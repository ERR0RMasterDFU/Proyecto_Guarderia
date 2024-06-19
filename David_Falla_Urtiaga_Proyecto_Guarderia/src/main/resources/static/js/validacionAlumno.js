document.getElementById('alumnoForm').addEventListener('submit', function(event) {
    event.preventDefault();

    let error = [];

    const edad = parseInt(document.getElementById('edad').value);
    const fechaNacimiento = new Date(document.getElementById('fnac').value);
    const AnoActual = new Date().getFullYear();
    const AnoNacimiento = fechaNacimiento.getFullYear();
    const hoy = new Date();


    if (AnoNacimiento !== (AnoActual - edad)) {
        error.push(`La fecha de nacimiento debe coincidir con la edad ingresada. Para una edad de ${edad} años, el año debe ser ${AnoActual - edad}.`);
    }

    if (fechaNacimiento > hoy) {
        error.push('Lo sentimos, en este centro no admitimos a viajeros interdimiensionales.');
    }


    const alertError = document.getElementById("alertError");
    const spanError = document.getElementById("spanError");

    alertError.classList.add("d-none");                         // OCULTA EL ALERT
    spanError.innerHTML = "";

    if (error.length > 0) {error
        spanError.innerHTML = error.join("<br>");
        alertError.classList.remove("d-none");    // MUESTRA EL ALERT
    
    } else {
 
        event.target.submit();
   }
        
});

