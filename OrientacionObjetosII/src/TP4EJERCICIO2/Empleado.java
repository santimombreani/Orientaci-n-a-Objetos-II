package TP4EJERCICIO2;

import java.time.LocalDate;

public class Empleado {
    private String apellido;
    private String nombre;
    private LocalDate fechaNacimiento;
    private String email;

    public Empleado(String apellido, String nombre, LocalDate fechaNacimiento, String email){
        this.apellido = apellido;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.email = email;

    }

    public boolean cumpleanosHoy(){
        LocalDate hoy = LocalDate.now();
        return  fechaNacimiento.getMonth() == hoy.getMonth()
                && fechaNacimiento.getDayOfMonth() == hoy.getDayOfMonth();
    }

    public void enviarSaludo(EmailSender sender){
        sender.enviar(email, "Feliz cumpleanios " + nombre + " " + apellido + "!");
    }
}
