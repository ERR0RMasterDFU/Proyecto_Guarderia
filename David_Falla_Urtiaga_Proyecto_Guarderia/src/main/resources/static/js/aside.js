document.addEventListener('DOMContentLoaded', function() {
    const aside = document.getElementById('aside');
    const main = document.querySelector('main');

    function updateAsideScrollbar() {
        const mainHeight = main.clientHeight;
        const asideHeight = aside.scrollHeight;
        
        if (mainHeight < asideHeight) {
            aside.classList.remove('hidden-scrollbar');
        } else {
            aside.classList.add('hidden-scrollbar');
        }
    }

    // Actualiza al cargar la página
    updateAsideScrollbar();

    // Actualiza cuando se cambia el tamaño de la ventana
    window.addEventListener('resize', updateAsideScrollbar);
});
