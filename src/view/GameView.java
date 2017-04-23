package view;

import controller.GameController;
import controller.ImageLoader;
import controller.SubmitButton;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;
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
  private JLayeredPane gamePanel;
  private JTextField field;
  //private JButton submit;
  private JLabel healthLabel;
  private JLabel scoreLabel;
  private SwingWorker<Void, Void> wordWorker;
  private SwingWorker<Void, Void> updateWorker;
  GameModel gameModel;
  private static int REFRESH_RATE = 60;

  public GameView() {
    System.out.println("Starting game");
    gameModel = new GameModel();

    gamePanel = new JLayeredPane();
    gamePanel.setVisible(true);
    gamePanel.setSize(500, 500);
    gamePanel.setBackground(new Color(90,90,90));
    gamePanel.setOpaque(true);
    //gamePanel.setLayout(null);

    Container prevPanel = MainFrame.mainframe.getContentPane();
    JPanel mainPanel = new JPanel();
    mainPanel.setLayout(new BorderLayout());
    MainFrame.mainframe.setContentPane(mainPanel);
    mainPanel.setBackground(MainFrame.DARK_GRAY);
    mainPanel.setSize(MainFrame.width,MainFrame.height);

    JPanel topPanel = new JPanel();
    JPanel middlePanel = new JPanel();
    JPanel bottomPanel = new JPanel();
    middlePanel.setLayout(null);
    middlePanel.setBackground(Color.WHITE);
    middlePanel.add(gamePanel);
    healthLabel = new JLabel();
    updateHealth();
    scoreLabel = new JLabel();
    updateScore();

    gameController = new GameController(gameModel,gamePanel);

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
    mainPanel.add(middlePanel,BorderLayout.CENTER);
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


  }

  void refreshScreen() {
    
  }
  void updateHealth() {
    String health = "";
    for(int i =0;i<gameModel.player.getCurrentHealth();i++) {
      health += "\u2665";
    }
    healthLabel.setText(health);
  }

  void updateScore() {
    scoreLabel.setText(""+gameModel.player.getScore());
  }
}