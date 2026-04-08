package TP1PUNTO2;

public class Factura {
    private Pedido pedido;
    private TarjetaDeCredito tarjeta;
    private double porcentajePropina;

    public double calcularTotalFinal(){
        double total = pedido.calcularTotal();
        double descuento = tarjeta.calcularDescuento(pedido);
        double propina = total * porcentajePropina;

        return total - descuento + propina;
    }
}
