package TP4EJERCICIO3;

import java.util.List;
import java.io.IOException;
import java.sql.SQLException;

public interface ConcursoRepositoryInterface {
    List<Concurso> obtenerAbiertos() throws IOException, SQLException;
}