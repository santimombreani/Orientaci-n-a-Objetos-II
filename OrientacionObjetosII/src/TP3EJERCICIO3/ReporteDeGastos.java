package TP3EJERCICIO3;

import java.util.List;

enum TipoDeGasto {
    CENA, DESAYUNO, ALQUILER_AUTO
}

class Gasto {
    TipoDeGasto tipoGasto;
    int monto;
}

public class ReporteDeGastos {
    public String imprimir(List<Gasto> gastos) {
        int total = calcularTotal(gastos);
        int gastosDeComida = calcularGastosDeComida(gastos);

        String reporte = "";

        for (Gasto gasto : gastos) {

            String nombreGasto = getNombreGasto(gasto);

            String marcaExcesoComidas = getMarcaExceso(gasto);

            reporte += (nombreGasto + "\t" + gasto.monto + "\t" + marcaExcesoComidas);

        }

        reporte += ("Gastos de comida: " + gastosDeComida);
        reporte += ("Total de gastos: " + total);
        return reporte;
    }

    private static String getNombreGasto(Gasto gasto) {
        String nombreGasto = "";
        switch (gasto.tipoGasto) {
            case CENA:
                nombreGasto = "Cena";
                break;
            case DESAYUNO:
                nombreGasto = "Desayuno";
                break;
            case ALQUILER_AUTO:
                nombreGasto = "Alquiler de Autos";
                break;
        }
        return nombreGasto;
    }
     //Extrac method
    private static String getMarcaExceso(Gasto gasto) {
        String marcaExcesoComidas = gasto.tipoGasto == TipoDeGasto.CENA && gasto.monto > 5000
                || gasto.tipoGasto == TipoDeGasto.DESAYUNO && gasto.monto > 1000 ? "X" : " ";
        return marcaExcesoComidas;
    }
    //Extrac method
    private int calcularTotal(List<Gasto> gastos) {
        int total = 0;
        for (Gasto gasto : gastos) {
            total += gasto.monto;
        }
        return total;
    }
//Extrac method
    private  int calcularGastosDeComida(List<Gasto> gastos){
        int gastosDeComida = 0;
        for(Gasto gasto : gastos){
            if(gasto.tipoGasto == TipoDeGasto.CENA || gasto.tipoGasto == TipoDeGasto.DESAYUNO){
                gastosDeComida += gasto.monto;
            }
        }
        return gastosDeComida;

    }
}