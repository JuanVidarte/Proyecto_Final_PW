const navToggle = document.querySelector(".nav-toggle");
const navMenu = document.querySelector(".nav-menu");

navToggle.addEventListener("click", () => {
  navMenu.classList.toggle("nav-menu_visible");

  if (navMenu.classList.contains("nav-menu_visible")) {
    navToggle.setAttribute("aria-label", "Cerrar menú");
  } else {
    navToggle.setAttribute("aria-label", "Abrir menú");
  }
});

// Obtener la fecha actual
const currentDate = new Date();
const options = { year: 'numeric', month: 'long', day: 'numeric'};
const formattedDate = currentDate.toLocaleDateString('es-ES', options);

// Mostrar la fecha en el footer
document.getElementById('current-date').textContent = ` ${formattedDate}`;

