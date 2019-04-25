package NotePadeFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import static NotePadeFrame.StartFrame.textArea;

public class SaveUntitledFile  implements ActionListener{

    SaveUntitledFile(String fileName, JTextArea textArea) {

        BufferedWriter bfUntitled = null;
        try {
            bfUntitled = new BufferedWriter(new FileWriter("Untitled.txt"));
        } catch (
                IOException e1) {
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
    }
    @Override
    public void actionPerformed( ActionEvent e ) {

    }

}
