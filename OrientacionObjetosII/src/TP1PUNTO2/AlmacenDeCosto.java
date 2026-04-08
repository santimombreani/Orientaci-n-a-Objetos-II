package TP1PUNTO2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AlmacenDeCosto {

    private String nombreArchivo;

    public AlmacenDeCosto(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public void guardarPedido(double total, LocalDateTime now) {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fecha = LocalDateTime.now().format(formato);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo, true))) {
            String linea = fecha + " || " + total;
            writer.write(linea);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error al guardar costo: " + e.getMessage());
        }
    }
}