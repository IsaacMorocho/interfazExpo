import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

public class interfazExpo {
    private JList<String> listaUsuarios;
    public JPanel DatosP;

    public interfazExpo() {
        // Configurar el modelo del JList con los datos de la base de datos
        DefaultListModel<String> modeloLista = new DefaultListModel<>();
        listaUsuarios.setModel(modeloLista);

        // Cargar los datos de la base de datos
        cargarDatos(modeloLista);
    }

    private void cargarDatos(DefaultListModel<String> modeloLista) {
        String url = "jdbc:mysql://localhost:3306/Baseejemp";
        String usuario = "root";
        String contrasena = "123456";

        try (Connection conexion = DriverManager.getConnection(url, usuario, contrasena)) {
            String consulta = "SELECT nombre FROM usuarios";
            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery(consulta);

            // Añadir los datos al modelo de la lista
            while (resultSet.next()) {
                modeloLista.addElement(resultSet.getString("nombre"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos: " + e.getMessage());
        }
    }
}
