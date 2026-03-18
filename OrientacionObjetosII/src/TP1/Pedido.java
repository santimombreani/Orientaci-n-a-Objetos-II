package TP1;

import java.util.List;

public class Pedido {
    private List<LineaDePedido> platos;
    private List<LineaDePedido> bebidas;

    public Pedido(List<LineaDePedido> platos, List<LineaDePedido> bebidas) {
        this.platos = platos;
        this.bebidas = bebidas;
    }

    public List<LineaDePedido> getPlatos() {
        return platos;
    }

    public List<LineaDePedido> getBebidas() {
        return bebidas;
    }

    public double calcularPlatos() {
        double totalPlatos = 0;
        for (LineaDePedido l : platos) {
            totalPlatos += l.calcularSubTotal();
        }
        return totalPlatos;
    }

    public double calcularBebidas() {
        double totalBebidas = 0;
        for (LineaDePedido l : bebidas) {
            totalBebidas += l.calcularSubTotal();
        }
        return totalBebidas;
    }

    public double calcularTotal() {
        return calcularPlatos() + calcularBebidas();
    }

}
