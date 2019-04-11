package NotePadeFrame;

import javax.swing.*;
import java.awt.*;

public class StatusBar extends JFrame {

    public JTextArea textArea = new JTextArea();
    public JPanel panel = new JPanel();
    public JLabel label = new JLabel();

    public StatusBar () {

//        textArea.setEditable(false);
//        JScrollPane panel = new JScrollPane(textArea);
//        panel.setPreferredSize(new Dimension(300, 300));


        getContentPane().add(label, BorderLayout.CENTER);
        getContentPane().add(label, BorderLayout.PAGE_END);



    }
}