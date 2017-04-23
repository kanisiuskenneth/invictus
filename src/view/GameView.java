package view;

import controller.SubmitButton;

import java.awt.*;
import java.util.*;
import javax.swing.*;

import model.main.MainModel;
import model.player.Player;
import model.word.Word;
import util.Pair;

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
  private JLabel healthLabel;
  private HashMap<String, SwingWorker<Void, Void>> mapOfThread;
  private SwingWorker<Void, Void> wordWorker;

  public GameView() {
    mapOfThread = new HashMap<String, SwingWorker<Void, Void>>();
    //MainFrame.mainframe.remove(MainFrame.mainframe.getContentPane());
    panel = new JPanel();
    System.out.println("Starting game");
    MainFrame.mainframe.setContentPane(panel);
    MainFrame.mainframe.getRootPane().setDefaultButton(submit);
    field = new JTextField("");
    player = new Player();
    healthLabel = new JLabel("<html> <font color = 'red' size = '20'> "
        + player.getCurrent_health() + "</font></html>");
    healthLabel.setLocation(50, 0);
    healthLabel.setVisible(true);
    panel.add(healthLabel, BorderLayout.NORTH);
    submit = new JButton("Submit");
    submit.addActionListener(new SubmitButton(this, field));
    submit.addKeyListener(new SubmitButton(this, field));
    submit.setVisible(true);
    panel.add(submit, BorderLayout.WEST);
    random = new Random();
    panel.setVisible(true);
    panel.setSize(MainFrame.width, MainFrame.height);
    panel.setBackground(Color.BLUE);
    field.setSize(100, 20);
    field.setVisible(true);
    panel.setLayout(new BorderLayout());
    panel.add(field, BorderLayout.SOUTH);
    MainFrame.mainframe.getRootPane().setDefaultButton(submit);
    field.requestFocusInWindow();
    wordWorker = new SwingWorker<Void, Void>() {
      @Override
      protected Void doInBackground() throws Exception {
        while (!isCancelled()) {
          addWord();
          try {
            Thread.sleep(100);
          } catch (Exception e) {
            System.out.println("");
          }
          SwingWorker<Void, Void> worker = null;
          worker = viewWord(new Word(""), worker);
          if (player.getCurrent_health() <= 0) {
            System.out.println("DIE");
            for (Map.Entry<String, SwingWorker<Void, Void>> entry : mapOfThread.entrySet()) {
              System.out.println(entry.getKey());
              entry.getValue().cancel(true);
            }
            mapOfThread.clear();
            System.out.println(player.getScore());
          }
          try {
            Thread.sleep(2000);
          } catch (Exception e) {
            System.out.println("");
          }
        }
        System.out.println("keluar loop");
        return null;
      }

      @Override
      protected void done() {

      }
    };
    wordWorker.execute();
  }

  private void reduceHealth() {
    player.reducedHealth();
    healthLabel.setText("<html> <font color = 'red' size = '20'> "
        + player.getCurrent_health() + "</font></html>");
  }

  private void addScore(int score) {
    player.increaseScore(score);
  }

  public void addWord() {
    String content = MainModel.word_bank.get(random.nextInt(MainModel.word_bank.size()));
    while (mapOfThread.containsKey(content)) {
      content = MainModel.word_bank.get(random.nextInt(MainModel.word_bank.size()));
    }
    Word newWord = new Word(content);
    SwingWorker<Void, Void> worker = null;
    worker = viewWord(newWord, worker);
    mapOfThread.put(newWord.getContent(), worker);
  }

  public void deleteWord(String content, boolean typed) {
    content = content.toUpperCase();
    if (mapOfThread.containsKey(content)) {
      mapOfThread.get(content).cancel(true);
      mapOfThread.remove(content);
      if (typed) {
        addScore(10 * content.length());
      } else {
        reduceHealth();
        try {
          Thread.sleep(10);
        } catch (Exception e) {
          System.out.println("");
        }
        healthLabel.setText("<html> <font color = 'red' size = '20'> "
            + player.getCurrent_health() + "</font></html>");
      }
    }
  }


  private int getIndexPrefix(String firstString, String secondString) {
    if (firstString.length() > secondString.length()) {
      return -1;
    } else {
      if (firstString.equals(secondString.substring(0, firstString.length()))) {
        return firstString.length() - 1;
      } else {
        return -1;
      }
    }
  }

  public SwingWorker<Void, Void> viewWord(Word word, SwingWorker<Void, Void> worker) {
    //field.getText();
    JLabel label = new JLabel("<html> <font color = 'blue'> "
        + word.getContent() + " </font></html>");
    // masih ada bug nyangkut di atas gatau kenapa
    int positionX = random.nextInt(1000);
    int positionY = 0; // y position dari paling atas
    label.setLocation(positionX, positionY);
    label.setVisible(true);
    panel.add(label, BorderLayout.NORTH);
    panel.setVisible(true);
    MainFrame.mainframe.setVisible(true);
    worker = new SwingWorker<Void, Void>() {
      @Override
      protected Void doInBackground() throws Exception {
        while (!isCancelled()) {
          //
          if (label.getLocation().y <= 50) {
            label.setText("<html><font color = 'blue'> " + word.getContent() + "</font></html>");
          }
          //
          Thread.sleep(30);
          if (field.getText() != "") {
            int index = getIndexPrefix(field.getText().toUpperCase(), word.getContent());
            //System.out.println(index);
            label.setText("<html> <font color = 'green'> "
                + word.getContent().substring(0, index + 1) + "</font>"
                + "<font color = 'red'>" + word.getContent().substring(index + 1)
                + " </font></html>"
            );
            label.setLocation(positionX, label.getLocation().y);
          }
          Point cr = label.getLocation();
          cr.y += 2;
          label.setLocation(positionX, cr.y);
          word.setPosition(new Pair(positionX, cr.y));
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
