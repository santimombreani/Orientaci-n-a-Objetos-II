package TP3EJERCICIO4;


import TP4EJERCICIO1.Participante;

import java.sql.*;

public class ParticipanteRepository {
    private Connection dbConn;

    public ParticipanteRepository() throws SQLException {
        String url  = "jdbc:derby://localhost:1527/participantes";
        String user = "app";
        String pass = "app";
        this.dbConn = DriverManager.getConnection(url, user, pass);
    }

    public void guardar(Participante p) throws SQLException {
        String sql = "INSERT INTO participantes(nombre, telefono, region) VALUES(?,?,?)";
        try (PreparedStatement st = dbConn.prepareStatement(sql)) {
            st.setString(1, p.getNombre());
            st.setString(2, p.getTelefono());
            st.setString(3, p.getRegion());
            st.executeUpdate();
        }
    }
}