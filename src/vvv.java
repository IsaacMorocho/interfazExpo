/*
import java.sql.*;
import java.util.ArrayList;

public class vvv {
    public static Connection getConexion() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/ejemploDatos";
        String usuario = "root";
        String contrasena = "123456";
        return DriverManager.getConnection(url, usuario, contrasena);
    }
    public static ArrayList<String> obtenerNombres() {
        ArrayList<String> nombres = new ArrayList<>();

        try (Connection conn = ConexionBD.getConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT nombre FROM usuarios")) {
            while (rs.next()) {
                nombres.add(rs.getString("nombre"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nombres;
    }
}

 */
