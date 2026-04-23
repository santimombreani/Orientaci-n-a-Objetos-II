package TP3EJERCICIO5;

public abstract class Evento {
    private String nombreEvento;

    public Evento(String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }

    public String nombreEvento() {
        return nombreEvento;
    }

    // cada subclase sabe calcular su monto
    public abstract float calcularMonto(int espectadores);

    // cada subclase sabe calcular sus créditos
    public abstract float calcularCreditos(int espectadores);
}