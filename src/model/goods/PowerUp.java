package model.goods;

/**
 * File: PowerUp.java
 * Author: 13515063 - Kezia Suhendra
 */

/**
 * Kelas Abstrak PowerUp.
 */
abstract class PowerUp extends Goods {
  /**
   * Constructor.
   *
   * @param id    id PowerUp.
   * @param price harga PowerUp.
   */

  PowerUp(int id, int price) {
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