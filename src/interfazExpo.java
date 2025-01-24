import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
public class interfazExpo {
    private JList<String> list1;
    public JPanel DatosP;
    private JButton mostrarDatosButton;
    public interfazExpo() {
        mostrarDatosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener los datos de la base de datos
                ArrayList<String> nombres = obtenerNombresDeBD();
                // Crear un modelo para el JList
                DefaultListModel<String> listModel = new DefaultListModel<>();
                for (String nombre : nombres) {
                    listModel.addElement(nombre);
                }
                list1 = new JList<>(listModel);
                JScrollPane scrollPane = new JScrollPane(list1);
                DatosP.setLayout(new BorderLayout());
                DatosP.add(scrollPane, BorderLayout.CENTER);
                DatosP.revalidate();
                DatosP.repaint();
            }
        });
    }

    // Metodo para obtener los nombres de la base de datos
    private ArrayList<String> obtenerNombresDeBD() {
        ArrayList<String> nombres = new ArrayList<>();
        String url = "jdbc:mysql://localhost:3306/EjemploDatos";
        String usuario = "root";
        String contrasena = "123456";
        try (Connection conn = DriverManager.getConnection(url, usuario, contrasena);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT nombre FROM usuarios")) {
            while (rs.next()) {
                nombres.add(rs.getString("nombre"));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return nombres;
    }

}
