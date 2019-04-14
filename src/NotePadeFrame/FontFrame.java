package NotePadeFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FontFrame extends StartFrame{

    private JPanel panelFrame = new JPanel();
    private JLabel labelFontFrameSample = new JLabel();

        public  FontFrame() {


        GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        String[] fontFamilyNames = graphicsEnvironment.getAvailableFontFamilyNames();
        JComboBox comboBox = new JComboBox<>(fontFamilyNames);
        comboBox.setVisible(true);
        comboBox.setBounds(50, 50, 200, 20);
        comboBox.setSelectedItem(0);
        panelFrame.add(comboBox);

        GraphicsEnvironment graphicsEnvironmentSize = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Integer[] ListFontSize = {8, 9, 10, 11, 12, 14, 16, 18, 20, 22, 24, 26, 28, 36, 48, 72};
        JComboBox comboBoxSize = new JComboBox(ListFontSize);
        comboBoxSize.setVisible(true);
        comboBoxSize.setBounds(320, 50, 60, 20);
        comboBoxSize.setSelectedItem(0);
        panelFrame.add(comboBoxSize);
        comboBoxSize.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged( ItemEvent e ) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    fontSize = comboBoxSize.getSelectedItem().hashCode();
                    labelFontFrameSample.setFont(new Font(fontName, Font.PLAIN, fontSize));

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

                }
            }
        });
        pack();

        labelFontFrameSample.setBounds(50, 240, 360, 72);
        labelFontFrameSample.setText("AaBbCcFf");
        labelFontFrameSample.setFont(new Font(fontName, Font.PLAIN, 48));
        labelFontFrameSample.setVisible(true);
        panelFrame.add(labelFontFrameSample);

        setTitle("Font");
        setSize(450, 420);
        setLocation(350, 80);
        panelFrame.setLayout(null);
        getContentPane().add(panelFrame);

        LableFont(50, 30, 60, 10, "Font");
        LableFont(320, 30, 60, 10, "Size");
        LableFont(50, 220, 60, 20, "Sample");

        ScrollPaneFont(50, 70, 200, 148);
        ScrollPaneFont(320, 70, 63, 148);

        JButton okButton = new JButton();
        okButton.setText("OK");
        okButton.setBounds(140, 350, 100, 30);
        okButton.setVisible(true);
        panelFrame.add(okButton);

        JButton canselButton = new JButton();
        canselButton.setText("Cansel");
        canselButton.setBounds(285, 350, 100, 30);
        canselButton.setVisible(true);
        panelFrame.add(canselButton);

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
            public void actionPerformed(ActionEvent e) {
                cancelClicked();
            }
        });

//        return (Font) font;

    }

    private void ScrollPaneFont( int i, int y, int i2, int y2 ) {
        JScrollPane scrollPaneFont = new JScrollPane();
        scrollPaneFont.setBounds(i, y, i2, y2);
        scrollPaneFont.setVisible(true);
        scrollPaneFont.createVerticalScrollBar();
        panelFrame.add(scrollPaneFont);
    }

    private void LableFont( int i, int y, int i2, int y2, String font ) {
        JLabel labelFont = new JLabel();
        labelFont.setBounds(i, y, i2, y2);
        labelFont.setText(font);
        labelFont.setVisible(true);
        panelFrame.add(labelFont);
    }




    private void cancelClicked() {
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }
}
