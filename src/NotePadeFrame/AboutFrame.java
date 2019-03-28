package NotePadeFrame;

import javax.swing.*;

public class AboutFrame  extends JFrame {

    public JPanel panel = new JPanel();
    public JLabel label = new JLabel();
    public JButton button = new JButton();

    public AboutFrame() {

        setTitle("About NotePad");
        setSize(400, 500);
        setLocation(350, 80);
        panel.setLayout(null);
        getContentPane().add(panel);

        setDefaultCloseOperation(AboutFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        repaint();

    }
}
