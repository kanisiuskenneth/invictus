package model.goods;

/**
 * File: HealthUpgrade.java
 * Author: 13515063 - Kezia Suhendra
 */

import model.main.MainModel;

/**
 * Kelas HealthUpgrade.
 */
public class HealthUpgrade extends PowerUp {
  /**
   * Constructor.
   */

  public HealthUpgrade() {
    super(8, 90);
  }

  /**
   * Getter id.
   *
   * @return id dari HealthUpgrade.
   */

  public int getId() {
    return id;
  }

  /**
   * Getter price.
   *
   * @return price dari HealthUpgrade.
   */

  public int getPrice() {
    return price;
  }

  /**
   * Getter description.
   *
   * @return description dari HealthUpgrade.
   */

  public String getDescription() {
    return "increase the maximum of health points by one heart.";
  }

  /**
   * Buy HealthUpgrade.
   */

  @Override
  public void buy() {
    MainModel.coin -=  price * (MainModel.health_maximum - 2);
    MainModel.health_maximum += 1;
  }
}