package model.goods;

/**
 * File: Items.java
 * Author: 13515070 - Sylvia Juliana
 */

/**
 * Kelas abstrak Items.
 */
public abstract class Items extends Goods implements Usable{
  /**
   * Constructor.
   */

  public Items(int id, int price) {
    super(id, price);
  }
  /**
   * Getter description.
   * @return Description dari items.
   */

  public String getDescription() {
    return "";
  }

  /**
   * Getter id.
   * @return id dari items.
   */
  public int getId() {
    return id;
  }
}