package TP4EJERCICIO2;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        EmpleadoRepository repo = new EmpleadoRepository("OrientacionObjetosII/empleados.txt");

        EmailSender sender = new EmailSender(
                "sandbox.smtp.mailtrap.io",
                "2525",
                "91cbfe530bec26",
                "e57398690ef7a3"
        );

        EmpleadoService service = new EmpleadoService(sender);

        List<Empleado> empleados = repo.obtenerTodos();
        service.saludarCumpleaneros(empleados);
    }
}