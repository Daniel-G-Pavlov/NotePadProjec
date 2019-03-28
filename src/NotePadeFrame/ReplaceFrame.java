package NotePadeFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReplaceFrame extends JFrame{

    private JPanel panel = new JPanel();
    private JLabel fineWhatLable = new JLabel();
    private JTextPane fineWhatPane = new JTextPane();
    private JLabel replaceWithLabel = new JLabel();
    private JTextPane replaceWithPane = new JTextPane();
    private JButton findNextButton = new JButton();
    private JButton replaceButton = new JButton();
    private JButton replaceAllButton = new JButton();
    private JButton cancelButton = new JButton();
    private JCheckBox matchCase = new JCheckBox();

    public ReplaceFrame (){

        setTitle("Replace");
        setSize(480, 200);
        setLocation(350, 80);
        panel.setLayout(null);
        getContentPane().add(panel);

        fineWhatLable.setText("Find what");
        fineWhatLable.setBounds(20,20,90,20);
        fineWhatLable.setVisible(true);
        panel.add(fineWhatLable);

        fineWhatPane.setText("");
        fineWhatPane.setBounds(110,20,200,20);
        fineWhatPane.setVisible(true);
        panel.add(fineWhatPane);

        replaceWithLabel.setText("Replace with");
        replaceWithLabel.setBounds(20,50,90,20);
        replaceWithLabel.setVisible(true);
        panel.add(replaceWithLabel);

        replaceWithPane.setText("");
        replaceWithPane.setBounds(110,50,200,20);
        replaceWithPane.setVisible(true);
        panel.add(replaceWithPane);

        findNextButton.setText("Find Next");
        findNextButton.setBounds(350,20,100,25);
        findNextButton.setVisible(true);
        panel.add(findNextButton);

        replaceButton.setText("Replace");
        replaceButton.setBounds(350,50,100,25);
        replaceButton.setVisible(true);
        panel.add(replaceButton);

        replaceAllButton.setText("Replace All");
        replaceAllButton.setBounds(350,80,100,25);
        replaceAllButton.setVisible(true);
        panel.add(replaceAllButton);

        cancelButton.setText("Cancel");
        cancelButton.setBounds(350,110,100,25);
        cancelButton.setVisible(true);
        panel.add(cancelButton);

        matchCase.setText("Match case");
        matchCase.setBounds(20,110,120,25);
        matchCase.setVisible(true);
        panel.add(matchCase);

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent e ) {
                System.exit(FindFrame.DO_NOTHING_ON_CLOSE);
            }
        });

        setDefaultCloseOperation(ReplaceFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        repaint();

    }
}