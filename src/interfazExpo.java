import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class interfazExpo {
    private JList<String> listaUsuarios;
    public JPanel DatosP;
    private JTextField datosTxt;
    private JButton guardarButton;
    private DefaultListModel<String> modeloLista;

    private static final String URL = "jdbc:mysql://localhost:3306/Baseejmp";
    private static final String USUARIO = "root";
    private static final String CONTRASENA = "123456";

    public interfazExpo() {
        //Configurar el modelo del JList
        modeloLista = new DefaultListModel<>();
        listaUsuarios.setModel(modeloLista);

        //Cargar los datos desde la base de datos
        cargarDatos();

        //Evento del botón "Guardar"
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarUsuario();
            }
        });
    }

    //Metodo para cargar datos en la JList desde MySQL
    private void cargarDatos() {
        modeloLista.clear(); // Limpiar la lista antes de recargar los datos

        try (Connection conexion = DriverManager.getConnection(URL, USUARIO, CONTRASENA)) {
            String consulta = "SELECT nombres FROM usuarios";
            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery(consulta);

            while (resultSet.next()) {
                modeloLista.addElement(resultSet.getString("nombres"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar datos: " + e.getMessage());
        }
    }

    //Metodo para guardar un nuevo usuario en MySQL
    private void guardarUsuario() {
        String nombres = datosTxt.getText().trim();

        if (nombres.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingresa un nombre antes de guardar.");
            return;
        }
        try (Connection conexion = DriverManager.getConnection(URL, USUARIO, CONTRASENA)) {
            String insertQuery = "INSERT INTO usuarios (nombres) VALUES (?)";
            PreparedStatement preparedStatement = conexion.prepareStatement(insertQuery);
            preparedStatement.setString(1, nombres);
            preparedStatement.executeUpdate();

            JOptionPane.showMessageDialog(null, "Usuario guardado correctamente.");

            datosTxt.setText("");
            cargarDatos(); //Recargar la lista con el nuevo dato
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar usuario: " + e.getMessage());
        }
    }
}
