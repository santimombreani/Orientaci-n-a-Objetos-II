package TP1PUNTO1;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class FakeRepositorio implements IRepositorioInscripciones {
    public List<String> guardados = new ArrayList<>(); // Lista para simular el guardado

    @Override
    public void guardarInscripcion(int idParticipante, int idConcurso, LocalDateTime fechaHora) {
        // Guardamos en memoria en lugar de archivo
        guardados.add(idParticipante + "-" + idConcurso);
        System.out.println("FakeRepositorio guardó: " + idParticipante + "-" + idConcurso);
    }
}