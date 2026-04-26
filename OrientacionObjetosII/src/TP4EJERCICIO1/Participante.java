package TP4EJERCICIO1;

public class Participante {
    private String nombre;
    private String telefono;
    private String region;

    public Participante(String nombre, String telefono, String region) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.region = region;
    }

    public String getNombre()   { return nombre; }
    public String getTelefono() { return telefono; }
    public String getRegion()   { return region; }
}