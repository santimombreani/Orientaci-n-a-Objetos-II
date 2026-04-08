package TP1PUNTO1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RepositorioArchivo implements IRepositorioInscripciones {
    private String nombreArchivo;
    private static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public RepositorioArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    @Override
    public void guardarInscripcion(int idParticipante, int idConcurso, LocalDateTime fechaHora) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo, true))) {
            String linea = fechaHora.format(FORMATO) + ", " + idParticipante + ", " + idConcurso;
            writer.write(linea);
            writer.newLine();
            System.out.println("Inscripción guardada correctamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar inscripción: " + e.getMessage());
        }
    }
}