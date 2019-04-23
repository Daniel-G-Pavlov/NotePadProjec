package NotePadeFrame;

import javax.swing.*;

public class Aplication {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
           public void run() {
               StartFrame startFrame = new StartFrame();
           }
       });
    }
}