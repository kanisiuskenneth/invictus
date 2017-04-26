package model.game;

import java.awt.Container;
import java.util.HashSet;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JTextField;
import model.player.Player;
import model.word.Word;


/**
 * File: GameModel.java
 * Author: 13515033 - Andika Kusuma
 */

/**
 * Kelas GameModel.
 */
public class GameModel {
  public final Player player;
  public final Random random;
  public final HashSet<Word> wordSet;
  public JLayeredPane gamePanel;
  public JTextField field;
  public final JLabel healthLabel;
  public final JLabel scoreLabel;
  public int updateTic = 20;
  public int spawnTic = 2000;
  public Container menupanel;
  public volatile boolean mutex;

  /**
   * Constructor.
   */
  public GameModel() {
    wordSet = new HashSet<Word>();
    player = new Player();
    random = new Random();
    healthLabel = new JLabel();
    updateHealth();
    scoreLabel = new JLabel();
    updateScore();

  }

  /**
   * I.S. : healthLabel terdefinisi.
   * F.S. : healthLabel berubah sesuai dengan jumlah hati player.
   */
  public void updateHealth() {
    String health = "";
    for (int i = 0; i < player.getCurrentHealth(); i++) {
      health += "♥";
    }
    healthLabel.setText(health);
  }

  /**
   * I.S. : scoreLabel terdefinisi.
   * F.S. : scoreLabel berubah sesuai dengan score player sekarang.
   */
  public void updateScore() {
    scoreLabel.setText("" + player.getScore());
    if (player.getScore() > 10000) {
      updateTic = 10;
      spawnTic = 1000;
    } else {
      updateTic = 20 - player.getScore() / 1000;
      spawnTic = 2000 - player.getScore() / 10;
    }
  }

}
