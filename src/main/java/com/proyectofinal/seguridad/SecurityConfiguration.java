package com.proyectofinal.seguridad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.proyectofinal.servicio.UsuarioServicio;

/**
 * The {@code SecurityConfiguration} class configures Spring Security for the application.
 * It extends {@link WebSecurityConfigurerAdapter} to provide custom security configurations.
 * It includes configuration for user authentication, authorization, and login/logout handling.
 * This class is annotated with {@code @Configuration} and {@code @EnableWebSecurity}.
 *
 * @author Juan Vidarte
 * @version 1.0
 * @since 18/11/2023
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private UsuarioServicio usuarioServicio;

    /**
     * Configures a BCrypt password encoder bean.
     *
     * @return The BCrypt password encoder.
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Configures a DaoAuthenticationProvider bean.
     *
     * @return The DaoAuthenticationProvider.
     */
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(usuarioServicio);
        auth.setPasswordEncoder(passwordEncoder());
        return auth;
    }

    /**
     * Configures authentication with the provided authentication provider.
     *
     * @param auth The AuthenticationManagerBuilder.
     * @throws Exception If an error occurs during configuration.
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    /**
     * Configures HTTP security for the application.
     *
     * @param http The HttpSecurity.
     * @throws Exception If an error occurs during configuration.
     */
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests(requests -> requests.antMatchers("/js/", "/css/", "/assets/")
                        .permitAll()
                        .antMatchers("/reservaciones**").access("hasRole('USER')")
                        .anyRequest().permitAll())
                .formLogin(login -> login
                        .loginPage("/login")
                        .permitAll())
                .logout(logout -> logout
                        .invalidateHttpSession(true)
                        .clearAuthentication(true)
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                        .logoutSuccessUrl("/login?logout")
                        .permitAll());
    }
}