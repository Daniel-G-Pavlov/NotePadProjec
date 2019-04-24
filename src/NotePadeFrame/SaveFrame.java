package NotePadeFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SaveFrame extends JFrame implements ActionListener {

    public SaveFrame( String fileName, JTextArea textArea ) {
        BufferedWriter bf = null;
        try {
            bf = new BufferedWriter(new FileWriter(fileName ));
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        try {
            bf.write(textArea.getText());
//            bf.write(System.out.println("\n"));
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

        BufferedWriter bfUntitled = null;
        try {
            bfUntitled = new BufferedWriter(new FileWriter("Untitled.txt" ));
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        try {
            bfUntitled.write(textArea.getText());
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        try {
            bfUntitled.flush();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        try {
            bfUntitled.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }


        BufferedWriter bfNameSave = null;
        try {
            bfNameSave = new BufferedWriter(new FileWriter("NewFileNameSave.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            bfNameSave.write(fileName);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        try {
            bfNameSave.flush();
        } catch (
                IOException e1) {
            e1.printStackTrace();
        } finally {
            try {
                if (bfNameSave != null)
                    bfNameSave.close();
            } catch (IOException e) {
            }
        }
    }

    @Override
    public void actionPerformed( ActionEvent e ) {

    }
}
