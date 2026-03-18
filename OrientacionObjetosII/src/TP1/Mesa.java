package TP1;

public class Mesa {
    private int numero;
    private int capacidad;
    private boolean ocupada;

    public Mesa(int numero, int capacidad, boolean ocupada){
        this.numero = numero;
        this.capacidad = capacidad;
        this.ocupada = ocupada;
    }

    public int getNumero() {
        return numero;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void liberar(){
        this.ocupada = false;
    }

    public void ocupar(){
        this.ocupada = true;
    }

    public boolean estaOcupada() {
        return ocupada;
    }
}
