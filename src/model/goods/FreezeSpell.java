package model.goods;

/**
 * File: FreezeSpell.java
 * Author: 13515063 - Kezia Suhendra
 */

/**
 * Kelas FreezeSpell.
 */
public class FreezeSpell extends Items {
  /**
   * Constructor.
   */

  public FreezeSpell() {
    super(11, 0);
  }

  /**
   * Getter id.
   *
   * @return id dari FreezeSpell.
   */

  public int getId() {
    return id;
  }

  /**
   * Getter price.
   *
   * @return price dari FreezeSpell.
   */

  public int getPrice() {
    return price;
  }

  /**
   * Getter description.
   *
   * @return description dari FreezeSpell.
   */

  public String getDescription() {
    return "stop all of the words on the screen for 10 seconds.";
  }

  /**
   * Buy FreezeSpell.
   *
   * @param id dari FreezeSpell.
   */

  @Override
  public void buy(int id) {

  }
}
