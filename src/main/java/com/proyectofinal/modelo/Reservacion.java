package com.proyectofinal.modelo;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The {@code Reservacion} class represents a reservation entity in the application.
 * It is annotated with {@code @Entity} to indicate that it is a JPA entity and
 * {@code @Table} to specify the database table name.
 * The class contains fields representing reservation information and is mapped to a database table.
 *
 * @author Juan Vidarte
 * @version 1.0
 * @since 18/11/2023
 */
@Entity
@Table(name = "reservaciones")
public class Reservacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tipo_reservacion")
    private String tipoReservacion;

    @Column(name = "fecha_hora_inicio")
    private LocalDateTime fechaHoraInicio;

    @Column(name = "fecha_hora_salida")
    private LocalDateTime fechaHoraSalida;

    @Column(name = "noches")
    private Integer noches;

    /**
     * Gets the ID of the reservation.
     *
     * @return The ID of the reservation.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the ID of the reservation.
     *
     * @param id The ID of the reservation.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the type of reservation.
     *
     * @return The type of reservation.
     */
    public String getTipoReservacion() {
        return tipoReservacion;
    }

    /**
     * Sets the type of reservation.
     *
     * @param tipoReservacion The type of reservation.
     */
    public void setTipoReservacion(String tipoReservacion) {
        this.tipoReservacion = tipoReservacion;
    }

    /**
     * Gets the start date and time of the reservation.
     *
     * @return The start date and time of the reservation.
     */
    public LocalDateTime getFechaHoraInicio() {
        return fechaHoraInicio;
    }

    /**
     * Sets the start date and time of the reservation.
     *
     * @param fechaHoraInicio The start date and time of the reservation.
     */
    public void setFechaHoraInicio(LocalDateTime fechaHoraInicio) {
        this.fechaHoraInicio = fechaHoraInicio;
    }

    /**
     * Gets the end date and time of the reservation.
     *
     * @return The end date and time of the reservation.
     */
    public LocalDateTime getFechaHoraSalida() {
        return fechaHoraSalida;
    }

    /**
     * Sets the end date and time of the reservation.
     *
     * @param fechaHoraSalida The end date and time of the reservation.
     */
    public void setFechaHoraSalida(LocalDateTime fechaHoraSalida) {
        this.fechaHoraSalida = fechaHoraSalida;
    }

    /**
     * Gets the number of nights for the reservation.
     *
     * @return The number of nights for the reservation.
     */
    public Integer getNoches() {
        return noches;
    }

    /**
     * Sets the number of nights for the reservation.
     *
     * @param noches The number of nights for the reservation.
     */
    public void setNoches(Integer noches) {
        this.noches = noches;
    }
}