package TP4EJERCICIO2;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class EmpleadoTest {

    @Test
    public void empleadoCumpleAniosHoy() {
        LocalDate hoy = LocalDate.now();
        Empleado empleado = new Empleado("Young", "Angus", hoy, "angus@test.com");
        assertTrue(empleado.cumpleanosHoy());
    }

    @Test
    public void empleadoNoCumpleAniosHoy() {
        LocalDate otraFecha = LocalDate.of(1990, 1, 1);
        Empleado empleado = new Empleado("Johnson", "Brian", otraFecha, "brian@test.com");
        assertFalse(empleado.cumpleanosHoy());
    }

    @Test
    public void empleadoCumpleAniosIgnoraElAnio() {
        LocalDate hoy = LocalDate.now();
        LocalDate fechaVieja = LocalDate.of(1980, hoy.getMonth(), hoy.getDayOfMonth());
        Empleado empleado = new Empleado("Test", "Usuario", fechaVieja, "test@test.com");
        assertTrue(empleado.cumpleanosHoy());
    }
}