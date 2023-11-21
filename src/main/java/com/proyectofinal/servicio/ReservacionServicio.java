package com.proyectofinal.servicio;

import java.util.List;
import com.proyectofinal.modelo.Reservacion;

/**
 * The {@code ReservacionServicio} interface defines service methods for managing reservations.
 * It declares methods for saving, listing, retrieving, and deleting reservations.
 * This interface provides a contract for implementing reservation-related business logic.
 *
 * @author Juan Vidarte
 * @version 1.0
 * @since 18/11/2023
 */
public interface ReservacionServicio {

    /**
     * Saves a reservation.
     *
     * @param reservacion The reservation to be saved.
     * @return The saved reservation.
     */
    Reservacion guardar(Reservacion reservacion);

    /**
     * Retrieves a list of all reservations.
     *
     * @return A list of all reservations.
     */
    List<Reservacion> listarReservaciones();

    /**
     * Retrieves a reservation by its ID.
     *
     * @param id The ID of the reservation to be retrieved.
     * @return The reservation with the specified ID, or {@code null} if not found.
     */
    Reservacion obtenerReservacionPorId(Long id);

    /**
     * Deletes a reservation by its ID.
     *
     * @param id The ID of the reservation to be deleted.
     */
    void eliminar(Long id);

    // You can add more methods as needed
}