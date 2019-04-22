package NotePadeFrame;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class FontFrame extends JPanel{
    private Font thisFont;
    private JList jFace, jStyle, jSize;
    private JDialog dialog;
    private JButton okButton;
    JTextArea textArea;
    private boolean ok;

    public FontFrame(Font withFont) {
        thisFont = withFont;

        String[] fontNames =
                GraphicsEnvironment
                        .getLocalGraphicsEnvironment()
                        .getAvailableFontFamilyNames();
        jFace = new JList(fontNames);
        jFace.setSelectedIndex(0);

        jFace.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent ev) {
                textArea.setFont(createFont());
            }
        });

        String[] fontStyles = {"Regular", "Italic", "Bold", "Bold Italic"};
        jStyle = new JList(fontStyles);
        jStyle.setSelectedIndex(0);

        jStyle.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent ev) {
                textArea.setFont(createFont());
            }
        });

        String[] fontSizes = new String[30];
        for (int j = 0; j < 30; j++)
            fontSizes[j] = new String(10 + j * 2 + "");
        jSize = new JList(fontSizes);
        jSize.setSelectedIndex(0);

        jSize.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent ev) {
                textArea.setFont(createFont());
            }
        });

        JPanel panelLabel = new JPanel();
        panelLabel.setLayout(new GridLayout(1, 3));

        panelLabel.add(new JLabel("Font", JLabel.CENTER));
        panelLabel.add(new JLabel("Font Style", JLabel.CENTER));
        panelLabel.add(new JLabel("Size", JLabel.CENTER));

        JPanel panelList = new JPanel();
        panelList.setLayout(new GridLayout(1, 3));

        panelList.add(new JScrollPane(jFace));
        panelList.add(new JScrollPane(jStyle));
        panelList.add(new JScrollPane(jSize));

        okButton = new JButton("        OK        ");
        JButton cancelButton = new JButton("     Cancel    ");

        okButton.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent ev) {
                        ok = true;
                        FontFrame.this.thisFont = FontFrame.this.createFont();
                        dialog.setVisible(false);
                    }
                });

        cancelButton.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent ev) {
                        dialog.setVisible(false);
                    }
                });

        JPanel panelButton = new JPanel();
        panelButton.setLayout(new FlowLayout());
        panelButton.add(okButton);
        panelButton.add(new JLabel("                         "));
        panelButton.add(cancelButton);

        textArea = new JTextArea(10, 25);
        JPanel panelTextField = new JPanel();
        panelTextField.add(new JScrollPane(textArea));

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(2, 1));
        centerPanel.add(panelList);
        centerPanel.add(panelTextField);

        setLayout(new BorderLayout());
        add(panelLabel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(panelButton, BorderLayout.SOUTH);

        add(new JLabel("  "), BorderLayout.EAST);
        add(new JLabel("  "), BorderLayout.WEST);

        textArea.setFont(thisFont);
        textArea.append("\nAaBbCcDdEeFf");
    }

    public Font createFont() {
        Font fnt = thisFont;
        int fontstyle = Font.PLAIN;
        int x = jStyle.getSelectedIndex();

        switch (x) {
            case 0:
                fontstyle = Font.PLAIN;
                break;
            case 1:
                fontstyle = Font.ITALIC;
                break;
            case 2:
                fontstyle = Font.BOLD;
                break;
            case 3:
                fontstyle = Font.BOLD + Font.ITALIC;
                break;
        }

        int fontsize = Integer.parseInt((String) jSize.getSelectedValue());
        String fontname = (String) jFace.getSelectedValue();

        fnt = new Font(fontname, fontstyle, fontsize);

        return fnt;

    }

    public boolean showDialog(Component parent, String title) {
        ok = false;

        Frame owner = null;
        if (parent instanceof Frame)
            owner = (Frame) parent;
        else
            owner = (Frame) SwingUtilities.getAncestorOfClass(Frame.class, parent);
        if (dialog == null || dialog.getOwner() != owner) {
            dialog = new JDialog(owner, true);
            dialog.add(this);
            dialog.getRootPane().setDefaultButton(okButton);
            dialog.setSize(500, 425);
        }

        dialog.setTitle(title);
        dialog.setVisible(true);
        return ok;
    }
}