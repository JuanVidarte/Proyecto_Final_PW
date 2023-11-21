package com.proyectofinal.servicio;

import java.util.List;
import org.springframework.security.core.userdetails.UserDetailsService;
import com.proyectofinal.controlador.dto.UsuarioRegistroDTO;
import com.proyectofinal.modelo.Usuario;

/**
 * The {@code UsuarioServicio} interface extends {@link UserDetailsService} and provides
 * service methods for managing user-related operations.
 * It declares methods for saving, listing, and retrieving users, and extends
 * {@code UserDetailsService} to support Spring Security user details retrieval.
 *
 * @author Juan Vidarte
 * @version 1.0
 * @since 18/11/2023
 */
public interface UsuarioServicio extends UserDetailsService {

    /**
     * Saves a user based on the provided registration DTO.
     *
     * @param registroDTO The registration DTO containing user information.
     * @return The saved user.
     */
    Usuario guardar(UsuarioRegistroDTO registroDTO);

    /**
     * Retrieves a list of all users.
     *
     * @return A list of all users.
     */
    List<Usuario> listarUsuarios();
}