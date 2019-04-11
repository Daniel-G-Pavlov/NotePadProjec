package NotePadeFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartFrame extends JFrame {

    public JPanel panel = new JPanel();
    public JLabel[][] indexRowCol;
    public JTextArea textArea = new JTextArea();
    public JScrollPane scrollPane = new JScrollPane(textArea);
    private JLabel label = new JLabel();
    private JButton button = new JButton();
    private JButton buttonNewFile;
    String fileName = "Untitled";

    JMenuBar menuBar;
    JMenu file,edit,format,view,help;
    JMenuItem newFile,open,save,saveAs, exit;
    JMenuItem cut,copy,paste,delete,find,findNext,replace;
    JMenuItem fontStyle;
    JMenuItem statusBar;
    JMenuItem aboutNotePad;


    public StartFrame() {

        menuBar = new JMenuBar();

        file = new JMenu("File");
        newFile = new JMenuItem("New");
        open = new JMenuItem("Open");
        save = new JMenuItem("Save");
        saveAs = new JMenuItem("Save As...");
        exit = new JMenuItem("Exit");

        edit = new JMenu("Edit");
        cut = new JMenuItem("Cut");
        copy = new JMenuItem("Copy");
        paste = new JMenuItem("Paste");
        delete = new JMenuItem("Delete");
        find = new JMenuItem("Find");
        findNext = new JMenuItem("Find Next");
        replace = new JMenuItem("Replace...");

        format = new JMenu("Formate");
        fontStyle = new JMenuItem("Font");

        view = new JMenu("View");
        statusBar = new JMenuItem("Status Bar");

        help = new JMenu("Help");
        aboutNotePad = new JMenuItem("About NotePad");

        setTitle(fileName + " - NotePade");
        setSize(600, 500);
        setLocation(250, 30);
//        panel.setLayout(null);
        getContentPane().add(panel);
        getContentPane().add(scrollPane);

        menuBar.add(file);
        file.add(newFile);
        file.add(open);
        file.add(save);
        file.add(saveAs);
        file.add(exit);

        menuBar.add(edit);
        edit.add(cut);
        edit.add(copy);
        edit.add(paste);
        edit.add(delete);
        edit.add(find);
        edit.add(findNext);
        edit.add(replace);

        menuBar.add(format);
        format.add(fontStyle);

        menuBar.add(view);
        view.add(statusBar);

        menuBar.add(help);
        help.add(aboutNotePad);

        this.setJMenuBar(menuBar);

        setDefaultCloseOperation(StartFrame.EXIT_ON_CLOSE);
//        setResizable(false);
        setVisible(true);
        repaint();





        newFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent e ) {
                NewFileFrame newFileFrame = new NewFileFrame();
            }
        });

        open.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent e ) {
                OpenFrame openFrame = new OpenFrame();
            }
        });

        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent e ) {
                SaveFrame saveFrame = new SaveFrame();
            }
        });

        saveAs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent e ) {
                SaveAsFrame saveAsFrame = new SaveAsFrame();
            }
        });

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent e ) {
                ExitFrame exitFrame = new ExitFrame();

            }
        });

        cut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent e ) {

            }
        });

        copy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent e ) {

            }
        });

        paste.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent e ) {

            }
        });

        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent e ) {

            }
        });

        find.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent e ) {
                FindFrame findFrame = new FindFrame();
            }
        });

        findNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent e ) {

            }
        });

        replace.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent e ) {
                ReplaceFrame replaceFrame = new ReplaceFrame();
            }
        });

        fontStyle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent e ) {
                FontFrame fontFrame = new FontFrame();
            }
        });

        statusBar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent e ) {
                StatusBar statusBar = new StatusBar();






            }
        });

        aboutNotePad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent e ) {
                AboutFrame aboutFrame = new AboutFrame();
            }
        });
    }
}

