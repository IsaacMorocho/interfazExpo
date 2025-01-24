import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class interfazExpo {
    private JList list1;
    public JPanel DatosP;
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                JFrame frame = new JFrame("Mostrar Datos desde MySQL");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(400, 300);

                // Obtener los datos de la base de datos
                ArrayList<String> nombres = ObtenerDatos.obtenerNombres();

                // Crear un modelo para el JList
                DefaultListModel<String> listModel = new DefaultListModel<>();
                for (String nombre : nombres) {
                    listModel.addElement(nombre);
                }

                // Crear el JList con el modelo
                JList<String> jList = new JList<>(listModel);
                JScrollPane scrollPane = new JScrollPane(jList);
                frame.add(scrollPane, BorderLayout.CENTER);

                // Mostrar la ventana
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
