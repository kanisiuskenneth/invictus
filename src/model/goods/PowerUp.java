package model.goods;

/**
 * File: PowerUp.java
 * Author: 13515063 - Kezia Suhendra
 */

public abstract class PowerUp extends Goods {
  /**
   * Constructor.
   */

  public PowerUp(int id, int price) {
    super(id, price);
  }

  /**
   * Getter description.
   *
   * @return Description dari PowerUp.
   */

  public String getDescription() {
    return "";
  }
}