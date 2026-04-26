package TP4EJERCICIO3;

import java.time.LocalDate;

public class Concurso {
    private int id;
    private String nombre;
    private LocalDate fechaInicioInscripcion;
    private LocalDate fechaFinInscripcion;

    public Concurso(int id, String nombre, LocalDate fechaInicio, LocalDate fechaFin) {
        this.id = id;
        this.nombre = nombre;
        this.fechaInicioInscripcion = fechaInicio;
        this.fechaFinInscripcion = fechaFin;
    }

    public boolean inscripcionAbierta() {
        LocalDate hoy = LocalDate.now();
        return !hoy.isBefore(fechaInicioInscripcion) && !hoy.isAfter(fechaFinInscripcion);
    }

    public int getId() { return id; }

    public String getNombre() { return nombre; }
}