package NotePadeFrame;

import javafx.scene.control.Labeled;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class StartFrame extends JFrame {

    FontFrame dialog = null;

    public static String setFileName;
    public static String setFontName;
    public static int setFontSize;

    private JPanel panel = new JPanel();
    private JTextField textField = new JTextField();
    private String status = " kl ";
    public static int col = 1;
    public static int row = 1;
    private JFrame frame = new JFrame();
    private JTextArea textArea = new JTextArea(10, 30);
    private JScrollPane scrollPane = new JScrollPane(textArea);
    private JLabel labelStatusBar = new JLabel();
    private JButton button = new JButton();
    public boolean dontSaveCommand = true;
    public String fileName = "Untitled";
    public String fontName;
    public int fontSize;
    private Action[] textActions = {new DefaultEditorKit.CutAction(),
            new DefaultEditorKit.CopyAction(), new DefaultEditorKit.PasteAction(),};
    private JPopupMenu popup = new JPopupMenu();
    public PopupListener popupListener = new PopupListener();


    public StartFrame(JTextArea textArea) throws HeadlessException {
        this.textArea = textArea;
    }

    private static String CUT_ACTION_NAME = "cut";
    private static String COPY_ACTION_NAME = "copy";
    private static String PASTE_ACTION_NAME = "paste";

    public StartFrame(JTextArea textArea, JScrollPane scrollPane) throws HeadlessException {
        this.textArea = textArea;
        this.scrollPane = scrollPane;
    }

    public static void getScrollPane(TextArea textArea) {
    }

    protected static void getFontFrameNew(JTextArea textArea) {
    }

    protected static void getScrollPane(JTextArea textArea) {
    }

    public void setTextArea(JTextArea textArea) {
        this.textArea = textArea;
    }

    public void setScrollPane(JScrollPane scrollPane) {
        this.scrollPane = scrollPane;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public StartFrame(JScrollPane scrollPane) throws HeadlessException {
        this.scrollPane = scrollPane;
    }

    public StartFrame() {

        super("Font");

        MenuBar menuBar = new MenuBar();

        panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        panel.setLayout(new BorderLayout(5, 5));
        getContentPane().add(panel);
        panel.add(labelStatusBar, BorderLayout.SOUTH);
        FontFrameSet();

        setTitle(fileName + " - NotePade");
        setSize(600, 500);
        setLocation(250, 30);

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
            public void actionPerformed(ActionEvent e) {
                NewFileFrame newFileFrame = new NewFileFrame(fileName);
                System.out.println("textarae");
            }
        });

        MenuBar.open.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    OpenFrame openFrame = new OpenFrame(fileName);
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

                JTextArea textArea = new JTextArea();
//                 getReadFile(fileReader);

                textArea.setEditable(true);
                textArea.setFont(new Font(StartFrame.setFontName, Font.BOLD, StartFrame.setFontSize));
                textArea.addMouseListener(popupListener);
                StartFrame.getScrollPane(textArea);

            }
        });

        MenuBar.save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SaveFrame saveFrame = new SaveFrame(fileName);
            }
        });

        MenuBar.saveAs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SaveAsFrame saveAsFrame = new SaveAsFrame(fileName);
            }
        });

        MenuBar.exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ExitFrame exitFrame = new ExitFrame(fileName);

            }
        });

        MenuBar.cut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                CutFram cutFram = new CutFram("Cut");

            }
        });

        MenuBar.copy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CopyFrame copyFrame = new CopyFrame();


            }
        });

        MenuBar.paste.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        MenuBar.delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        MenuBar.find.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FindFrame findFrame = new FindFrame();
            }
        });

        MenuBar.findNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        MenuBar.replace.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ReplaceFrame replaceFrame = new ReplaceFrame();
            }
        });

        MenuBar.fontStyle.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
//                FontFrame fontFrame = new FontFrame();

                if (dialog == null)
                    dialog = new FontFrame(textArea.getFont());
                if(dialog.showDialog(StartFrame.this,"Choose a font"))
                {
                    StartFrame.this.textArea.setFont(dialog.createFont());
                }


//                fontName = FontFrame.getFontName();
//                fontSize = FontFrame.getFontSize();
            }
        });

        MenuBar.statusBar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AbstractButton aButton = (AbstractButton) e.getSource();
                boolean selected = aButton.getModel().isSelected();
                StatusBarSet();
                Icon newIcon;
                if (selected) {
                    labelStatusBar.setVisible(true);
                } else {
                    labelStatusBar.setVisible(false);
                }
            };
        });

        MenuBar.aboutNotePad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AboutFrame aboutFrame = new AboutFrame();

            }

        });


    }

    private void StatusBarSet() {
        textArea.addCaretListener(new CaretListener() {
            public void caretUpdate(CaretEvent e) {
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
//                labelStatusBar.setVisible(true);
            }
        });
    }

    public static void labelStatusBar(int row, int col) {
    }


    private void FontFrameSet() {
//        fontName = FontFrame.getFontName();
//        fontSize = FontFrame.getFontSize();
        textArea.setFont(new Font(fontName, Font.BOLD, fontSize));
        panel.add(scrollPane, BorderLayout.CENTER);
    }

    public JMenuBar getJMenuBar() {
        return MenuBar.menuBar;
    }

    public JComponent getCutAction() {
        return panel;
    }

    public void setNameFrame(String fileName) {
    }

    public class PopupListener extends MouseAdapter {
        public void mousePressed(MouseEvent e) {
            maybeShowPopup(e);
        }

        public void mouseReleased(MouseEvent e) {
            maybeShowPopup(e);
        }

        private void maybeShowPopup(MouseEvent e) {
            if (e.isPopupTrigger()) {
                popup.show(e.getComponent(),
                        e.getX(), e.getY());
            }
        }
    }

    public class CutFram extends TextAction {

        public CutFram(String name) {
            super(name);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            popup.add(new JMenuItem((Action) getCutAction()));
            JTextComponent target = getTextComponent(e);
            if (target != null) {
                target.cut();
            }
            getCutAction();
        }

    }

}

