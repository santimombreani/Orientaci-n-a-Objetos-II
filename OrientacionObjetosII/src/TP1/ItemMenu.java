package TP1;

public class ItemMenu {
    private String nombre;
    private int precio;
    private String tipo; // plato o bebida

    public ItemMenu(String nombre, int precio, String tipo){
        this.nombre = nombre;
        this.precio = precio;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public String getTipo() {
        return tipo;
    }
}
