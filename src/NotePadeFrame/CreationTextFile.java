package NotePadeFrame;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CreationTextFile extends NewFileFrame {

    public CreationTextFile( String fileName , TextArea textArea ){


        JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        fileChooser.setDialogTitle("Choose a directory to save your file: ");
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        int returnValue = fileChooser.showSaveDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            if (fileChooser.getSelectedFile().isDirectory()) {
                System.out.println("You selected the directory: " + fileChooser.getSelectedFile());
            }
        }

    }

    public CreationTextFile( String fileName, JTextArea textArea ) {
        super(fileName, textArea);
    }

    @Override
    public void actionPerformed( ActionEvent e ) {

    }
}
