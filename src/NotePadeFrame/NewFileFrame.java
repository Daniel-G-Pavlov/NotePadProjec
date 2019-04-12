package NotePadeFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.File;

public class NewFileFrame extends JFrame implements ActionListener {



    private JPanel panel = new JPanel();
    private JLabel label = new JLabel();
    private JButton buttonSave = new JButton();
    private JButton buttonDontSave = new JButton();
    private JButton buttonCansel = new JButton();
    private JFileChooser fileChooser = new JFileChooser();
    private JMenuBar menuBar = new JMenuBar();
    private JTextArea textArea = new JTextArea();
    private JTextField textField = new JTextField();
    //    private JButton buttonSave;
    public String fileName = "Untitled";

    public NewFileFrame() {



        setTitle("Notpad");
        setSize(600, 600);
        setLocation(350, 80);
        panel.setLayout(null);
        getContentPane().add(panel);

        fileChooser.setAcceptAllFileFilterUsed(true);
        panel.add(fileChooser);

        setDefaultCloseOperation(NewFileFrame.DISPOSE_ON_CLOSE);

        textField.setEditable(false);
        textField.setText("Do you want to save changes to " + fileName + "?" );
        Font font = new Font("Arial", Font.BOLD, 15);
        textField.setFont(font);
        textField.setBounds(20,20,300,20);
        textField.setVisible(true);
        setResizable(false);
        panel.add(textField);
        panel.setPreferredSize(new Dimension(360, 100));

        JButton buttonSave = ButtonSave("Save", 20,80);
        JButton buttonDontSave = ButtonSave("Don't Save", 120,120);
        JButton buttonCansel = ButtonSave("Cansel", 260,80);

        buttonDontSave.addActionListener(new ActionListener() {
            @Override
            public boolean actionPerformed( ActionEvent e ) {
                dontSaveCommand = false;
                cancelClicked();
                return dontSaveCommand;
            }
        });

        buttonCansel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent e ) {
                cancelClicked();
            }
        });

        buttonSave.addActionListener(this);

        pack();
        setVisible(true);
        repaint();
    }

    @Override
    public void actionPerformed( ActionEvent e ) {
        if (e.getSource() == buttonSave) {
            final JFileChooser jFileChooser = new JFileChooser();
            int returnVal = jFileChooser.showOpenDialog(NotePadeFrame.NewFileFrame.this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = jFileChooser.getSelectedFile();
                textArea.setText("Selected file: " + file.getName());
            } else if (returnVal == JFileChooser.CANCEL_OPTION) {
                textArea.setText("Cancelled");
            } else if (returnVal == JFileChooser.ERROR_OPTION) {
                textArea.setText("Error!");
            } else {
                textArea.setText("unknown...");
            }
        }
    }

    private JButton ButtonSave( String save, int i ,int i2) {
        buttonSave.setText(save);
        JButton buttonSave = new JButton(save);
        buttonSave.setBounds(i, 60, i2, 30);
        buttonSave.setVisible(true);
        panel.add(buttonSave);
        return buttonSave;
    }

    private void cancelClicked() {
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }

}

