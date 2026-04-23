package Test.TP3.EJERCICIO1;

import TP3EJERCICIO1.Alquiler;
import TP3EJERCICIO1.Cliente;
import TP3EJERCICIO1.CopiaLibro;
import TP3EJERCICIO1.Libro;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlquilerTest {


    @Test
    public void testCalcularPago(){
        Libro libro1 = new Libro("El principito", Libro.INFANTILES);
        Libro libro2 = new Libro("Java", Libro.NUEVO_LANZAMIENTO);
        Libro libro3 = new Libro("Historia", Libro.REGULARES);

        CopiaLibro copia1 = new CopiaLibro(libro1);
        CopiaLibro copia2 = new CopiaLibro(libro2);
        CopiaLibro copia3 = new CopiaLibro(libro3);

        Alquiler alquiler1 = new Alquiler(copia1, 3);
        Alquiler alquiler2 = new Alquiler(copia2, 5);
        Alquiler alquiler3 = new Alquiler(copia3, 4);

        Cliente cliente1 = new Cliente("Juan");
        //agrego los alquileres al cliente
        cliente1.alquilar(alquiler1);
        cliente1.alquilar(alquiler2);
        cliente1.alquilar(alquiler3);

        Object[] resultado = cliente1.calcularDeudaYPuntosObtenidos();

        double total = (double) resultado[0];
        int puntos = (int) resultado[1];

        double esperadoTotal = 21.5;
        int esperadoPuntos = 4;

        assertEquals(21.5, total);
        assertEquals(4, puntos);


    }

}
