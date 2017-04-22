package view;

import controller.GameController;
import model.main.MainModel;
import model.player.Player;
import model.word.Word;
import sun.applet.Main;
import util.Pair;
import controller.SubmitButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Random;

/**
 * File: GameView.java
 * Author: 13515033 - Andika Kusuma
 */

public class GameView {
    private Player player;
    private JPanel panel;
    private JTextField field;
    private JButton submit;
    private Random random;
    private JLabel health_label;
    private HashMap<String, SwingWorker<Void, Void>> map_of_thread;

    public GameView() {
        map_of_thread = new HashMap<String, SwingWorker<Void, Void>>();
        MainFrame.mainframe.remove(MainFrame.mainframe.getContentPane());
        panel = new JPanel();
        System.out.println("Starting game");
        MainFrame.mainframe.setContentPane(panel);
        MainFrame.mainframe.getRootPane().setDefaultButton(submit);
        field = new JTextField("");
        player = new Player();
        health_label = new JLabel("<html> <font color = 'red' size = '20'> " + player.getCurrent_health() + "</font></html>");
        health_label.setLocation(20,0);
        panel.add(health_label, BorderLayout.NORTH);
        submit = new JButton("Submit");
        submit.addActionListener(new SubmitButton(this, field));
        submit.addKeyListener(new SubmitButton(this, field));
        submit.setVisible(false);
        panel.add(submit, BorderLayout.WEST);
        random = new Random();
        panel.setVisible(true);
        panel.setSize(MainFrame.width,MainFrame.height);
        panel.setBackground(Color.BLUE);
        field.setSize(100, 20);
        field.setVisible(true);
        panel.setLayout(new BorderLayout());
        panel.add(field, BorderLayout.SOUTH);
        field.requestFocusInWindow();
    }

    public void reduceHP(){
        player.reducedHealth();
    }

    public void addScore(int score) {
        player.increaseScore(score);
    }

    public void addWord() {
        String content = MainModel.word_bank.get(random.nextInt(MainModel.word_bank.size()));
        while (map_of_thread.containsKey(content)) {
            content = MainModel.word_bank.get(random.nextInt(MainModel.word_bank.size()));
        }
        Word new_word = new Word(content);
        SwingWorker<Void, Void> worker = null;
        worker = viewWord(new_word, worker);
        map_of_thread.put(new_word.getContent(), worker);
    }

    public void deleteWord(String content, boolean typed) {
        content = content.toUpperCase();
        if (map_of_thread.containsKey(content)) {
            map_of_thread.get(content).cancel(true);
            map_of_thread.remove(content);
            if (typed) {
                addScore(10 * content.length());
            } else {
                reduceHP();
                try {
                    Thread.sleep(10);
                } catch (Exception e) {
                    
                }
                health_label.setText("<html> <font color = 'red' size = '20'> " + player.getCurrent_health() + "</font></html>");
            }
        }
    }


    private int getIndexPrefix (String first_string, String second_string) {
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
                        deleteWord(word.getContent(), false);
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
