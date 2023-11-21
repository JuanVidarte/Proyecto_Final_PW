package com.proyectofinal.modelo;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * The {@code Usuario} class represents a user entity in the application.
 * It is annotated with {@code @Entity} to indicate that it is a JPA entity and
 * {@code @Table} to specify the database table name.
 * The class contains fields representing user information and is mapped to a database table.
 * It also includes a many-to-many relationship with the {@code Rol} entity for managing user roles.
 *
 * @author Juan Vidarte
 * @version 1.0
 * @since 18/11/2023
 */
@Entity
@Table(name = "usuarios", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    private String email;
    private String password;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "usuarios_roles",
            joinColumns = @JoinColumn(name = "usuario_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "rol_id", referencedColumnName = "id")
    )
    private Collection<Rol> roles;

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
     * Gets the roles associated with the user.
     *
     * @return The roles associated with the user.
     */
    public Collection<Rol> getRoles() {
        return roles;
    }

    /**
     * Sets the roles associated with the user.
     *
     * @param roles The roles associated with the user.
     */
    public void setRoles(Collection<Rol> roles) {
        this.roles = roles;
    }

    /**
     * Constructs a new {@code Usuario} with the specified attributes.
     *
     * @param id     The ID of the user.
     * @param nombre The first name of the user.
     * @param apellido The last name of the user.
     * @param email    The email address of the user.
     * @param password The password of the user.
     * @param roles   The roles associated with the user.
     */
    public Usuario(Long id, String nombre, String apellido, String email, String password, Collection<Rol> roles) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    /**
     * Constructs a new {@code Usuario} with the specified attributes.
     *
     * @param nombre The first name of the user.
     * @param apellido The last name of the user.
     * @param email    The email address of the user.
     * @param password The password of the user.
     * @param roles   The roles associated with the user.
     */
    public Usuario(String nombre, String apellido, String email, String password, Collection<Rol> roles) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    /**
     * Constructs a new {@code Usuario} with default attributes.
     */
    public Usuario() {

    }
}