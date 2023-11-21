package com.proyectofinal.controlador.dto;

/**
 * The {@code UsuarioRegistroDTO} class represents a data transfer object (DTO) for user registration.
 * It encapsulates the data required for registering a new user.
 * This class is often used to transfer data between the controller and service layers.
 *
 * @author Juan Vidarte
 * @version 1.0
 * @since 18/11/2023
 */
public class UsuarioRegistroDTO {

    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private String password;

    /**
     * Gets the ID of the user.
     *
     * @return The ID of the user.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the ID of the user.
     *
     * @param id The ID of the user.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the first name of the user.
     *
     * @return The first name of the user.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Sets the first name of the user.
     *
     * @param nombre The first name of the user.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Gets the last name of the user.
     *
     * @return The last name of the user.
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Sets the last name of the user.
     *
     * @param apellido The last name of the user.
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * Gets the email address of the user.
     *
     * @return The email address of the user.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email address of the user.
     *
     * @param email The email address of the user.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the password of the user.
     *
     * @return The password of the user.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password of the user.
     *
     * @param password The password of the user.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Constructs a new {@code UsuarioRegistroDTO} with the specified attributes.
     *
     * @param nombre   The first name of the user.
     * @param apellido The last name of the user.
     * @param email    The email address of the user.
     * @param password The password of the user.
     */
    public UsuarioRegistroDTO(String nombre, String apellido, String email, String password) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
    }

    /**
     * Constructs a new {@code UsuarioRegistroDTO} with default attributes.
     */
    public UsuarioRegistroDTO() {
    }
}