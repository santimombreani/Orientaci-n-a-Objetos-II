package TP1PUNTO2;

import java.util.List;
import java.time.LocalDateTime;

public class Pedido {
    private List<LineaDePedido> platos;
    private List<LineaDePedido> bebidas;
    private AlmacenDeCosto almacen;

    public Pedido(List<LineaDePedido> platos, List<LineaDePedido> bebidas, AlmacenDeCosto almacen) {
        this.platos = platos;
        this.bebidas = bebidas;
        this.almacen = almacen;
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
        double total = calcularPlatos() + calcularBebidas();
        almacen.guardarPedido(total, LocalDateTime.now());
        return total;
    }

}
