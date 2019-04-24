package NotePadeFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import static NotePadeFrame.StartFrame.textArea;

public class ExitFrame extends JFrame {

    JFrame frame = new JFrame();
    private JPanel panel = new JPanel();
    private JLabel label = new JLabel();
    private JTextField textField = new JTextField();
    private JButton buttonSave = new JButton();
    private JButton buttonExit = new JButton();
    private JButton buttonCancel = new JButton();

    public ExitFrame(String fileName) {

        setTitle("EXIT");
        setSize(560, 200);
        setLocation(350, 80);
        panel.setLayout(null);
        getContentPane().add(panel);

        textField.setText("Do you want to save changes to file?");
        textField.setEditable(false);
        Font font = new Font("Arial", Font.BOLD, 25);
        textField.setFont(font);
        textField.setVisible(true);
        textField.setBounds(30, 20, 500, 30);
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
                SaveFrame saveFrame = new SaveFrame(fileName,textArea);
                System.exit(ExitFrame.EXIT_ON_CLOSE);
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
                cancelClicked();
            }
        });

        setDefaultCloseOperation(ExitFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        repaint();

    }
    private void cancelClicked() {
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }
}