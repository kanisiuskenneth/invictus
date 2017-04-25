package model.goods;

/**
 * File: Goods.java
 * Author: 13515063 - Kezia Suhendra
 */

/**
 * Kelas Abstrak Goods.
 */
public abstract class Goods implements Shoppable {
  protected int id;
  protected int price;

  /**
   * Constructor.
   * @param id dari Items atau PowerUp.
   * @param price dari Items atau PowerUp.
   */
  public Goods(int id, int price) {
    this.id = id;
    this.price = price;
  }
}
