package model.goods;

import model.main.MainModel;

/**
 * File: ScoreMultiplier.java
 * Author: 13515070 - Sylvia Juliana
 */

/**
 * Kelas ScoreMultiplier.
 */
public class ScoreMultiplier extends PowerUp {
  /**
   * Constructor.
   */

  public ScoreMultiplier() {
    super(7, 80);
  }

  /**
   * Getter id.
   *
   * @return id dari ScoreMultiplier.
   */

  public int getId() {
    return id;
  }

  /**
   * Getter price.
   *
   * @return price dari ScoreMultiplier.
   */

  public int getPrice() {
    return price;
  }

  /**
   * Getter description.
   *
   * @return description dari ScoreMultiplier.
   */

  public String getDescription() {
    return "increase the scores multiplier by 0.1 from the base multiplier.";
  }

  /**
   * I.S. Coin player lebih dari harga Score Multiplier.
   * F.S. Coin player berkurang dan Score Multiplier player bertambah.
   */

  @Override
  public void buy() {
    MainModel.coin -= price * (MainModel.score_multiplier - 0.9) * 10;
    MainModel.score_multiplier += 0.1;
  }
}
