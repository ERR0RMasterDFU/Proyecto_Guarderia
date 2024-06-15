document.addEventListener("DOMContentLoaded", function() {
	
    let buttons = document.querySelectorAll('button[data-bs-toggle="modal"]');
    
    buttons.forEach(function(button) {
		
        button.addEventListener("click", function() {
			
            let id = button.getAttribute("data-id");
            
            document.getElementById('confirmarBorrado').href = '/admin/observaciones/borrarObservacion/' + id;
        });
    });
});