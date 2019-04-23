package NotePadeFrame;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import javax.xml.soap.Text;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static com.sun.java.accessibility.util.AWTEventMonitor.addActionListener;

public class SaveFrame extends JFrame implements ActionListener {
    private JPanel panel = new JPanel();
    private JLabel label = new JLabel();
    private JButton button = new JButton();
    private JFileChooser fileChooser = new JFileChooser();
    private JMenuBar menuBar = new JMenuBar();
    private JTextArea textArea = new JTextArea();
    private JButton buttonSaveFile;

    public SaveFrame( String fileName, JTextArea textArea  ) {

      System.out.println(fileName);

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

    }

    @Override
    public void actionPerformed( ActionEvent e ) {

    }
}
