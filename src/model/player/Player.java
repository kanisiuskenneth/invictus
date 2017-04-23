package model.player;

import model.main.MainModel;

/**
 * File: Player.java
 * Author: 13515063 - Kezia Suhendra
 */

/**
 * Kelas Player
 */
public class Player {
  private int currentHealth;
  private int score;

  /**
   * Constructor
   */

  public Player() {
    currentHealth = MainModel.health_maximum;
    score = 0;
  }

  /**
   * Mengurangi current health points player.
   */

  public int getCurrentHealth() {
    return currentHealth;
  }

  public int getScore() {
    return score;
  }

  public void reducedHealth() {
    --currentHealth;
  }

  public void increaseScore(int score) {
    this.score += score;
  }
}
