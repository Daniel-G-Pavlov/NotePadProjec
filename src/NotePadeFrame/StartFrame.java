package NotePadeFrame;

import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;

import static javax.swing.text.DefaultEditorKit.*;

public class StartFrame extends JFrame {

    public static StartFrame getScrollPane;
    public static TextArea getTextArea;
    public static String getTextField;
    FontFrame dialog = null;
    public JPanel panel = new JPanel();
    private static JTextField textField = new JTextField();
    public static int col = 1;
    public static int row = 1;
    private JFrame frame = new JFrame();
    public static JTextArea textArea = new JTextArea(10, 30);
    private JScrollPane scrollPane = new JScrollPane(textArea);
    public JLabel labelStatusBar = new JLabel();
    private JButton button = new JButton();
    public boolean dontSaveCommand = true;
    public String fileName;
    public String fontName = "Arial";
    public int fontStyle = 1;
    public int fontSize = 15;
    public String fileNameNew;
    public String nextLine;
    private Action[] textActions = {new CutAction(),
            new CopyAction(), new PasteAction(),};
    private JPopupMenu popup = new JPopupMenu();
    public PopupListener popupListener = new PopupListener();

    public StartFrame( String fileName, JTextArea textArea, JScrollPane scrollPane, JTextField textField ) throws HeadlessException {
        this.fontName = fileName;
        this.textArea = textArea;
        this.scrollPane = scrollPane;
        this.textField = textField;
    }

    public StartFrame( JTextArea textArea ) {
    }

    public static StartFrame getScrollPane( TextArea textArea ) {
        return null;
    }

    protected static void getFontFrameNew( JTextArea textArea ) {
    }

    public static void getTitle( String fileName ) {
    }


    public JTextArea getTextArea() {
        return textArea;
    }

    public void setTextArea( JTextArea textArea ) {
        this.textArea = textArea;
    }


    private static void getScrollPane( StartFrame textArea ) {
    }

    public StartFrame( JPanel panel, JLabel labelStatusBar ) throws HeadlessException {
        this.panel = panel;
        this.labelStatusBar = labelStatusBar;
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

    public StartFrame(  ){

        ReadWriteFileName();
        fileName = fileNameNew;
        MenuBar menuBar = new MenuBar();

        OldFile();
        SaveUntitledFile saveUntitledFile = new SaveUntitledFile(fileName, textArea);


        getTextArea(nextLine);

        CutCopyPastActionSupport support = new CutCopyPastActionSupport();
        support.setPopup(textArea, textField);
//        frame.setJMenuBar(menuBar);

        panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        panel.setLayout(new BorderLayout(5, 5));
        getContentPane().add(panel);
        panel.add(labelStatusBar, BorderLayout.SOUTH);
        FontFrameSet();

        TitleSet(fileName);
        setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        setVisible(true);
        repaint();

        for (Action textAction : textActions) {
            popup.add(new JMenuItem(textAction));
        }

        this.setJMenuBar(MenuBar.menuBar);
        textArea.addMouseListener(popupListener);

        MenuBar.newFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent e ) {
                NewFileFrame newFileFrame = new NewFileFrame(fileName, textArea);
            }
        });

        MenuBar.open.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent e ) {
                try {
                    OpenFrame openFrame = new OpenFrame(fileName, textArea);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });

        MenuBar.save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent e ) {
                SaveFrame saveFrame = new SaveFrame(fileName, textArea);
            }
        });

        MenuBar.saveAs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent e ) {
                try {
                    SaveAsFrame saveAsFrame = new SaveAsFrame(fileName, textArea);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });

        MenuBar.exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent e ) {
                ExitFrame exitFrame = new ExitFrame(fileName);
            }
        });

        MenuBar.find.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent e ) {
                FindFrame findFrame = new FindFrame();
            }
        });

        MenuBar.findNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent e ) {
            }
        });

        MenuBar.replace.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent e ) {
                ReplaceFrame replaceFrame = new ReplaceFrame();
            }
        });

        MenuBar.fontStyle.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {

                    if (dialog == null)
                        dialog = new FontFrame(textArea.getFont());
                    if(dialog.showDialog(StartFrame.this,"Choose a font"))
                    {
                        StartFrame.this.textArea.setFont(dialog.createFont());
                    }
                }
            });
        MenuBar.statusBar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent e ) {
                AbstractButton aButton = (AbstractButton) e.getSource();
                boolean selected = aButton.getModel().isSelected();
                StatusBarSet();
                Icon newIcon;
                if (selected) {
                    labelStatusBar.setVisible(true);
                } else {
                    labelStatusBar.setVisible(false);
                }
            }

            ;
        });

        MenuBar.aboutNotePad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent e ) {
                AboutFrame aboutFrame = new AboutFrame();

            }
        });
    }

    private void OldFile() {
        try {
            FileReader reader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(reader);
            textArea.read(bufferedReader,null);
            bufferedReader.close();
        }
        catch (Exception e){
                JOptionPane.showMessageDialog(null,e);
            }


    }

    private void ReadWriteFileName() {
        File file = new File("NewFileNameSave.txt");
        Scanner fileReader = null;
        try {
            fileReader = new Scanner(file, "windows-1251");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (fileReader.hasNextLine()) {
            fileNameNew = fileReader.nextLine();
        }
        fileReader.close();
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter("NewFileNameSave.txt"));
            writer.write(fileNameNew);
        } catch (IOException e) {
        } finally {
            try {
                if (writer != null)
                    writer.close();
            } catch (IOException e) {
            }
        }
    }

    private void TitleSet( String fileName ) {
        setTitle(fileName + " - NotePade");
        setSize(600, 500);
        setLocation(250, 30);
    }

    private void StatusBarSet() {
        textArea.addCaretListener(new CaretListener() {
            public void caretUpdate( CaretEvent e ) {
                JTextArea editArea = (JTextArea) e.getSource();

                try {
                    int caretpos = editArea.getCaretPosition();
                    row = editArea.getLineOfOffset(caretpos);
                    col = caretpos - editArea.getLineStartOffset(row);
                    row += 1;
                } catch (Exception ex) {
                }
                labelStatusBar(row, col);
                labelStatusBar.setFont(new Font(fontName, Font.BOLD, 10));
                labelStatusBar.setText("Row : " + row + "   Col : " + col);
            }
        });
    }

    public static void labelStatusBar( int row, int col ) {
    }

    private void FontFrameSet() {
        textArea.setFont(new Font(fontName, fontStyle, fontSize));
        panel.add(scrollPane, BorderLayout.CENTER);
    }

    public void getTextArea(String nextLine) {

        File file = new File("Untitled.txt");



    }




    public JMenuBar getJMenuBar() {
        return MenuBar.menuBar;
    }

    public JComponent getCutAction( String cutAction ) {
        return panel;
    }

    public void setNameFrame( String fileName ) {
    }

    public class PopupListener extends MouseAdapter {
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

    public static class setNameFrame {
        public setNameFrame( String fileName ) {
        }
    }
}

