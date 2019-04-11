package NotePadeFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class SaveAsFrame extends JFrame implements ActionListener {
    private JPanel panel = new JPanel();
    private JLabel label = new JLabel();
    private JButton button = new JButton();
    private JFileChooser fileChooser = new JFileChooser();
    private JMenuBar menuBar = new JMenuBar();
    private JTextArea textArea = new JTextArea();
    private JButton buttonOpenFile;

    public SaveAsFrame() {
        setTitle("SaveAs ...");
        setSize(600, 600);
        setLocation(350, 80);
        panel.setLayout(null);
        getContentPane().add(panel);

        fileChooser.setPreferredSize(new Dimension(500, 600));


        panel.add(fileChooser);


        setDefaultCloseOperation(NotePadeFrame.SaveAsFrame.DISPOSE_ON_CLOSE);
//        setResizable(false);
        prepareUI();
        pack();
        setVisible(true);
        repaint();


    }

    @Override
    public void actionPerformed( ActionEvent e ) {
        if (e.getSource() == buttonOpenFile) {
            final JFileChooser jFileChooser = new JFileChooser();
            int returnVal = jFileChooser.showSaveDialog(NotePadeFrame.SaveAsFrame.this);
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

        buttonOpenFile = new JButton("SaveAs File");
        buttonOpenFile.addActionListener(this);

        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().add(buttonOpenFile, BorderLayout.PAGE_END);
    }
}
