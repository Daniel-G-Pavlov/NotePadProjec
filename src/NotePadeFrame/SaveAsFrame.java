package NotePadeFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.*;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

import static NotePadeFrame.StartFrame.getTextArea;
import static com.sun.java.accessibility.util.AWTEventMonitor.addActionListener;
import static javax.swing.JFileChooser.OPEN_DIALOG;
import static javax.swing.JFileChooser.SAVE_DIALOG;

public class SaveAsFrame extends JFrame implements ActionListener {
    private JPanel panel = new JPanel();
    private JLabel label = new JLabel();
    private JButton button = new JButton();
    private JFileChooser fileChooser = new JFileChooser();
    private JMenuBar menuBar = new JMenuBar();
    private JTextArea textArea = new JTextArea();
    private JButton buttonSaveFile;

    public SaveAsFrame( String fileName, JTextArea textArea ) throws IOException {

        JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        fileChooser.setDialogTitle("Save As..");
        FileNameExtensionFilter filter = new FileNameExtensionFilter("TXT", "txt");
        fileChooser.addChoosableFileFilter(filter);

        int returnValue = fileChooser.showSaveDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            if (fileChooser.getSelectedFile().isDirectory()) {
                System.out.println("You selected the directory: " + fileChooser.getSelectedFile());
            }
        }


        SaveFrame saveFrame = new SaveFrame("Untitled.txt", textArea);

        if (paramString(SAVE_DIALOG)) {
            fileChooser.getSelectedFile();
            fileName = String.valueOf(fileChooser.getSelectedFile());
            saveClicked(fileName);
        }

        WriterFileNames writerFileNames = new WriterFileNames(fileName);
        saveFrame = new SaveFrame(fileName, textArea);

        StartFrame.getTitle(fileName);
        return;
    }

    private boolean paramString( int saveDialog ) {
        return true;
    }

    private void saveClicked( String fileName ) {
        getTextArea = new TextArea();
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent e ) {
                BufferedWriter bf = null;
                try {
                    bf = new BufferedWriter(new FileWriter(fileName));
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
            }
        });
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }

    @Override
    public void actionPerformed( ActionEvent e ) {

    }
}