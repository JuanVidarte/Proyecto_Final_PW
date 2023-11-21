package com.proyectofinal.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The {@code Rol} class represents a role entity in the application.
 * It is annotated with {@code @Entity} to indicate that it is a JPA entity and
 * {@code @Table} to specify the database table name.
 * The class contains fields representing role information and is mapped to a database table.
 *
 * @author Juan Vidarte
 * @version 1.0
 * @since 18/11/2023
 */
@Entity
@Table(name = "rol")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    /**
     * Gets the ID of the role.
     *
     * @return The ID of the role.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the ID of the role.
     *
     * @param id The ID of the role.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the name of the role.
     *
     * @return The name of the role.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Sets the name of the role.
     *
     * @param nombre The name of the role.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Constructs a new {@code Rol} with the specified ID and name.
     *
     * @param id     The ID of the role.
     * @param nombre The name of the role.
     */
    public Rol(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    /**
     * Constructs a new {@code Rol} with default attributes.
     */
    public Rol() {

    }

    /**
     * Constructs a new {@code Rol} with the specified name.
     *
     * @param nombre The name of the role.
     */
    public Rol(String nombre) {
        this.nombre = nombre;
    }
}