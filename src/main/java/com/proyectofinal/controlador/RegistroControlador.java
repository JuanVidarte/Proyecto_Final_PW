package com.proyectofinal.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.proyectofinal.servicio.UsuarioServicio;

/**
 * The {@code RegistroControlador} class is a Spring MVC controller responsible for handling
 * requests related to user registration and login functionality in the web application.
 * It uses the {@code @Controller} annotation to indicate that it is a Spring MVC controller.
 *
 * @author Juan Vidarte
 * @version 1.0
 * @since 18/11/2023
 */
@Controller
public class RegistroControlador {

    /**
     * The {@code UsuarioServicio} used for user-related operations.
     */
    @Autowired
    private UsuarioServicio servicio;

    /**
     * Handles requests to "/login" and returns the view name "login".
     *
     * @return The view name "login".
     */
    @GetMapping("/login")
    public String iniciarSesion() {
        return "login";
    }

    /**
     * Handles requests to "/" (root) and returns the view name "index" with a model attribute
     * containing the list of users obtained from the {@code UsuarioServicio}.
     *
     * @param modelo The {@code Model} used to add attributes for rendering the view.
     * @return The view name "index".
     */
    @GetMapping("/")
    public String verPaginaDeInicio(Model modelo) {
        // Add the list of users as an attribute to the model.
        modelo.addAttribute("usuarios", servicio.listarUsuarios());
        return "index";
    }
}