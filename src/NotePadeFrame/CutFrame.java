package NotePadeFrame;


import javax.swing.*;
import javax.swing.text.JTextComponent;
import javax.swing.text.TextAction;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;

import static javax.swing.text.DefaultEditorKit.cutAction;

public class CutFrame extends TextAction {

    public CutFrame() {
        super(cutAction);



    }

    /**
     * Creates a new JTextAction object.
     *
     * @param name the name of the action
     */
    public CutFrame( String name ) {
        super(name);
    }

    @Override
    public void actionPerformed( ActionEvent e ) {

    }

}

