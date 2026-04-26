package TP4EJERCICIO3;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ConcursoService {
    private ConcursoRepositoryInterface concursoRepo;
    private InscriptoRepositoryInterface inscriptoRepo;

    public ConcursoService(ConcursoRepositoryInterface concursoRepo, InscriptoRepositoryInterface inscriptoRepo) {
        this.concursoRepo = concursoRepo;
        this.inscriptoRepo = inscriptoRepo;
    }

    public List<Concurso> obtenerConcursosAbiertos() throws IOException, SQLException {
        return concursoRepo.obtenerAbiertos();
    }

    public void inscribir(String nombre, String apellido, String telefono,
                          String email, int idConcurso) throws IOException, SQLException {
        Inscripto inscripto = new Inscripto(nombre, apellido, telefono, email, idConcurso);
        inscriptoRepo.guardar(inscripto);
    }
}