package model.goods;

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
    super(21, 0);
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
   * Buy ScoreMultiplier.
   *
   * @param id dari ScoreMultiplier.
   */

  @Override
  public void buy(int id) {

  }
}
