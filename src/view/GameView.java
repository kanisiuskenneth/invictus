package view;

import model.word.Word;
import util.Pair;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * File: GameView.java
 * Author: 13515033 - Andika Kusuma
 */

public class GameView {
    public JPanel panel;
    public JTextField field;
    public Random random;

    public GameView() {
        panel = new JPanel();
        field = new JTextField("");
        random = new Random();
        MainFrame.mainframe.setContentPane(panel);
        panel.setVisible(true);
        panel.setSize(MainFrame.width,MainFrame.height);
        panel.setBackground(MainFrame.DARK_GRAY);
        field.setSize(100, 20);
        field.setVisible(true);
        panel.setLayout(new BorderLayout());
        panel.add(field, BorderLayout.SOUTH);
    }

    private int getIndexPrefix (String first_string, String second_string) {
        /*
        int index = 0;
        while (first_string.charAt(index) == second_string.charAt(index) && index < first_string.length() - 1 && index < second_string.length() - 1) {
            index++;
        }
        if (first_string.charAt(index) != second_string.charAt(index)) {
            index--;
        }
        */
        if (first_string.length() > second_string.length()) {
            return -1;
        } else {
            if (first_string.equals(second_string.substring(0,first_string.length()))) {
                return first_string.length() - 1;
            } else {
                return -1;
            }
        }
    }

    public SwingWorker<Void, Void> viewWord(Word word, SwingWorker<Void, Void> worker) {
        //field.getText();
        JLabel label = new JLabel("<html> <font color = 'white'> " +
            word.getContent() + " </font></html>");
        int position_x = random.nextInt(1000);
        int position_y = 0; // y position dari paling atas
        label.setLocation(position_x, position_y);
        label.setVisible(true);
        panel.add(label, BorderLayout.NORTH);
        panel.setVisible(true);
        MainFrame.mainframe.setVisible(true);
        worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                while (!isCancelled()) {
                    Thread.sleep(10);
                    if (field.getText() != "") {
                        int index = getIndexPrefix(field.getText().toUpperCase(), word.getContent());
                        //System.out.println(index);
                        label.setText("<html> <font color = 'green'> " +
                            word.getContent().substring(0, index + 1) + "</font>" +
                            "<font color = 'red'>" + word.getContent().substring(index + 1) +
                            " </font></html>"
                        );
                        label.setLocation(position_x, label.getLocation().y);
                    }
                    Point cr = label.getLocation();
                    cr.y += 2;
                    label.setLocation(position_x, cr.y);
                    word.setPosition(new Pair(position_x, cr.y));
                    if (cr.y > 500) {
                        cancel(true);
                    }
                }
                return null;
            }

            @Override
            protected void done() {
                label.setText("");
            }
        };
        worker.execute();
        return worker;
    }
}
