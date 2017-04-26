package model.player;

import model.main.MainModel;

/**
 * File: Player.java
 * Author: 13515063 - Kezia Suhendra
 */

/**
 * Kelas Player.
 */
public class Player {
  private int currentHealth;
  private int score;

  /**
   * Constructor.
   */

  public Player() {
    currentHealth = MainModel.health_maximum;
    score = 0;
  }

  /**
   * Getter currentHealth.
   * @return currenHealth dari player.
   */

  public int getCurrentHealth() {
    return currentHealth;
  }

  /**
   * Getter score.
   * @return score dari player.
   */

  public int getScore() {
    return score;
  }

  /**
   * Mengurangi current health points player.
   */
  public void reduceHealth() {
    --currentHealth;
  }

  /**
   * Menambah current health points player.
   */
  public void increaseHealth() {
    ++currentHealth;
  }

  /**
   * Menambah score dari player.
   * @param score dari player.
   */
  public void increaseScore(int score) {
    this.score += score;
  }
}
