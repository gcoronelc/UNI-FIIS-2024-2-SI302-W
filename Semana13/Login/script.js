// script.js

document.getElementById("login-form").addEventListener("submit", function(event) {
    event.preventDefault(); // Evitar el envío del formulario

    // Obtener los valores de los campos
    const username = document.getElementById("username").value;
    const password = document.getElementById("password").value;

    // Limpiar mensajes de error previos
    document.getElementById("username-error").textContent = "";
    document.getElementById("password-error").textContent = "";

    // Validación simple
    let valid = true;

    if (username.trim() === "") {
        document.getElementById("username-error").textContent = "El nombre de usuario es obligatorio.";
        valid = false;
    }

    if (password.trim() === "") {
        document.getElementById("password-error").textContent = "La contraseña es obligatoria.";
        valid = false;
    }

    if (valid) {
        alert("¡Inicio de sesión exitoso!");
        // Aquí iría el código para enviar los datos a un servidor
        // Puedes usar AJAX o fetch para enviar la solicitud
    } else {
        alert("Por favor, complete todos los campos.");
    }
});
