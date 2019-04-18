package NotePadeFrame;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.text.DefaultEditorKit;
import javax.swing.text.JTextComponent;
import javax.swing.text.TextAction;
import java.awt.*;
import java.awt.event.*;

public class StartFrame extends JFrame {

    private JFrame frame = new JFrame();
    private JPanel panel = new JPanel();
    private JPanel statusPanel = new JPanel();
    private String status = " kl ";
    private int col = 0;
    private int row = 0;
    private JTextArea textArea = new JTextArea(10, 30);
    private JScrollPane scrollPane = new JScrollPane(textArea);
    private JLabel label = new JLabel();
    private JButton button = new JButton();
    public boolean dontSaveCommand = true;
    public String fileName = "Untitled";
    public String fontName;
    public int fontSize;
    public String fontNameModif = "Arial";
    public int fontSizeModif = 15;
//    public Font font = new Font(fontName, java.awt.Font.BOLD,fontSize);


    private JMenuBar menuBar;
    private JMenu file, edit, format, view, help;
    private JMenuItem newFile, open, save, saveAs, exit;
    private JMenuItem cut, copy, paste, delete, find, findNext, replace;
    private JMenuItem fontStyle;
    private JCheckBoxMenuItem statusBar;
    private JMenuItem aboutNotePad;
    private Action[] textActions = {new DefaultEditorKit.CutAction(),
            new DefaultEditorKit.CopyAction(), new DefaultEditorKit.PasteAction(),};
    private JPopupMenu popup = new JPopupMenu();
    private PopupListener popupListener = new PopupListener();

    private static String CUT_ACTION_NAME = "cut";
    private static String COPY_ACTION_NAME = "copy";
    private static String PASTE_ACTION_NAME = "paste";

    public StartFrame( JTextArea textArea, JScrollPane scrollPane ) throws HeadlessException {
        this.textArea = textArea;
        this.scrollPane = scrollPane;
    }

    public JTextArea getTextArea() {
        return textArea;
    }

    public void setTextArea( JTextArea textArea ) {
        this.textArea = textArea;
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    public void setScrollPane( JScrollPane scrollPane ) {
        this.scrollPane = scrollPane;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName( String fileName ) {
        this.fileName = fileName;
    }

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
        statusBar = new JCheckBoxMenuItem("Status Bar");

        help = new JMenu("Help");
        aboutNotePad = new JMenuItem("About NotePad");

        setTitle(fileName + " - NotePade");
        setSize(600, 500);
        setLocation(250, 30);

        panel.setLayout(new BorderLayout());

        statusPanel.setBorder(new BevelBorder(BevelBorder.LOWERED));
        statusPanel.setPreferredSize(new Dimension(panel.getWidth(), 22));
        JLabel statusLabel = new JLabel("Row " + row + " , Col " + col);
//        statusPanel.add(statusLabel);
        panel.add(statusPanel, BorderLayout.SOUTH);

        fontName = fontNameModif;
        fontSize = fontSizeModif;
        textArea.setEditable(true);
        textArea.setFont(new Font(fontName, Font.BOLD, fontSize));
        textArea.addMouseListener(popupListener);
        JScrollPane scrollPane = new JScrollPane(textArea);



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

        for (Action textAction : textActions) {



            popup.add(new JMenuItem(textAction));
        }

        scrollPane.isMaximumSizeSet();
        panel.add(scrollPane);
        getContentPane().add(panel);



        this.setJMenuBar(menuBar);

        panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        panel.setLayout(new BorderLayout(5, 5));
        panel.add(scrollPane, BorderLayout.CENTER);

        frame.setLocationByPlatform(true);

        setDefaultCloseOperation(StartFrame.EXIT_ON_CLOSE);
        setVisible(true);
        repaint();


        newFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent e ) {
                NewFileFrame newFileFrame = new NewFileFrame(fileName);
                System.out.println("textarae");
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
                SaveFrame saveFrame = new SaveFrame(fileName);
            }
        });

        saveAs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent e ) {
                SaveAsFrame saveAsFrame = new SaveAsFrame(fileName);
            }
        });

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent e ) {
                ExitFrame exitFrame = new ExitFrame(fileName);

            }
        });

        cut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent e ) {

                CutFram cutFram = new CutFram("Cut");





            }
        });

        copy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent e ) {
                CopyFrame copyFrame = new CopyFrame();


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

            //            public  String fontNameModif;
//            public  int fontSizeModif;
            @Override
            public void actionPerformed( ActionEvent e ) {
                FontFrame fontFrame = new FontFrame();


                fontNameModif = fontFrame.setFontName();
                fontSizeModif = fontFrame.setFontSize();

                Font font = new Font(fontNameModif, java.awt.Font.BOLD, fontSizeModif);

                System.out.println(font);

            }
        });

        statusBar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent e ) {
                statusPanel.add(statusLabel);
                panel.add(statusPanel);
                statusPanel.setVisible(true);
                System.out.println("dffd");
            }
        });

        aboutNotePad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent e ) {
                AboutFrame aboutFrame = new AboutFrame();
            }
        });

    }


    public JComponent getCutAction() {
        return panel;
    }

    class PopupListener extends MouseAdapter {
        public void mousePressed( MouseEvent e ) {
            maybeShowPopup(e);
        }

        public void mouseReleased( MouseEvent e ) {
            maybeShowPopup(e);
        }

        private void maybeShowPopup( MouseEvent e ) {
            if (e.isPopupTrigger()) {
                popup.show(e.getComponent(),
                        e.getX(), e.getY());
            }
        }
    }

    public class CutFram extends TextAction {

        public CutFram( String name ) {
            super(name);
        }

        @Override
        public void actionPerformed( ActionEvent e ) {
            popup.add(new JMenuItem((Action) getCutAction()));
            JTextComponent target = getTextComponent(e);
            if (target != null) {
                target.cut();
            }
            getCutAction();
        }

    }


}

