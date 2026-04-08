package TP1PUNTO2;

public class Propina {
    public static double calcular(Pedido pedido, double porcentaje){
        return pedido.calcularTotal() * porcentaje;
    }
}
