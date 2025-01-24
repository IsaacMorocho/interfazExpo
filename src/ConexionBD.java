import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConexionBD {
    public static Connection getConexion() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/ejemploDatos";  // Cambia esto según tu base de datos
        String usuario = "root";  // Cambia este dato
        String contrasena = "123456";  // Cambia este dato
        return DriverManager.getConnection(url, usuario, contrasena);
    }
}
