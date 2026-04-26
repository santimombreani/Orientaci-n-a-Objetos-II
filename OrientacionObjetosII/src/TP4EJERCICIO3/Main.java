package TP4EJERCICIO3;

import java.awt.EventQueue;

public class Main {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                ConcursoRepositoryDB concursoRepo = new ConcursoRepositoryDB();
                InscriptoRepositoryDB inscriptoRepo = new InscriptoRepositoryDB();
                ConcursoService service = new ConcursoService(concursoRepo, inscriptoRepo);
                new RadioCompetition(service);
            } catch (Exception e) {
                System.out.println(e);
            }
        });
    }
}