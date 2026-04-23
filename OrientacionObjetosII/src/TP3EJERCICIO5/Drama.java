package TP3EJERCICIO5;

public class Drama extends Evento {
    public Drama(String nombreEvento) {
        super(nombreEvento);
    }

    @Override
    public float calcularMonto(int espectadores) {
        float monto = 40000;
        if (espectadores > 30) {
            monto += 1000 * (espectadores - 30);
        }
        return monto;
    }

    @Override
    public float calcularCreditos(int espectadores) {
        return Math.max(espectadores - 30, 0);
    }
}
