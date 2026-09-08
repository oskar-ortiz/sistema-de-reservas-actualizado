package com.mycompany.sistema.reservas.dominio.modelo;

public class HabitacionEstandar extends Habitacion {
    private final int numeroCamas;

    public HabitacionEstandar(NumeroHabitacion numero, int numeroCamas, double precioPorNoche) {
        super(numero, numeroCamas, precioPorNoche);
        if (numeroCamas < 1) {
            throw new IllegalArgumentException("El número de camas debe ser de al menos 1");
        }
        this.numeroCamas = numeroCamas;
    }

    public HabitacionEstandar(NumeroHabitacion numero, int numeroCamas) {
        this(numero, numeroCamas, 100.0);
    }

    public int getNumeroCamas() {
        return numeroCamas;
    }
}