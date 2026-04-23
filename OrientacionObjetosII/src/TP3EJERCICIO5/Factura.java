package TP3EJERCICIO5;

import java.util.List;

public record Factura(String nombreCliente, List<Actuacion> actuaciones) {
}