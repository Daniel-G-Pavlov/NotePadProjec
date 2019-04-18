package NotePadeFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FontFrame extends JFrame {

    protected JFrame fontFrame = new JFrame();
    protected JPanel fontPanel = new JPanel();
    protected JLabel labelFontFrameSample = new JLabel();
    public static String fontName ;
    public static int fontSize ;
    public Font font = new Font(fontName, java.awt.Font.BOLD,fontSize);

    public FontFrame( String fontName, int fontSize, Font font ) throws HeadlessException {
        this.fontName = fontName;
        this.fontSize = fontSize;
        this.font = font;
    }

    public static String getFontName() {
        return fontName;
    }

    public void setFontName( String fontName ) {
        this.fontName = fontName;
    }

    public static int getFontSize() {
        return fontSize;
    }

    public void setFontSize( int fontSize ) {
        this.fontSize = fontSize;
    }

    @Override
    public Font getFont() {
        return font;
    }

    @Override
    public void setFont( Font font ) {
        this.font = font;
    }

    public  FontFrame() {


        GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        String[] fontFamilyNames = graphicsEnvironment.getAvailableFontFamilyNames();
        JComboBox comboBox = new JComboBox<>(fontFamilyNames);
        comboBox.setVisible(true);
        comboBox.setBounds(50, 50, 200, 20);
        comboBox.setSelectedItem(0);
        fontPanel.add(comboBox);

        GraphicsEnvironment graphicsEnvironmentSize = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Integer[] ListFontSize = {8, 9, 10, 11, 12, 14, 16, 18, 20, 22, 24, 26, 28, 36, 48, 72};
        JComboBox comboBoxSize = new JComboBox(ListFontSize);
        comboBoxSize.setVisible(true);
        comboBoxSize.setBounds(320, 50, 60, 20);
        comboBoxSize.setSelectedItem(0);
        fontPanel.add(comboBoxSize);

        comboBoxSize.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged( ItemEvent e ) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    fontSize = comboBoxSize.getSelectedItem().hashCode();
                    labelFontFrameSample.setFont(new Font(fontName, Font.PLAIN, fontSize));
                    Font font = new Font(fontName, Font.PLAIN, fontSize);
//                    textArea.setFont(new Font(fontName, Font.PLAIN, fontSize));
//                    textArea.getFont();
                    System.out.println("nowo "+ font);
                }
            }
        });
        pack();

        comboBox.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged( ItemEvent e ) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    fontName = comboBox.getSelectedItem().toString();
                    labelFontFrameSample.setFont(new Font(fontName, Font.PLAIN, fontSize));
                    Font font = new Font(fontName, Font.PLAIN, fontSize);
//                    textArea.setFont(new Font(fontName, Font.PLAIN, fontSize));
//                    textArea.getFont();
                    System.out.println("nowo "+ font);
                }
            }
        });
        pack();

        labelFontFrameSample.setBounds(50, 240, 360, 72);
        labelFontFrameSample.setText("AaBbCcFf");
        labelFontFrameSample.setFont(new Font(fontName, Font.PLAIN, 48));
        labelFontFrameSample.setVisible(true);
        fontPanel.add(labelFontFrameSample);

        setTitle("Font");
        setSize(450, 420);
        setLocation(350, 80);
        fontPanel.setLayout(null);
        getContentPane().add(fontPanel);

        LableFont(50, 30, 60, 10, "Font");
        LableFont(320, 30, 60, 10, "Size");
        LableFont(50, 220, 60, 20, "Sample");

        ScrollPaneFont(50, 70, 200, 148);
        ScrollPaneFont(320, 70, 63, 148);

        JButton okButton = new JButton();
        okButton.setText("OK");
        okButton.setBounds(140, 350, 100, 30);
        okButton.setVisible(true);
        fontPanel.add(okButton);

        JButton canselButton = new JButton();
        canselButton.setText("Cansel");
        canselButton.setBounds(285, 350, 100, 30);
        canselButton.setVisible(true);
        fontPanel.add(canselButton);

        setDefaultCloseOperation(FontFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        repaint();

        canselButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancelClicked();
            }
        });

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {
//                TextPaneFrame textPaneFrame = new TextPaneFrame();

                okClicked();
            }

        });

    }

    private void ScrollPaneFont( int i, int y, int i2, int y2 ) {
        JScrollPane scrollPaneFont = new JScrollPane();
        scrollPaneFont.setBounds(i, y, i2, y2);
        scrollPaneFont.setVisible(true);
        scrollPaneFont.createVerticalScrollBar();
        fontPanel.add(scrollPaneFont);
    }

    private void LableFont( int i, int y, int i2, int y2, String font ) {
        JLabel labelFont = new JLabel();
        labelFont.setBounds(i, y, i2, y2);
        labelFont.setText(font);
        labelFont.setVisible(true);
        fontPanel.add(labelFont);
    }

    public int setFontSize() {
        return fontSize;
    }

    public String setFontName() {
        return fontName;
    }


    private void cancelClicked() {
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }
    private void okClicked() {
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }

}
