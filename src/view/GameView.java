package view;

import controller.GameController;
import controller.ImageLoader;
import controller.SubmitButton;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import model.game.GameModel;
import model.main.MainModel;
import model.word.Word;
import util.Pair;

/**
 * File: GameView.java
 * Author: 13515033 - Andika Kusuma
 */

public class GameView {
  public GameController gameController;
  private JPanel gamePanel;
  private JTextField field;
  //private JButton submit;
  private JLabel healthLabel;
  private JLabel scoreLabel;
  private SwingWorker<Void, Void> wordWorker;
  private SwingWorker<Void, Void> updateWorker;

  public GameView() {
    System.out.println("Starting game");
    gameController = new GameController();
    updateWorker = null;
    wordWorker = null;
    /*
    MainFrame.mainframe.setContentPane(panel);
    MainFrame.mainframe.getRootPane().setDefaultButton(submit);
    submit.addActionListener(new SubmitButton(this, field));
    submit.addKeyListener(new SubmitButton(this, field));
    submit.setVisible(true);
    */
    gamePanel = new JPanel();
    gamePanel.setVisible(true);
    gamePanel.setSize(MainFrame.width, MainFrame.height);
    gamePanel.setBackground(Color.BLUE);
    /*
    field.setSize(100, 20);
    field.setVisible(true);
    */
    gamePanel.setLayout(new BorderLayout());
    /*
    MainFrame.mainframe.getRootPane().setDefaultButton(submit);
    field.requestFocusInWindow();
    */
    Container prevPanel = MainFrame.mainframe.getContentPane();
    JPanel mainPanel = new JPanel();
    mainPanel.setLayout(new BorderLayout());
    MainFrame.mainframe.setContentPane(mainPanel);
    mainPanel.setBackground(MainFrame.DARK_GRAY);
    mainPanel.setSize(MainFrame.width,MainFrame.height);

    JPanel topPanel = new JPanel();
    JPanel bottomPanel = new JPanel();
    //JPanel middlePanel = new JPanel();
    healthLabel = new JLabel();
    updateHealth();
    scoreLabel = new JLabel();
    updateScore();
    gamePanel.setBackground(Color.BLUE);
    topPanel.setLayout(new BorderLayout());
    topPanel.setBackground(MainFrame.DARK_GRAY);
    bottomPanel.setBackground(MainFrame.DARK_GRAY);
    int logo_height = MainFrame.heightToPx(12);
    int logo_width = logo_height* ImageLoader.game_banner.getWidth()/ImageLoader.game_banner.getHeight();
    JLabel logo = new JLabel(
        new ImageIcon(ImageLoader.game_banner.getScaledInstance(logo_width,logo_height,Image.SCALE_DEFAULT)));
    topPanel.add(logo,BorderLayout.NORTH);

    field = new JTextField();
    field.setOpaque(false);
    field.setBackground(null);
    field.setBorder(null);
    field.setHorizontalAlignment(SwingConstants.CENTER);
    field.setFont(new Font("Courier New",Font.PLAIN,30));
    healthLabel.setForeground(Color.WHITE);
    healthLabel.setFont(new Font("Serif",Font.PLAIN,30));
    healthLabel.setBorder(new EmptyBorder(0,30,30,0));
    field.setBorder(new MatteBorder(2,0,2,0,Color.WHITE));
    field.setForeground(Color.WHITE);
    scoreLabel.setForeground(Color.WHITE);
    scoreLabel.setFont(new Font("Serif",Font.PLAIN,30));
    scoreLabel.setBorder(new EmptyBorder(0,0,30,30));

    topPanel.add(healthLabel,BorderLayout.WEST);
    topPanel.add(scoreLabel,BorderLayout.EAST);
    mainPanel.add(topPanel,BorderLayout.NORTH);

    bottomPanel.setLayout(new BorderLayout());
    bottomPanel.add(field,BorderLayout.NORTH);
    mainPanel.add(gamePanel,BorderLayout.CENTER);
    mainPanel.add(bottomPanel,BorderLayout.SOUTH);
    field.requestFocus();
    mainPanel.setVisible(true);
    MainFrame.mainframe.setVisible(true);


    field.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        gameController.deleteWord(field.getText(), true);
        field.setText("");
      }
    });
    startWordWorker();
    startUpdateWorker();
  }

  public void startWordWorker() {
    wordWorker = new SwingWorker<Void, Void>() {
      @Override
      protected Void doInBackground() throws Exception {
        while (!isCancelled()) {
          System.out.println("ADD DARI VIEW");
          gameController.addWord();
          try {
            Thread.sleep(100);
          } catch (Exception e) {
            System.out.println("");
          }
          //SwingWorker<Void, Void> worker = null;
          //worker = viewWord(new Word(""), worker);
          if (gameController.gameModel.player.getCurrentHealth() <= 0) {
            System.out.println("DIE");
            for (Map.Entry<Word, SwingWorker<Void, Void>> entry : gameController.gameModel.mapOfThread.entrySet()) {
              entry.getKey().getLabel().setText("");
              entry.getValue().cancel(true);
            }
            gameController.gameModel.mapOfThread.clear();
            System.out.println(gameController.gameModel.player.getScore());
            cancel(true);
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
        updateWorker.cancel(true);
      }
    };
    wordWorker.execute();
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

  private void startUpdateWorker() {
    updateWorker = new SwingWorker<Void, Void>() {
      @Override
      protected Void doInBackground() throws Exception {
        while (!isCancelled()) {
          // cek updating
          System.out.println("JUMLAH" + gameController.gameModel.mapOfThread.size());
          Thread.sleep(50);
          updateHealth();
          updateScore();
          HashMap<Word, SwingWorker<Void, Void>> mapOfThread = gameController.gameModel.mapOfThread;
          for (Map.Entry<Word, SwingWorker<Void, Void>> entry : mapOfThread.entrySet()) {
            System.out.println("UPDATE" + entry.getKey().getContent());
            Word word = entry.getKey();
            word.getLabel().setLocation(word.getPosition().first, word.getPosition().second);
            word.getLabel().setVisible(true);
            if (word.getPosition().second > 500) {
              //gameController.deleteWord(word.getContent(), false);
              word.getLabel().setText("");
              //gameController.gameModel.mapOfThread.get(word.getContent()).cancel(true);
              //gameController.gameModel.mapOfThread.remove(word.getContent());
              //gameController.reduceHealth();
              /*
              gameController.deleteWord(word.getContent(), false);
              gameController.gameModel.player.reducedHealth();
              */
            } else {
              if (word.getContent().equals(word.getLabel().getText())) {
                word.getLabel().setText("<html><font color = 'white'> " + word.getContent() + "</font></html>");
                word.getLabel().setVisible(true);
                gamePanel.add(word.getLabel(), BorderLayout.NORTH);
              }
              System.out.println("loop1");
              if (field.getText() != "") {
                int index = getIndexPrefix(field.getText().toUpperCase(), word.getContent());
                //System.out.println(index);
                word.getLabel().setText("<html> <font color = 'green'> "
                    + word.getContent().substring(0, index + 1) + "</font>"
                    + "<font color = 'red'>" + word.getContent().substring(index + 1)
                    + " </font></html>"
                );
                word.getLabel().setLocation(word.getPosition().first, word.getPosition().second);
              }
            }
            System.out.println("loop");
          }
        }
        System.out.println("UPDATE DONE");
        return null;
      }

      @Override
      protected void done() {

      }
    };
    updateWorker.execute();
  }

  void updateHealth() {
    String health = "";
    for(int i =0;i<gameController.gameModel.player.getCurrentHealth();i++) {
      health += "\u2665";
    }
    healthLabel.setText(health);
  }

  void updateScore() {
    scoreLabel.setText(""+gameController.gameModel.player.getScore());
  }
}