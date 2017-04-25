package model.goods;

import model.main.MainModel;

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
    super(6, 100);
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
   * I.S. Coin player lebih dari harga Coin Multiplier.
   * F.S. Coin player berkurang dan Coin Multiplier player bertambah.
   */

  @Override
  public void buy() {
    MainModel.coin -= price * (MainModel.coin_multiplier - 0.9) * 10;
    MainModel.coin_multiplier += 0.1;
  }
}
