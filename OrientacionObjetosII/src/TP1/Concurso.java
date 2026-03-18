package TP1;

import java.time.LocalDate;
import java.util.List;

public class Concurso {
    private String nombre;
    private LocalDate fechaInicioInscripcion;
    private LocalDate fechaFinInscripcion;
    private List<Inscripcion> inscripciones;

    public Concurso(String nombre, LocalDate fechaInicioInscripcion, LocalDate fechaFinInscripcion, List<Inscripcion> inscripciones) {
        this.nombre = nombre;
        this.fechaInicioInscripcion = fechaInicioInscripcion;
        this.fechaFinInscripcion = fechaFinInscripcion;
        this.inscripciones = inscripciones;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFechaInicioInscripcion() {
        return fechaInicioInscripcion;
    }

    public LocalDate getFechaFinInscripcion() {
        return fechaFinInscripcion;
    }

    public List<Inscripcion> getInscripciones() {
        return inscripciones;
    }

    public void inscribirParticipantes(Participante participante, LocalDate fecha) {
        if (fecha.isBefore(fechaInicioInscripcion) || fecha.isAfter(fechaFinInscripcion)) {//rango de fechas
            System.out.println("Inscripcion fuera de fecha");
        } else {
            if (fecha.equals(fechaInicioInscripcion)) {
                participante.sumarPuntos(10); //primer dia +10 puntos
            }
            Inscripcion inscripcion = new Inscripcion(participante, this, fecha);
            inscripciones.add(inscripcion);
        }
    }
}