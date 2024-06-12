const contrasena = document.getElementById('password');
const ojoContrasena = document.getElementById('ojo');

ojoContrasena.addEventListener('click', () => {

    if (contrasena.type === 'password') {

        contrasena.type = 'text';
        ojoContrasena.classList.remove('bi-eye-fill');
        ojoContrasena.classList.add('bi-eye-slash-fill');

    } else {

        contrasena.type = 'password';
        ojoContrasena.classList.remove('bi-eye-slash-fill');
        ojoContrasena.classList.add('bi-eye-fill');
        
    }
});