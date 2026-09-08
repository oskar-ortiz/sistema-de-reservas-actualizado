package com.mycompany.sistema.reservas.dominio.modelo;

import java.util.List;

public class SuitePresidencial extends Habitacion {
    private final List<String> amenidades;
    private final boolean servicioMayordomo;

    public SuitePresidencial(NumeroHabitacion numero, int capacidadMaxima,
            double precioPorNoche, List<String> amenidades) {
        super(numero, capacidadMaxima, precioPorNoche);
        if (amenidades == null || amenidades.isEmpty()) {
            throw new IllegalArgumentException("La suite debe tener amenidades");
        }
        this.amenidades = List.copyOf(amenidades);
        this.servicioMayordomo = true;
    }

    public SuitePresidencial(NumeroHabitacion numero, int capacidadMaxima,
            double precioPorNoche) {
        this(numero, capacidadMaxima, precioPorNoche,
                List.of("Jacuzzi", "Vista panorámica", "Sala privada"));
    }

    public List<String> getAmenidades() {
        return amenidades;
    }

    public boolean tieneServicioMayordomo() {
        return servicioMayordomo;
    }
}