import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;public class ObtenerDatos {
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
