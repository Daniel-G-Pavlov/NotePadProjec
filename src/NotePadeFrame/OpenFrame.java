package NotePadeFrame;

import javax.swing.*;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import static javax.swing.JFileChooser.APPROVE_BUTTON_TOOL_TIP_TEXT_CHANGED_PROPERTY;

public class OpenFrame extends JFrame implements ActionListener {
    private JPanel panel = new JPanel();
    private JLabel label = new JLabel();
    private JButton button = new JButton();
    private JFileChooser fileChooser = new JFileChooser();
    private JMenuBar menuBar = new JMenuBar();
    private JTextArea textArea = new JTextArea();
    private JButton buttonOpenFile;


    public OpenFrame() {

        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        jfc.setDialogTitle("Open");
        FileNameExtensionFilter filter = new FileNameExtensionFilter("TXT", "txt");
        jfc.addChoosableFileFilter(filter);

        int returnValue = jfc.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            if (jfc.getSelectedFile().isDirectory()) {
                System.out.println("You selected the directory: " + jfc.getSelectedFile());
            }
            System.out.println(jfc.getSelectedFile().getPath());
        }
    }

    @Override
    public void actionPerformed( ActionEvent e ) {

    }
}