package TP1PUNTO1;
import java.time.LocalDateTime;
public interface IRepositorioInscripciones {
    void guardarInscripcion(int idParticipante, int idConcurso, LocalDateTime fechaHora);
}
