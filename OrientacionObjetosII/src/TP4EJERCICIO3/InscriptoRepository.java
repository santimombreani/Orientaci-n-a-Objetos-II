package TP4EJERCICIO3;

import java.io.*;

public class InscriptoRepository implements InscriptoRepositoryInterface {
    private String rutaArchivo;

    public InscriptoRepository(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    public void guardar(Inscripto inscripto) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo, true));
        writer.write(inscripto.aTexto());
        writer.newLine();
        writer.close();
    }
}