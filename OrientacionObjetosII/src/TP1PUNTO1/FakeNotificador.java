package TP1PUNTO1;

import java.util.ArrayList;
import java.util.List;

public class FakeNotificador implements INotificador {
    public List<String> enviados = new ArrayList<>();

    @Override
    public void notificarInscripcion(Participante participante, Concurso concurso) {
        enviados.add(participante.getNombre()); // solo nombre
        System.out.println("FakeNotificador envió: " + participante.getNombre());
    }
}