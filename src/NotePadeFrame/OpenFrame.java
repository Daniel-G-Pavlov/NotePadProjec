package NotePadeFrame;

import javax.swing.*;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;

import static NotePadeFrame.StartFrame.getScrollPane;
import static NotePadeFrame.StartFrame.getTextArea;
import static NotePadeFrame.StartFrame.getTextField;

public class OpenFrame extends JFrame implements ActionListener {
    private JPanel panel = new JPanel();
    private JLabel label = new JLabel();
    private JButton button = new JButton();
    private JFileChooser fileChooser = new JFileChooser();
    private JMenuBar menuBar = new JMenuBar();
    private JTextArea textArea = new JTextArea();
    private JButton buttonOpenFile;


    public OpenFrame( String fileName, JTextArea textArea ) throws IOException {

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

        File file = new File(fileName);
        Scanner fileReader = new Scanner(file, "windows-1251");

        int lineNumber = 0;
        while (fileReader.hasNextLine()) {
            lineNumber++;
            System.out.printf("Line %d: %s%n", lineNumber, fileReader.nextLine());
        }
        new StartFrame.setNameFrame(fileName);
        fileReader.close();
    }

    @Override
    public void actionPerformed( ActionEvent e ) {

    }

}





