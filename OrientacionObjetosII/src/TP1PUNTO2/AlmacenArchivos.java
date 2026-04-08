package TP1PUNTO2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// Implementa tu interfaz IAlmacenCosto
public class AlmacenArchivos implements IAlmacenDeCosto {

    private String nombreArchivo;
    private static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public AlmacenArchivos(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    @Override
    public void guardarPedido(double total, LocalDateTime fechaHora) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo, true))) {
            String linea = fechaHora.format(FORMATO) + ",  , " + total;
            writer.write(linea);
            writer.newLine();
            System.out.println("Costo guardado correctamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar costo: " + e.getMessage());
        }
    }
}