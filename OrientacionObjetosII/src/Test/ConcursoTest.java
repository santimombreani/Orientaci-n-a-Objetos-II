package Test;

import TP1.Concurso;
import TP1.Participante;
import TP1.Inscripcion;
import java.time.LocalDate;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class ConcursoTest {
    @Test
    public void testIncripcionNormal(){
        //Creo Participante
        Participante participante = new Participante("Santiago",0);

        //Creo Concurso
        Concurso concurso = new Concurso(
                "Concurso1",
                LocalDate.of(2025,1,1),
                LocalDate.of(2025,12,31),
                new ArrayList<>()
        );

        //Inscribo
        concurso.inscribirParticipantes(participante,LocalDate.of(2025,6,15));

    }
    @Test
    public void testIncripcionPrimerDia(){
        //Creo participante
        Participante participante = new Participante("Santiago",0);

        //Creo Concurso
        Concurso concurso = new Concurso(
                "Concurso1",
                LocalDate.of(2025,1,1),
                LocalDate.of(2025,12,31),
                new ArrayList<>()
        );
        //Inscribo y doy 10 puntos
        concurso.inscribirParticipantes(participante,LocalDate.of(2025,1,1));
        assertEquals(10,participante.getPuntos());

        }
        @Test
        public void testInscripcionFueraDeRango(){
            //Creo participante
            Participante participante = new Participante("Santiago",0);

            //Creo Concurso
            Concurso concurso = new Concurso(
                    "Concurso1",
                    LocalDate.of(2025,1,1),
                    LocalDate.of(2025,12,31),
                    new ArrayList<>()
            );

            concurso.inscribirParticipantes(participante,LocalDate.of(2026,5,5));
            assertEquals(0, concurso.getInscripciones().size()); // verifica que el participante no se inscribio porque estaba fuera de fecha


        }

    }




