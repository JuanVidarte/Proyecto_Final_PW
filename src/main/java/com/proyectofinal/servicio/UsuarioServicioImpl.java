package com.proyectofinal.servicio;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.proyectofinal.controlador.dto.UsuarioRegistroDTO;
import com.proyectofinal.modelo.Rol;
import com.proyectofinal.modelo.Usuario;
import com.proyectofinal.repositorio.UsuarioRepositorio;

/**
 * The {@code UsuarioServicioImpl} class implements the {@link UsuarioServicio} interface.
 * It provides the actual implementation of service methods for managing users, user registration,
 * and Spring Security user details retrieval.
 * This class is annotated with {@code @Service} to indicate that it is a Spring service component.
 *
 * @author Juan Vidarte
 * @version 1.0
 * @since 18/11/2023
 */
@Service
public class UsuarioServicioImpl implements UsuarioServicio {

    private final UsuarioRepositorio usuarioRepositorio;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public UsuarioServicioImpl(UsuarioRepositorio usuarioRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
    }

    /**
     * Saves a user based on the provided registration DTO.
     *
     * @param registroDTO The registration DTO containing user information.
     * @return The saved user.
     */
    @Override
    public Usuario guardar(UsuarioRegistroDTO registroDTO) {
        Usuario usuario = new Usuario(registroDTO.getNombre(),
                registroDTO.getApellido(), registroDTO.getEmail(),
                passwordEncoder.encode(registroDTO.getPassword()), Arrays.asList(new Rol("ROLE_USER")));
        return usuarioRepositorio.save(usuario);
    }

    /**
     * Loads user details by username for Spring Security authentication.
     *
     * @param username The username of the user to be loaded.
     * @return UserDetails for the specified user.
     * @throws UsernameNotFoundException If the user is not found.
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepositorio.findByEmail(username);
        if (usuario == null) {
            throw new UsernameNotFoundException("Usuario o password inválidos");
        }
        return new User(usuario.getEmail(), usuario.getPassword(), mapearAutoridadesRoles(usuario.getRoles()));
    }

    /**
     * Maps authorities from user roles.
     *
     * @param roles The roles associated with the user.
     * @return A collection of authorities.
     */
    private Collection<? extends GrantedAuthority> mapearAutoridadesRoles(Collection<Rol> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getNombre())).collect(Collectors.toList());
    }

    /**
     * Retrieves a list of all users.
     *
     * @return A list of all users.
     */
    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioRepositorio.findAll();
    }
}

