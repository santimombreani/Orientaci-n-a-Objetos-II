package TP1PUNTO1;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Concurso {
    private int id;
    private String nombre;
    private LocalDate fechaInicioInscripcion;
    private LocalDate fechaFinInscripcion;
    private List<Inscripcion> inscripciones;
    private IRepositorioInscripciones repo; // cambiamos el tipo a la interfaz
    private INotificador notificador;

    // Constructor recibe la interfaz
    public Concurso(int id, String nombre, LocalDate fechaInicioInscripcion, LocalDate fechaFinInscripcion,
                    List<Inscripcion> inscripciones, IRepositorioInscripciones repo, INotificador notificador) {
        this.id = id;
        this.nombre = nombre;
        this.fechaInicioInscripcion = fechaInicioInscripcion;
        this.fechaFinInscripcion = fechaFinInscripcion;
        this.inscripciones = inscripciones;
        this.repo = repo;
        this.notificador = notificador;
    }

    public int getId() {
        return id;
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
        try {
            // Verificamos que la fecha esté dentro del rango
            if (fecha.isBefore(fechaInicioInscripcion) || fecha.isAfter(fechaFinInscripcion)) {
                throw new IllegalArgumentException("Inscripción fuera de fecha");
            }

            // Primer día: sumar 10 puntos
            if (fecha.equals(fechaInicioInscripcion)) {
                participante.sumarPuntos(10);
            }

            // Creamos la inscripción y la agregamos a la lista
            Inscripcion inscripcion = new Inscripcion(participante, this, fecha);
            inscripciones.add(inscripcion);

            // Guardamos usando la interfaz
            repo.guardarInscripcion(participante.getId(), this.id, LocalDateTime.now());

            //Enviar notificacion por mail
            if(notificador != null){
                notificador.notificarInscripcion(participante,this);
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Error de inscripción: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error inesperado al inscribir participante: " + e.getMessage());
        }
    }
}