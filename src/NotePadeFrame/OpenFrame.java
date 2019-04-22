package NotePadeFrame;

import javax.swing.*;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.*;

public class OpenFrame extends JFrame implements ActionListener {
    private JPanel panel = new JPanel();
    private JLabel label = new JLabel();
    private JButton button = new JButton();
    private JFileChooser fileChooser = new JFileChooser();
    private JMenuBar menuBar = new JMenuBar();
    private JTextArea textArea = new JTextArea();
    private JButton buttonOpenFile;


    public OpenFrame(String fileName) throws IOException {

        JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        fileChooser.setDialogTitle("Open");
        FileNameExtensionFilter filter = new FileNameExtensionFilter("TXT", "txt");
        fileChooser.addChoosableFileFilter(filter);

        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            if (fileChooser.getSelectedFile().isDirectory()) {
                System.out.println("You selected the directory: " + fileChooser.getSelectedFile());
            }
        }
        fileName = fileChooser.getSelectedFile().getPath();

        FileReader fileReader = new FileReader(fileName);
        PrintStream fileWriter = new PrintStream("Untitled.txt");
        int i;
        while((i=fileReader.read())!=-1) {
            System.out.print((char) i);
            fileWriter.write((char) i);
        }
        new StartFrame().setNameFrame(fileName);
        fileReader.close();
        fileWriter.close();
//        new StartFrame(textArea);
    }

    @Override
    public void actionPerformed( ActionEvent e ) {

    }

}





