package Test;

import TP1PUNTO1.*;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ConcursoTest {

    @Test
    public void testIncripcionNormal() {
        Participante participante = new Participante(4379, "Santiago", 0);

        IRepositorioInscripciones repo = new RepositorioArchivo("inscripciones.txt");

        Concurso concurso = new Concurso(
                1,
                "Concurso1",
                LocalDate.of(2025, 1, 1),
                LocalDate.of(2025, 12, 31),
                new ArrayList<>(),
                repo,
                null
        );

        concurso.inscribirParticipantes(participante, LocalDate.of(2025, 6, 15));
    }

    @Test
    public void testIncripcionPrimerDia() {
        Participante participante = new Participante(4379, "Santiago", 0);

        IRepositorioInscripciones repo = new RepositorioArchivo("inscripciones.txt");

        Concurso concurso = new Concurso(
                1,
                "Concurso1",
                LocalDate.of(2025, 1, 1),
                LocalDate.of(2025, 12, 31),
                new ArrayList<>(),
                repo,
                null
        );

        concurso.inscribirParticipantes(participante, LocalDate.of(2025, 1, 1));
        assertEquals(10, participante.getPuntos());
    }

    @Test
    public void testInscripcionFueraDeRango() {
        Participante participante = new Participante(4379, "Santiago", 0);

        IRepositorioInscripciones repo = new RepositorioArchivo("inscripciones.txt");

        Concurso concurso = new Concurso(
                1,
                "Concurso1",
                LocalDate.of(2025, 1, 1),
                LocalDate.of(2025, 12, 31),
                new ArrayList<>(),
                repo,
                null
        );

        concurso.inscribirParticipantes(participante, LocalDate.of(2026, 5, 5));
        assertEquals(0, concurso.getInscripciones().size());
    }
}