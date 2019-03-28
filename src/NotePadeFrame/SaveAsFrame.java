package NotePadeFrame;

import javax.swing.*;

public class SaveAsFrame extends JFrame{

    public JPanel panel = new JPanel();
    public JLabel label = new JLabel();
    public JButton button = new JButton();

    public SaveAsFrame (){

        setTitle("Save As...");
        setSize(400, 600);
        setLocation(350, 80);
        panel.setLayout(null);
        getContentPane().add(panel);



        setDefaultCloseOperation(SaveAsFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        repaint();

    }

}
