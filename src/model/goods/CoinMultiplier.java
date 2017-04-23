package model.goods;

/**
 * File: CoinMultiplier.java
 * Author: 13515070 - Sylvia Juliana
 */

/**
 * Kelas CoinMultiplier.
 */
public class CoinMultiplier extends PowerUp {
  /**
   * Constructor.
   */

  public CoinMultiplier() {
    super(20, 0);
  }

  /**
   * Getter id.
   *
   * @return id dari CoinMultiplier.
   */

  public int getId() {
    return id;
  }

  /**
   * Getter price.
   *
   * @return price dari CoinMultiplier.
   */

  public int getPrice() {
    return price;
  }

  /**
   * Getter description.
   *
   * @return description dari CoinMultiplier.
   */

  public String getDescription() {
    return "increase the coins multiplier by 0.1 from the base multiplier.";
  }

  /**
   * Buy CoinMultiplier.
   *
   * @param id dari CoinMultiplier.
   */

  @Override
  public void buy(int id) {

  }
}
