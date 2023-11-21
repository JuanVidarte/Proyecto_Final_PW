package com.proyectofinal.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import com.proyectofinal.modelo.Reservacion;

/**
 * The {@code ReservacionRepositorio} interface extends {@link JpaRepository} and provides
 * CRUD operations for the {@link Reservacion} entity. It is automatically implemented
 * by Spring Data JPA, and you can add custom query methods here if needed.
 * This interface is responsible for interacting with the database for reservation-related operations.
 *
 * @author Juan Vidarte
 * @version 1.0
 * @since 18/11/2023
 */
public interface ReservacionRepositorio extends JpaRepository<Reservacion, Long> {
    // You can add custom query methods here if needed
}