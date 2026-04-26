package TP3EJERCICIO4;

import TP3EJERCICIO4.ParticipanteRepository;

import java.sql.SQLException;

public class ParticipanteService {
    private final ParticipanteRepository repo;

    public ParticipanteService(ParticipanteRepository repo) {
        this.repo = repo;
    }

    public void agregarParticipante(String nombre, String telefono, String region)
            throws SQLException, IllegalArgumentException {

        if (nombre == null || nombre.isBlank())
            throw new IllegalArgumentException("Debe cargar un nombre");

        if (telefono == null || telefono.isBlank())
            throw new IllegalArgumentException("Debe cargar un telefono");

        if (!telefono.matches("\\d{4}-\\d{6}"))
            throw new IllegalArgumentException(
                    "El teléfono debe ingresarse de la siguiente forma: NNNN-NNNNNN");

        if (!region.equals("China") && !region.equals("US") && !region.equals("Europa"))
            throw new IllegalArgumentException(
                    "Region desconocida. Las conocidas son: China, US, Europa");

        repo.guardar(new Participante(nombre, telefono, region));
    }
}