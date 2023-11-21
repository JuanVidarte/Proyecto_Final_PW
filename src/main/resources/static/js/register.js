// Expresión regular para validar nombre y apellido (límite de 128 caracteres alfanuméricos)
var nombreApellidoRegex = /^[a-zA-Z0-9]{1,128}$/;

// Expresión regular para validar correo electrónico
var emailRegex = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;

// Expresión regular para validar contraseña (al menos una letra mayúscula, un número y un carácter especial, y longitud mayor a 8 caracteres)
var passwordRegex = /^(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*()_+])[a-zA-Z0-9!@#$%^&*()_+]{8,}$/;

// Obtener referencias a los campos del formulario
var nombreInput = document.getElementById('nombre');
var apellidoInput = document.getElementById('apellido');
var emailInput = document.getElementById('email');
var passwordInput = document.getElementById('password');

// Función para validar el formulario
function validarFormulario() {
    if (!nombreApellidoRegex.test(nombreInput.value)) {
        alert('Por favor, ingrese un nombre válido.');
        return false;
    }

    if (!nombreApellidoRegex.test(apellidoInput.value)) {
        alert('Por favor, ingrese un apellido válido.');
        return false;
    }

    if (!emailRegex.test(emailInput.value)) {
        alert('Por favor, ingrese un correo electrónico válido.');
        return false;
    }

    if (!passwordRegex.test(passwordInput.value)) {
        alert('La contraseña debe tener al menos una letra mayúscula, un número, un carácter especial, y ser mayor a 8 caracteres.');
        return false;
    }

    // Aquí puedes enviar el formulario o realizar otras acciones si la validación es exitosa
    alert('Formulario válido. Puedes enviarlo.');

    return true;
}

// Asignar la función de validación al evento submit del formulario
var formulario = document.getElementById('formulario');
formulario.addEventListener('submit', function(event) {
    event.preventDefault(); // Evitar el envío predeterminado del formulario
    validarFormulario();
});