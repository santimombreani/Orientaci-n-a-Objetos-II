package TP1;

import java.time.LocalDate;

public class Inscripcion {
    private Participante participante;
    private Concurso concurso;
    private LocalDate fechaInscripcion;

    public Inscripcion(Participante participante, Concurso concurso, LocalDate fechaInscripcion) {
        this.participante = participante;
        this.concurso = concurso;
        this.fechaInscripcion = fechaInscripcion;
    }

    public Participante getParticipante() {
        return participante;
    }

    public Concurso getConcurso() {
        return concurso;
    }

    public LocalDate getFechaInscripcion() {
        return fechaInscripcion;
    }
}

