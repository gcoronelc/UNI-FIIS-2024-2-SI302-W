// script.js

// Función para obtener los datos de la API
async function fetchUserData() {
    try {
        // Realizamos una petición GET a la API de usuarios
        const response = await fetch('https://jsonplaceholder.typicode.com/users');
        
        if (!response.ok) {
            throw new Error('Error al obtener los datos');
        }

        // Convertimos la respuesta en formato JSON
        const users = await response.json();

        // Llamamos a la función para mostrar los datos en la tabla
        displayUserData(users);
    } catch (error) {
        console.error('Error:', error);
    }
}

// Función para mostrar los datos en la tabla
function displayUserData(users) {
    const tableBody = document.querySelector('#users-table tbody');

    // Limpiamos cualquier dato previo
    tableBody.innerHTML = '';

    // Iteramos sobre los usuarios y agregamos una fila por cada uno
    users.forEach(user => {
        const row = document.createElement('tr');
        
        // Agregamos celdas con los datos del usuario
        row.innerHTML = `
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.email}</td>
            <td>${user.address.city}</td>
        `;
        
        // Agregamos la fila a la tabla
        tableBody.appendChild(row);
    });
}

// Llamamos a la función para obtener y mostrar los datos cuando cargue la página
document.addEventListener('DOMContentLoaded', fetchUserData);
