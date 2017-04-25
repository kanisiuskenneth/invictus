package model.goods;

/**
 * File: Goods.java
 * Author: 13515063 - Kezia Suhendra
 */

abstract class Goods implements Shoppable {
  final int id;
  final int price;

  /**
   * Constructor.
   * @param id dari Items atau PowerUp.
   * @param price dari Items atau PowerUp.
   */
  Goods(int id, int price) {
    this.id = id;
    this.price = price;
  }
}
