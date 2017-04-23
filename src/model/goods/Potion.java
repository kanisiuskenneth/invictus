package model.goods;

/**
 * File: Potion.java
 * Author: 13515063 - Kezia Suhendra
 */

/**
 * Kelas Potion.
 */
public class Potion extends Items {
  /**
   * Constructor.
   */

  public Potion() {
    super(12, 0);
  }

  /**
   * Getter id.
   *
   * @return id dari Potion.
   */

  public int getId() {
    return id;
  }

  /**
   * Getter price.
   *
   * @return price dari Potion.
   */

  public int getPrice() {
    return price;
  }

  /**
   * Getter description.
   *
   * @return description dari Potion.
   */

  public String getDescription() {
    return "stop all of the words on the screen for 10 seconds.";
  }

  /**
   * Buy Potion.
   *
   * @param id dari Potion.
   */

  @Override
  public void buy(int id) {

  }
}