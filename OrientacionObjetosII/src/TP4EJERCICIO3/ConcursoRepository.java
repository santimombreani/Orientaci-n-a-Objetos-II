package TP4EJERCICIO3;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ConcursoRepository implements ConcursoRepositoryInterface {
    private String rutaArchivo;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

    public ConcursoRepository(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    public List<Concurso> obtenerAbiertos() throws IOException {
        List<Concurso> abiertos = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo));
        String linea;

        while ((linea = reader.readLine()) != null) {
            String[] partes = linea.split(",");
            int id = Integer.parseInt(partes[0].trim());
            String nombre = partes[1].trim();
            LocalDate inicio = LocalDate.parse(partes[2].trim(), formatter);
            LocalDate fin = LocalDate.parse(partes[3].trim(), formatter);

            Concurso concurso = new Concurso(id, nombre, inicio, fin);
            if (concurso.inscripcionAbierta()) {
                abiertos.add(concurso);
            }
        }

        reader.close();
        return abiertos;
    }
}