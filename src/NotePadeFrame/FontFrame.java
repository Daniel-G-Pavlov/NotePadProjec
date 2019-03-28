package NotePadeFrame;

import javax.swing.*;

public class FontFrame  extends JFrame {

    public JPanel panel = new JPanel();
    public JLabel label = new JLabel();
    public JButton button = new JButton();

    public FontFrame() {

        setTitle("Font");
        setSize(400, 600);
        setLocation(350, 80);
        panel.setLayout(null);
        getContentPane().add(panel);

        setDefaultCloseOperation(FontFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        repaint();

    }
}
