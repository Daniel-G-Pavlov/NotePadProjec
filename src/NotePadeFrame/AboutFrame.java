package NotePadeFrame;

import javax.swing.*;
import java.awt.*;

public class AboutFrame  extends JFrame {

    public JPanel panel = new JPanel();
    public JLabel label = new JLabel();
    public JButton button = new JButton();

    public AboutFrame() {

        panel.setLayout(null);
        setTitle("About NotePad");
        setSize(600, 300);
        setLocation(350, 80);
        label.setBounds(40,20,500,200);
        label.setFont(new Font("Arial", Font.PLAIN, 16));
        label.setText("Този продукт \n е създаден от \n" +
                "Даниел Павлов\n и \n Наталия Христова");
        label.setVisible(true);
        panel.add(label);


        getContentPane().add(panel);

        setDefaultCloseOperation(AboutFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        repaint();

    }
}
