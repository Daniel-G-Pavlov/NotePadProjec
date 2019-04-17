package NotePadeFrame;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class StartFrame extends JFrame {

    protected JFrame frame = new JFrame();
    protected JPanel panel = new JPanel();
    protected JPanel statusPanel = new JPanel();
    protected String status = " kl ";
    private int col = 0;
    private int row = 0;
    protected JTextArea textArea = new JTextArea();
    protected JScrollPane scrollPane = new JScrollPane(textArea);
    protected JLabel label = new JLabel();
    protected JButton button = new JButton();
    public boolean dontSaveCommand = true;
    public String fileName = "Untitled";
    public String fontName;
    public int fontSize;
    public String fontNameModif = "Arial";
    public int fontSizeModif = 15;
//    public Font font = new Font(fontName, java.awt.Font.BOLD,fontSize);


    protected JMenuBar menuBar;
    protected JMenu file,edit,format,view,help;
    protected JMenuItem newFile,open,save,saveAs, exit;
    protected JMenuItem cut,copy,paste,delete,find,findNext,replace;
    protected JMenuItem fontStyle;
    protected JCheckBoxMenuItem statusBar;
    protected JMenuItem aboutNotePad;

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

    public  StartFrame() {

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

        TextArraiPane();

        getContentPane().add(panel);

        FontChois();

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

//            public  String fontNameModif;
//            public  int fontSizeModif;
            @Override
            public void actionPerformed( ActionEvent e ) {
                FontFrame fontFrame = new FontFrame();


                fontNameModif = fontFrame.setFontName();
                fontSizeModif = fontFrame.setFontSize();

                Font font = new Font(fontNameModif,java.awt.Font.BOLD,fontSizeModif);
                TextArraiPane();

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

    public  void TextArraiPane() {
        fontName =  fontNameModif;
        fontSize =  fontSizeModif;
        textArea.setFont(new Font(fontName, Font.BOLD,fontSize));
        JScrollPane scrollPane = new JScrollPane(textArea);
        panel.add(scrollPane);
        getContentPane().add(panel);
    }

    private void FontChois () {


    }

}

