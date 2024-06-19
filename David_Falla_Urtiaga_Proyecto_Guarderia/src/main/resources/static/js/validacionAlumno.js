document.getElementById('alumnoForm').addEventListener('submit', function(event) {
    event.preventDefault();

    let error = false;

    const edad = parseInt(document.getElementById('edad').value);
    const fechaNacimiento = new Date(document.getElementById('fnac').value);
    const AnoActual = new Date().getFullYear();
    const AnoNacimiento = fechaNacimiento.getFullYear();
    const hoy = new Date();


    if (AnoNacimiento !== (AnoActual - edad)) {
        alert(`LA FECHA DE NACIMIENTO DEBE COINCIDIR CON LA EDAD INGRESADA. PARA UNA EDAD DE ${edad} AÑOS, EL AÑO DEBE SER ${AnoActual - edad}.`);
    	error = true;
    }

    if (fechaNacimiento > hoy) {
       	alert('LO SENTIMOS, EN ESTE CENTRO NO ADMITIMOS A VIAJEROS INTERDIMENSIONALES.');
       	error = true;
    }


    if(!error){
    	document.getElementById('alumnoForm').submit();
    }
        
});

