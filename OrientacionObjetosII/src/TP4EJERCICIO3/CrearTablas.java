package TP4EJERCICIO3;

import java.sql.*;

public class CrearTablas {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:derby:concursosDB;create=true";
        Connection conn = DriverManager.getConnection(url);
        Statement st = conn.createStatement();

        st.executeUpdate("INSERT INTO concursos VALUES (1, 'Concurso X', '2025-01-01', '2027-01-01')");
        st.executeUpdate("INSERT INTO concursos VALUES (2, 'Concurso Y', '2025-01-01', '2027-01-01')");

        st.close();
        conn.close();
        System.out.println("Datos insertados!");
    }
}