package TP4EJERCICIO3;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ConcursoRepositoryDB implements ConcursoRepositoryInterface {
    private Connection conn;

    public ConcursoRepositoryDB() throws SQLException {
        this.conn = DriverManager.getConnection("jdbc:derby:concursosDB");
    }

    public List<Concurso> obtenerAbiertos() throws SQLException {
        List<Concurso> abiertos = new ArrayList<>();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM concursos");

        while (rs.next()) {
            int id = rs.getInt("id");
            String nombre = rs.getString("nombre");
            LocalDate inicio = rs.getDate("fechaInicioInscripcion").toLocalDate();
            LocalDate fin = rs.getDate("fechaFinInscripcion").toLocalDate();
            Concurso c = new Concurso(id, nombre, inicio, fin);
            if (c.inscripcionAbierta()) {
                abiertos.add(c);
            }
        }

        rs.close();
        st.close();
        return abiertos;
    }
}