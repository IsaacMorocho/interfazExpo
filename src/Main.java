import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("INSERCION DE DATOS");
        frame.setContentPane(new interfazExpo().DatosP);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 350);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        
    }
}