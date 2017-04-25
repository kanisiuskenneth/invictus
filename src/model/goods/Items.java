package model.goods;

/**
 * File: Items.java
 * Author: 13515070 - Sylvia Juliana
 */

/**
 * Kelas Abstrak Items.
 */
public abstract class Items extends Goods implements Usable {

  /**
   * Constructor.
   *
   * @param id id Items.
   * @param price harga Items.
   */

  Items(int id, int price) {
    super(id, price);
  }

  /**
   * Getter description.
   *
   * @return Description dari items.
   */

  public abstract String getDescription();

  /**
   * Getter id.
   *
   * @return id dari items.
   */
  public int getId() {
    return id;
  }
}