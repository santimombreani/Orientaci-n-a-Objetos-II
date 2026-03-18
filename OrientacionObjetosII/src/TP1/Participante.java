package TP1;

public class Participante {
    String nombre;
    int puntos;

    public Participante(String nombre, int puntos){
        this.nombre = nombre;
        this.puntos = puntos;
    }

    public String getNombre(){
        return nombre;
    }

    public int getPuntos(){
        return puntos;
    }

    public void sumarPuntos(int cantidad) {
        this.puntos += cantidad;
    }

}
