package com.proyectofinal.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.proyectofinal.modelo.Usuario;

/**
 * The {@code UsuarioRepositorio} interface extends {@link JpaRepository} and provides
 * CRUD operations for the {@link Usuario} entity. It is automatically implemented
 * by Spring Data JPA, and you can add custom query methods here if needed.
 * This interface is responsible for interacting with the database for user-related operations.
 * The {@code findByEmail} method is a custom query method to find a user by email.
 *
 * @author Juan Vidarte
 * @version 1.0
 * @since 18/11/2023
 */
@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {

    /**
     * Finds a user by email.
     *
     * @param email The email address of the user to be found.
     * @return The user with the specified email address, or {@code null} if not found.
     */
    public Usuario findByEmail(String email);
}