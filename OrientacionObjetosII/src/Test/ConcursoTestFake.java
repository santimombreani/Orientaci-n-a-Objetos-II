package Test;

import TP1PUNTO1.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class ConcursoTestFake {

    @Test
    public void testInscripcionPrimerDiaConFakes() {
        // Crear participante
        Participante participante = new Participante(1, "Santiago", 0);

        // Crear fakes
        FakeRepositorio repo = new FakeRepositorio();
        FakeNotificador notificador = new FakeNotificador();

        // Crear concurso usando los fakes
        Concurso concurso = new Concurso(
                1,
                "Concurso1",
                LocalDate.of(2025, 1, 1),
                LocalDate.of(2025, 12, 31),
                new ArrayList<>(),
                repo,
                notificador
        );

        // Inscribir participante
        concurso.inscribirParticipantes(participante, LocalDate.of(2025, 1, 1));


        // Verificar lógica de negocio

        assertEquals(10, participante.getPuntos(), "Primer día suma 10 puntos");
        assertEquals(1, concurso.getInscripciones().size(), "Debe agregarse la inscripción");


        // Verificar efectos técnicos simulados

        assertEquals(1, repo.guardados.size(), "Debe registrarse en el repositorio fake");
        assertEquals("1-1", repo.guardados.get(0), "ID de inscripción correcto en repositorio fake");

        assertEquals(1, notificador.enviados.size(), "Debe enviarse notificación fake");
        assertEquals("Santiago", notificador.enviados.get(0), "Nombre correcto en notificador fake");

    }


    @Test
    public void testInscripcionFueraDeRangoConFake() {
        Participante participante = new Participante(1, "Santiago", 0);

        FakeRepositorio repo = new FakeRepositorio();
        FakeNotificador notificador = new FakeNotificador();

        Concurso concurso = new Concurso(
                1,
                "Concurso1",
                LocalDate.of(2025, 1, 1),
                LocalDate.of(2025, 12, 31),
                new ArrayList<>(),
                repo,
                notificador
        );

        concurso.inscribirParticipantes(participante, LocalDate.of(2026, 5, 5));

        assertEquals(0, concurso.getInscripciones().size());
        assertEquals(0, repo.guardados.size());
        assertEquals(0, notificador.enviados.size());
    }

}