package view;

import model.word.Word;

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
    public Random random;

    public GameView() {
        panel = new JPanel();
        random = new Random();
        MainFrame.mainframe.setContentPane(panel);
        panel.setVisible(true);
        panel.setSize(MainFrame.width,MainFrame.height);
        panel.setBackground(MainFrame.DARK_GRAY);
    }

    public void viewWord(Word word) {
        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                JLabel label = new JLabel("<html> <font color = 'white'> " + word.getContent()+ " </font></html>");
                int position_x = random.nextInt(1000);
                int position_y = 0; // y position dari paling atas
                label.setLocation(position_x, position_y);
                label.setVisible(true);
                panel.setLayout(new BorderLayout());
                panel.add(label, BorderLayout.NORTH);
                panel.setVisible(true);
                MainFrame.mainframe.setVisible(true);
                Timer timer = new Timer(10, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Point cr = label.getLocation();
                        cr.y += 2;
                        label.setLocation(position_x, cr.y);
                    }
                });
                timer.start();
                return null;
            }
        };
        worker.execute();
    }
}
