package com.proyectofinal.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * The {@code ControladorRutas} class is a Spring MVC controller responsible for handling
 * requests related to different routes in the web application.
 * It uses the {@code @Controller} annotation to indicate that it is a Spring MVC controller.
 *
 * @author Juan Vidarte
 * @version 1.0
 * @since 18/11/2023
 */
@Controller
public class ControladorRutas {

    /**
     * Handles requests to "/nosotros" and returns the view name "nosotros".
     *
     * @return The view name "nosotros".
     */
    @GetMapping("/nosotros")
    public String VerNosotros() {
        return "nosotros";
    }

    /**
     * Handles requests to "/marser" and returns the view name "marser".
     *
     * @return The view name "marser".
     */
    @GetMapping("/marser")
    public String VerMarser() {
        return "marser";
    }

    /**
     * Handles requests to "/galeria" and returns the view name "galeria".
     *
     * @return The view name "galeria".
     */
    @GetMapping("/galeria")
    public String VerGaleria() {
        return "galeria";
    }
}