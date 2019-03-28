package NotePadeFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FindFrame extends JFrame {

    private JPanel panel = new JPanel();
    private JTextPane fineWhatPane = new JTextPane();
    private JCheckBox matchCase = new JCheckBox();
    private JLabel direction = new JLabel();
    private JRadioButton directionUp = new JRadioButton();
    private JRadioButton directionDown = new JRadioButton();
    private ButtonGroup groupDirection = new ButtonGroup();
    private JButton findNextButton = new JButton();
    private JButton cancelButton = new JButton();
    private JLabel fineWhat = new JLabel();


    public FindFrame() {

        setTitle("Find");
        setSize(450, 150);
        setLocation(350, 80);
        panel.setLayout(null);
        getContentPane().add(panel);

        fineWhat.setText("Find what");
        fineWhat.setBounds(20,20,70,20);
        fineWhat.setVisible(true);
        panel.add(fineWhat);

        fineWhatPane.setText("");
        fineWhatPane.setBounds(90,20,200,20);
        fineWhatPane.setVisible(true);
        panel.add(fineWhatPane);

        findNextButton.setText("Find Next");
        findNextButton.setBounds(320,20,100,25);
        findNextButton.setVisible(true);
        panel.add(findNextButton);

        cancelButton.setText("Cancel");
        cancelButton.setBounds(320,50,100,25);
        cancelButton.setVisible(true);
        panel.add(cancelButton);

        matchCase.setText("Match case");
        matchCase.setBounds(20,90,120,25);
        matchCase.setVisible(true);
        panel.add(matchCase);

        direction.setText("Direction");
        direction.setBounds(180,70,70,20);
        direction.setVisible(true);
        panel.add(direction);
        directionUp.setText("Up");
        directionUp.setBounds(170,90,40,25);
        directionUp.setVisible(true);
        panel.add(directionUp);
        directionDown.setText("Down");
        directionDown.setBounds(220,90,60,25);
        directionDown.setVisible(true);
        panel.add(directionDown);
        groupDirection.add(directionUp);
        groupDirection.add(directionDown);

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent e ) {
                System.exit(FindFrame.DO_NOTHING_ON_CLOSE);
            }
        });


        setDefaultCloseOperation(FindFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        repaint();

    }
}