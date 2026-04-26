package TP4EJERCICIO2;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoRepository {
    private String rutaArchivo;

    public EmpleadoRepository(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    public List<Empleado> obtenerTodos() throws IOException {
        List<Empleado> empleados = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo));
        String linea;

        while ((linea = reader.readLine()) != null) {
            String[] partes = linea.split(",");
            String apellido = partes[0].trim();
            String nombre = partes[1].trim();
            LocalDate fecha = LocalDate.parse(partes[2].trim(),
                    DateTimeFormatter.ofPattern("yyyy/MM/dd"));
            String email = partes[3].trim();

            empleados.add(new Empleado(apellido, nombre, fecha, email));
        }

        reader.close();
        return empleados;
    }
}