package NotePadeFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExitFrame extends JFrame {

    private JPanel panel = new JPanel();
    private JLabel label = new JLabel();
    private JTextField textField = new JTextField();
    private JButton buttonSave = new JButton();
    private JButton buttonExit = new JButton();
    private JButton buttonCancel = new JButton();

    public ExitFrame() {

        setTitle("EXIT");
        setSize(560, 200);
        setLocation(350, 80);
        panel.setLayout(null);
        getContentPane().add(panel);

        textField.setText("Do you want to save changes to Untitled?");
        textField.setEditable(false);
//        textField.setFont(NORMAL, Font PLAIN, 20);
        textField.setVisible(true);
        textField.setBounds(30, 20, 300, 30);
        panel.add(textField);

        buttonSave.setText("Save File and Exit");
        buttonSave.setBounds(30, 100, 150, 30);
        buttonSave.setVisible(true);
        panel.add(buttonSave);

        buttonExit.setText("EXIT");
        buttonExit.setBounds(200, 100, 150, 30);
        buttonExit.setVisible(true);
        panel.add(buttonExit);

        buttonCancel.setText("Cancel");
        buttonCancel.setBounds(380, 100, 150, 30);
        buttonCancel.setVisible(true);
        panel.add(buttonCancel);


        buttonSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent e ) {

            }
        });

        buttonExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent e ) {
                System.exit(ExitFrame.EXIT_ON_CLOSE);
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent e ) {
                setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                System.out.println("gh");
            }
        });


        setDefaultCloseOperation(ExitFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        repaint();

    }
}