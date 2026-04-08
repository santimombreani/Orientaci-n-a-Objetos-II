package TP1PUNTO1;

public class Participante {
    private int id;
    String nombre;
    int puntos;

    public Participante(int id,String nombre, int puntos){
        this.id = id;
        this.nombre = nombre;
        this.puntos = puntos;
    }

    public int getId() {
        return id;
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
