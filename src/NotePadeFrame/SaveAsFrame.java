package NotePadeFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

public class SaveAsFrame extends JFrame implements ActionListener {
    private JPanel panel = new JPanel();
    private JLabel label = new JLabel();
    private JButton button = new JButton();
    private JFileChooser fileChooser = new JFileChooser();
    private JMenuBar menuBar = new JMenuBar();
    private JTextArea textArea = new JTextArea();
    private JButton buttonOpenFile;

public SaveAsFrame (String fileName){

    JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
    jfc.setDialogTitle("Save As..");
    FileNameExtensionFilter filter = new FileNameExtensionFilter("TXT", "txt");
    jfc.addChoosableFileFilter(filter);

        int returnValue = jfc.showSaveDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            if (jfc.getSelectedFile().isDirectory()) {
                System.out.println("You selected the directory: " + jfc.getSelectedFile());
            }
        }
    }

    @Override
    public void actionPerformed( ActionEvent e ) {

    }
}