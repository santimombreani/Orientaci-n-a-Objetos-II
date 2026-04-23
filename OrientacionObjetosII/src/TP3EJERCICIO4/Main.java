package TP3EJERCICIO4;

import org.jdbi.v3.core.Jdbi;

public class Main {

    public static void main(String[] args) {

        Jdbi jdbi = Jdbi.create("jdbc:hsqldb:mem;create=true");

        new SetUpDatabase(jdbi).setUp();

        var repo = new PersonaRepository(jdbi);
        var personas = repo.buscarPorNombre("Vla");

//cambiamos
        for (Persona persona : personas) {
            System.out.println(persona.nombre() + " " + persona.apellido());
        }
//cambiamos
        repo.buscarId(1L).ifPresent(persona -> // solo ejecuta si encontro algo
                System.out.println(persona.nombre() + " " + persona.apellido())
        );
    }
}