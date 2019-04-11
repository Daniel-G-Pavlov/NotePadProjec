package NotePadeFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class FontFrame extends JFrame {


    private JPanel panel = new JPanel();
    public JLabel labelFontSample = new JLabel();
    public String fontName;
    public int fontSize = 12;

    public FontFrame() {

        GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        String[] fontFamilyNames = graphicsEnvironment.getAvailableFontFamilyNames();
        JComboBox comboBox = new JComboBox<>(fontFamilyNames);
        comboBox.setVisible(true);
        comboBox.setBounds(50, 50, 200, 20);
        comboBox.setSelectedItem(0);
        panel.add(comboBox);

        GraphicsEnvironment graphicsEnvironmentSize = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Integer[] ListFontSize = {8, 9, 10, 11, 12, 14, 16, 18, 20, 22, 24, 26, 28, 36, 48, 72};
        JComboBox comboBoxSize = new JComboBox(ListFontSize);
        comboBoxSize.setVisible(true);
        comboBoxSize.setBounds(320, 50, 60, 20);
        comboBoxSize.setSelectedItem(0);
        panel.add(comboBoxSize);
        comboBoxSize.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged( ItemEvent e ) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    fontSize = comboBoxSize.getSelectedItem().hashCode();
                    labelFontSample.setFont(new Font(fontName, Font.PLAIN, fontSize));

                }
            }
        });
        pack();

        comboBox.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged( ItemEvent e ) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    fontName = comboBox.getSelectedItem().toString();
                    labelFontSample.setFont(new Font(fontName, Font.PLAIN, fontSize));

                }
            }
        });
        pack();

        labelFontSample.setBounds(50, 240, 360, 72);
        labelFontSample.setText("AaBbCcFf");
        labelFontSample.setFont(new Font(fontName, Font.PLAIN, 48));
        labelFontSample.setVisible(true);
        panel.add(labelFontSample);

        setTitle("Font");
        setSize(450, 420);
        setLocation(350, 80);
        panel.setLayout(null);
        getContentPane().add(panel);

        LableFont(50, 30, 60, 10, "Font");
        LableFont(320, 30, 60, 10, "Size");
        LableFont(50, 220, 60, 20, "Sample");

        ScrollPaneFont(50, 70, 200, 148);
        ScrollPaneFont(320, 70, 63, 148);

        ButtonOK("OK", 140);
        ButtonOK("Cancel", 300);

        setDefaultCloseOperation(FontFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        repaint();
    }

    private void ScrollPaneFont( int i, int y, int i2, int y2 ) {
        JScrollPane scrollPaneFont = new JScrollPane();
        scrollPaneFont.setBounds(i, y, i2, y2);
        scrollPaneFont.setVisible(true);
        scrollPaneFont.createVerticalScrollBar();
        panel.add(scrollPaneFont);
    }

    private void ButtonOK( String ok, int i ) {
        JButton buttonOK = new JButton();
        buttonOK.setText(ok);
        buttonOK.setBounds(i, 350, 100, 30);
        buttonOK.setVisible(true);
        panel.add(buttonOK);
    }

    private void LableFont( int i, int y, int i2, int y2, String font ) {
        JLabel labelFont = new JLabel();
        labelFont.setBounds(i, y, i2, y2);
        labelFont.setText(font);
        labelFont.setVisible(true);
        panel.add(labelFont);
    }
}