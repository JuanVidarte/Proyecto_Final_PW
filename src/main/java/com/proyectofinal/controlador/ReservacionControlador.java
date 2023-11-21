package com.proyectofinal.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proyectofinal.modelo.Reservacion;
import com.proyectofinal.servicio.ReservacionServicio;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

/**
 * The {@code ReservacionControlador} class is a Spring MVC controller responsible for handling
 * requests related to reservations in the web application.
 * It uses the {@code @Controller} annotation to indicate that it is a Spring MVC controller.
 *
 * @author Juan Vidarte
 * @version 1.0
 * @since 18/11/2023
 */
@Controller
@RequestMapping("/reservaciones")
public class ReservacionControlador {

    /**
     * The {@code ReservacionServicio} used for reservation-related operations.
     */
    @Autowired
    private ReservacionServicio reservacionServicio;

    /**
     * Handles GET requests to "/reservaciones" and returns the view name "reservaciones/lista"
     * with a model containing the list of reservations and the differences in days between
     * reservation start and end dates.
     *
     * @param modelo The {@code Model} used to add attributes for rendering the view.
     * @return The view name "reservaciones/lista".
     */
    @GetMapping
    public String listarReservaciones(Model modelo) {
        List<Reservacion> reservaciones = reservacionServicio.listarReservaciones();
        List<Long> diferenciasDeDias = new ArrayList<>();

        for (Reservacion reservacion : reservaciones) {
            long dias = ChronoUnit.DAYS.between(reservacion.getFechaHoraInicio(), reservacion.getFechaHoraSalida());
            diferenciasDeDias.add(dias);
        }

        modelo.addAttribute("reservaciones", reservaciones);
        modelo.addAttribute("diferenciasDeDias", diferenciasDeDias);

        return "reservaciones/lista";
    }

    /**
     * Handles GET requests to "/reservaciones/crear" and returns the view name "reservaciones/formulario"
     * with a model containing a new {@code Reservacion} object for creating a reservation.
     *
     * @param modelo The {@code Model} used to add attributes for rendering the view.
     * @return The view name "reservaciones/formulario".
     */
    @GetMapping("/crear")
    public String mostrarFormularioReservacion(Model modelo) {
        modelo.addAttribute("reservacion", new Reservacion());
        return "reservaciones/formulario";
    }

    /**
     * Handles POST requests to "/reservaciones/crear" for submitting reservation data.
     * Redirects to "/reservaciones" after successful reservation creation.
     *
     * @param reservacion The {@code Reservacion} containing reservation data.
     * @return A redirect to "/reservaciones" after successful reservation creation.
     */
    @PostMapping("/crear")
    public String crearReservacion(@ModelAttribute("reservacion") Reservacion reservacion) {
        reservacionServicio.guardar(reservacion);
        return "redirect:/reservaciones";
    }

    /**
     * Handles GET requests to "/reservaciones/eliminar/{id}" for deleting a reservation by ID.
     * Redirects to "/reservaciones" after successful reservation deletion.
     *
     * @param id The ID of the reservation to be deleted.
     * @return A redirect to "/reservaciones" after successful reservation deletion.
     */
    @GetMapping("/eliminar/{id}")
    public String eliminarReservacion(@PathVariable Long id) {
        reservacionServicio.eliminar(id);
        return "redirect:/reservaciones";
    }
}
