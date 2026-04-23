package TP3EJERCICIO5;

public class Comedia extends Evento{
    public Comedia(String nombreEvento) {
        super(nombreEvento);
    }

    @Override
    public float calcularMonto(int espectadores) {
        float monto = 30000;
        if (espectadores > 20) {
            monto += 10000 + 500 * (espectadores - 20);
            monto += 300 * espectadores;
        }
        return monto;
    }

    @Override
    public float calcularCreditos(int espectadores) {
        return Math.max(espectadores - 30, 0)
                + (float) Math.floor(espectadores / 5);
    }
}
