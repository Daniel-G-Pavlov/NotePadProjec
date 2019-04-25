package NotePadeFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.*;

import static NotePadeFrame.StartFrame.*;

public class NewFileFrame extends JFrame implements ActionListener {

    private JPanel panel = new JPanel();
    private JLabel label = new JLabel();
    private JButton buttonSave = new JButton();
    private JButton buttonDontSave = new JButton();
    private JButton buttonCansel = new JButton();
    private JFileChooser fileChooser = new JFileChooser();
    private JMenuBar menuBar = new JMenuBar();
    private JTextField textField = new JTextField();

    public NewFileFrame( String fileName, JTextArea textArea ) {
        super(fileName);

        setTitle(fileName);
        setSize(600, 600);
        setLocation(350, 80);
        panel.setLayout(null);
        getContentPane().add(panel);

        fileChooser.setAcceptAllFileFilterUsed(true);
        panel.add(fileChooser);

        setDefaultCloseOperation(NewFileFrame.DISPOSE_ON_CLOSE);

        textField.setEditable(false);
        textField.setText("Do you want to save changes ?");
        Font font = new Font("Arial", Font.BOLD, 15);
        textField.setFont(font);
        textField.setBounds(20, 20, 300, 20);
        textField.setVisible(true);
        setResizable(false);
        panel.add(textField);
        panel.setPreferredSize(new Dimension(360, 100));

        JButton buttonSave = new JButton();
        buttonSave.setText("Save");
        buttonSave.setBounds(20, 60, 80, 30);
        buttonSave.setVisible(true);
        panel.add(buttonSave);

        JButton buttonDontSave = new JButton();
        buttonDontSave.setText("Don't Save");
        buttonDontSave.setBounds(120, 60, 120, 30);
        buttonDontSave.setVisible(true);
        panel.add(buttonDontSave);

        JButton buttonCansel = new JButton();
        buttonCansel.setText("Cansel");
        buttonCansel.setBounds(260, 60, 80, 30);
        buttonCansel.setVisible(true);
        panel.add(buttonCansel);

        buttonCansel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent e ) {
                cancelClicked();
            }
        });

        buttonDontSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent e ) {


                System.out.println("Печат не записвай");
                dontSaveClicked();
            }
        });

        buttonSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent e ) {

                BufferedWriter bf = null;
                try {
                    bf = new BufferedWriter(new FileWriter(fileName + ".txt"));
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                try {
                    bf.write(textArea.getText());
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                try {
                    bf.flush();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                try {
                    bf.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                saveClicked();
            }
        });

        pack();
        setVisible(true);
        repaint();
    }

    public NewFileFrame() {
    }

    @Override
    public void actionPerformed( ActionEvent e ) {
        if (e.getSource() == buttonSave) {
            final JFileChooser jFileChooser = new JFileChooser();
            int returnVal = jFileChooser.showOpenDialog(NotePadeFrame.NewFileFrame.this);
            JEditorPane getTextArea = null;
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = jFileChooser.getSelectedFile();
                getTextArea.setText("Selected file: " + file.getName());
            } else if (returnVal == JFileChooser.CANCEL_OPTION) {
                getTextArea.setText("Cancelled");
            } else if (returnVal == JFileChooser.ERROR_OPTION) {
                getTextArea.setText("Error!");
            } else {
                getTextArea.setText("unknown...");
            }
        }
    }

    private void cancelClicked() {
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }

    private void dontSaveClicked() {
        StartFrame.getTextArea = null;
        StartFrame.getScrollPane(getTextArea);
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }

    private void saveClicked() {
        new StartFrame((JTextArea) textArea(20, 30));
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }

    private Object textArea( int i, int i1 ) {
        return i;
    }

}



