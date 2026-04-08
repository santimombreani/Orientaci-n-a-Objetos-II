package TP1PUNTO2;

public class LineaDePedido {
    private ItemMenu item;
    private int cantidad;

    public  LineaDePedido(ItemMenu item, int cantidad){
        this.item = item;
        this.cantidad = cantidad;
    }

    public ItemMenu getItem() {
        return item;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double calcularSubTotal(){
        return item.getPrecio() * cantidad;
    }
}
