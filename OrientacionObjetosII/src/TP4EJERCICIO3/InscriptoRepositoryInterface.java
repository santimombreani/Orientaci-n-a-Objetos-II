package TP4EJERCICIO3;

import java.io.IOException;
import java.sql.SQLException;

public interface InscriptoRepositoryInterface {
    void guardar(Inscripto inscripto) throws IOException, SQLException;
}