package com.proyectofinal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The {@code RegistroUsuariosSpringSecurityApplication} class is the main entry point for the
 * Spring Boot application responsible for user registration and Spring Security configuration.
 * This class uses the {@code SpringApplication} to bootstrap the application.
 *
 * @author Juan Vidarte
 * @version 1.0
 * @since 18/11/2023
 */
@SpringBootApplication
public class RegistroUsuariosSpringSecurityApplication {

    /**
     * The main method that starts the Spring Boot application.
     *
     * @param args Command line arguments passed to the application (not used in this implementation).
     */
    public static void main(String[] args) {
        SpringApplication.run(RegistroUsuariosSpringSecurityApplication.class, args);
    }
}