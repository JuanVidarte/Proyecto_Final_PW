package com.proyectofinal.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.proyectofinal.modelo.Reservacion;
import com.proyectofinal.repositorio.ReservacionRepositorio;
import java.util.List;
import java.util.Optional;

/**
 * The {@code ReservacionServicioImpl} class implements the {@link ReservacionServicio} interface.
 * It provides the actual implementation of service methods for managing reservations.
 * This class is annotated with {@code @Service} to indicate that it is a Spring service component.
 *
 * @author Juan Vidarte
 * @version 1.0
 * @since 18/11/2023
 */
@Service
public class ReservacionServicioImpl implements ReservacionServicio {

    @Autowired
    private ReservacionRepositorio reservacionRepositorio;

    /**
     * Saves a reservation.
     *
     * @param reservacion The reservation to be saved.
     * @return The saved reservation.
     */
    @Override
    public Reservacion guardar(Reservacion reservacion) {
        return reservacionRepositorio.save(reservacion);
    }

    /**
     * Retrieves a list of all reservations.
     *
     * @return A list of all reservations.
     */
    @Override
    public List<Reservacion> listarReservaciones() {
        return reservacionRepositorio.findAll();
    }

    /**
     * Retrieves a reservation by its ID.
     *
     * @param id The ID of the reservation to be retrieved.
     * @return The reservation with the specified ID, or {@code null} if not found.
     */
    @Override
    public Reservacion obtenerReservacionPorId(Long id) {
        Optional<Reservacion> optionalReservacion = reservacionRepositorio.findById(id);
        return optionalReservacion.orElse(null);
    }

    /**
     * Deletes a reservation by its ID.
     *
     * @param id The ID of the reservation to be deleted.
     */
    @Override
    public void eliminar(Long id) {
        reservacionRepositorio.deleteById(id);
    }

    // You can implement more methods as needed
}