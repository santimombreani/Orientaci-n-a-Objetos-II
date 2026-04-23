package TP3EJERCICIO1;

public class Alquiler {
    private CopiaLibro copia;
    private int diasAlquilados;

    public Alquiler(CopiaLibro copia, int diasAlquilados) {
        this.copia = copia;
        this.diasAlquilados = diasAlquilados;
    }

    public int diasAlquilados() {
        return this.diasAlquilados;
    }

    public CopiaLibro copia() {
        return this.copia;
    }

    public double calcularMonto() {
        double monto = 0;

        switch (copia().libro().codigoPrecio()) {
            case Libro.REGULARES:
                monto += 2;
                if (diasAlquilados() > 2)
                    monto += (diasAlquilados() - 2) * 1.5;
                break;

            case Libro.NUEVO_LANZAMIENTO:
                monto += diasAlquilados() * 3;
                break;

            case Libro.INFANTILES:
                monto += 1.5;
                if (diasAlquilados() > 3)
                    monto += (diasAlquilados() - 3) * 1.5;
                break;
        }

        return monto;
    }

    public int calcularPuntos() {
        int puntos = 1;

        if (copia().libro().codigoPrecio() == Libro.NUEVO_LANZAMIENTO
                && diasAlquilados() > 1) {
            puntos++;
        }

        return puntos;
    }
}