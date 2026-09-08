/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistema.reservas.dominio.modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author daferarte
 */
public abstract class Habitacion {
    private final UUID id;
    private final NumeroHabitacion numero;
    private final int capacidadMaxima;
    private final double precioPorNoche;
    private EstadoHabitacion estado;
    private final List<Reserva> historialReservas;

    public Habitacion(NumeroHabitacion numero, int capacidadMaxima, double precioPorNoche) {
        if (numero == null) {
            throw new IllegalArgumentException("El número de habitación es obligatorio");
        }
        if (capacidadMaxima < 1) {
            throw new IllegalArgumentException("La capacidad máxima debe ser de al menos 1 persona");
        }
        if (precioPorNoche < 0) {
            throw new IllegalArgumentException("El precio por noche no puede ser negativo");
        }
        this.id = UUID.randomUUID();
        this.numero = numero;
        this.capacidadMaxima = capacidadMaxima;
        this.precioPorNoche = precioPorNoche;
        this.estado = EstadoHabitacion.DISPONIBLE;
        this.historialReservas = new ArrayList<>();
    }

    public void marcarEnMantenimiento() {
        this.estado = EstadoHabitacion.MANTENIMIENTO;
    }

    public void habilitar() {
        this.estado = EstadoHabitacion.DISPONIBLE;
    }

    public void asignarAReserva() {
        if (this.estado == EstadoHabitacion.MANTENIMIENTO) {
            throw new IllegalStateException("No se puede asignar una habitación en mantenimiento");
        }
        this.estado = EstadoHabitacion.OCUPADA;
    }

    public void registrarReserva(Reserva reserva) {
        if (reserva == null) {
            throw new IllegalArgumentException("La reserva es obligatoria");
        }
        if (reserva.getHabitacion() != this) {
            throw new IllegalArgumentException("La reserva no pertenece a esta habitación");
        }
        if (!historialReservas.contains(reserva)) {
            historialReservas.add(reserva);
        }
    }

    public UUID getId() { return id; }
    public NumeroHabitacion getNumero() { return numero; }
    public int getCapacidadMaxima() { return capacidadMaxima; }
    public double getPrecioPorNoche() { return precioPorNoche; }
    public EstadoHabitacion getEstado() { return estado; }
    public List<Reserva> getHistorialReservas() {
        return Collections.unmodifiableList(historialReservas);
    }
}
