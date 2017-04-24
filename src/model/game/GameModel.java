package model.game;

import model.player.Player;
import model.word.Word;
import util.Pair;
import view.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

/**
 * File: GameModel.java
 * Author: 13515033 - Andika Kusuma
 */

public class GameModel {
  public Player player;
  public Random random;
  public HashSet<Word> wordSet;
  public JLayeredPane gamePanel;
  public JTextField field;
  public JLabel healthLabel;
  public JLabel scoreLabel;
  public int updateTic = 20;
  public int spawnTic = 2000;
  public Container menupanel;
  public GameModel() {
    wordSet = new HashSet<Word>();
    player = new Player();
    random = new Random();
    healthLabel = new JLabel();
    updateHealth();
    scoreLabel = new JLabel();
    updateScore();

  }

  public void updateHealth() {
    String health = "";
    for(int i =0;i<player.getCurrentHealth();i++) {
      health += "\u2665";
    }
    healthLabel.setText(health);
  }

  public void updateScore() {
    scoreLabel.setText(""+player.getScore());
  }

}
