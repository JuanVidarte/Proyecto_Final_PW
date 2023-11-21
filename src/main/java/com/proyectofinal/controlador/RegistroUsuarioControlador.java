package com.proyectofinal.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proyectofinal.controlador.dto.UsuarioRegistroDTO;
import com.proyectofinal.servicio.UsuarioServicio;

/**
 * The {@code RegistroUsuarioControlador} class is a Spring MVC controller responsible for handling
 * requests related to user registration in the web application.
 * It uses the {@code @Controller} annotation to indicate that it is a Spring MVC controller.
 *
 * @author Juan Vidarte
 * @version 1.0
 * @since 18/11/2023
 */
@Controller
@RequestMapping("/registro")
public class RegistroUsuarioControlador {

    /**
     * The {@code UsuarioServicio} used for user-related operations.
     */
    private UsuarioServicio usuarioServicio;

    /**
     * Constructs a new {@code RegistroUsuarioControlador} with the specified {@code UsuarioServicio}.
     *
     * @param usuarioServicio The {@code UsuarioServicio} to be used for user-related operations.
     */
    public RegistroUsuarioControlador(UsuarioServicio usuarioServicio) {
        this.usuarioServicio = usuarioServicio;
    }

    /**
     * Adds a model attribute named "usuario" of type {@code UsuarioRegistroDTO}.
     *
     * @return A new instance of {@code UsuarioRegistroDTO}.
     */
    @ModelAttribute("usuario")
    public UsuarioRegistroDTO retornarNuevoUsuarioRegistroDTO() {
        return new UsuarioRegistroDTO();
    }

    /**
     * Handles GET requests to "/registro" and returns the view name "registro" for displaying
     * the user registration form.
     *
     * @return The view name "registro".
     */
    @GetMapping
    public String mostrarFormularioDeRegistro() {
        return "registro";
    }

    /**
     * Handles POST requests to "/registro" for submitting user registration data.
     * Redirects to "/registro?exito" after successful registration.
     *
     * @param registroDTO The {@code UsuarioRegistroDTO} containing user registration data.
     * @return A redirect to "/registro?exito" after successful registration.
     */
    @PostMapping
    public String registrarCuentaDeUsuario(@ModelAttribute("usuario") UsuarioRegistroDTO registroDTO) {
        usuarioServicio.guardar(registroDTO);
        return "redirect:/registro?exito";
    }
}