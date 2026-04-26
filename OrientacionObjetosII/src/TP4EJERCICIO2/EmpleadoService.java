package TP4EJERCICIO2;


import java.util.List;

public class EmpleadoService {
    private EmailSender sender;

    public EmpleadoService(EmailSender sender) {
        this.sender = sender;
    }

    public void saludarCumpleaneros(List<Empleado> empleados) {
        for (Empleado empleado : empleados) {
            if (empleado.cumpleanosHoy()) {
                empleado.enviarSaludo(sender);
            }
        }
    }
}