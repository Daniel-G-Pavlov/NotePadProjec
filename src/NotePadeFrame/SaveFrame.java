package NotePadeFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class SaveFrame extends JFrame implements ActionListener {
    private JPanel panel = new JPanel();
    private JLabel label = new JLabel();
    private JButton button = new JButton();
    private JFileChooser fileChooser = new JFileChooser();
    private JMenuBar menuBar = new JMenuBar();
    private JTextArea textArea = new JTextArea();
    private JButton buttonSaveFile;

    public SaveFrame() {
        setTitle("Save");
        setSize(600, 600);
        setLocation(350, 80);
        panel.setLayout(null);
        getContentPane().add(panel);

        fileChooser.setPreferredSize(new Dimension(500, 600));


        panel.add(fileChooser);


        setDefaultCloseOperation(NotePadeFrame.SaveFrame.DISPOSE_ON_CLOSE);
//        setResizable(false);
        prepareUI();
        pack();
        setVisible(true);
        repaint();


    }

    @Override
    public void actionPerformed( ActionEvent e ) {
        if (e.getSource() == buttonSaveFile) {
            final JFileChooser jFileChooser = new JFileChooser();
            int returnVal = jFileChooser.showSaveDialog(NotePadeFrame.SaveFrame.this);
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

    private void prepareUI() {
        textArea.setEditable(false);
        JScrollPane panel = new JScrollPane(textArea);
        panel.setPreferredSize(new Dimension(300, 100));

        buttonSaveFile = new JButton("Save File");
        buttonSaveFile.addActionListener(this);

        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().add(buttonSaveFile, BorderLayout.PAGE_END);
    }

}
