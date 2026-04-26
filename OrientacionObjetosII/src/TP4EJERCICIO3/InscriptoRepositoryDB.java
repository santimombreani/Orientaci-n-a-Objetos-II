package TP4EJERCICIO3;

import java.sql.*;

public class InscriptoRepositoryDB implements InscriptoRepositoryInterface {
    private Connection conn;

    public InscriptoRepositoryDB() throws SQLException {
        this.conn = DriverManager.getConnection("jdbc:derby:concursosDB");
    }

    public void guardar(Inscripto inscripto) throws SQLException {
        String sql = "INSERT INTO inscriptos(apellido, nombre, telefono, email, idConcurso) VALUES(?,?,?,?,?)";
        PreparedStatement st = conn.prepareStatement(sql);
        st.setString(1, inscripto.getApellido());
        st.setString(2, inscripto.getNombre());
        st.setString(3, inscripto.getTelefono());
        st.setString(4, inscripto.getEmail());
        st.setInt(5, inscripto.getIdConcurso());
        st.executeUpdate();
        st.close();
    }
}