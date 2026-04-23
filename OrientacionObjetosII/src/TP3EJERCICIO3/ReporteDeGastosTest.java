package TP3EJERCICIO3;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ReporteDeGastosTest {

    @Test
    public void testReporteDeGastos(){
        Gasto gasto1 = new Gasto();
        gasto1.tipoGasto = TipoDeGasto.DESAYUNO;
        gasto1.monto = 1000;

        List<Gasto> gastos = new ArrayList<>();
        gastos.add(gasto1);

        ReporteDeGastos reporte = new ReporteDeGastos();
        String resultado = reporte.imprimir(gastos);

        assertTrue(resultado.contains("Total de gastos: 1000"));



    }
}
