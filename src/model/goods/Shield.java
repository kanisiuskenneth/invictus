package model.goods;

/**
 * File: Shield.java
 * Author: 13515070 - Sylvia Juliana
 */

/**
 * Kelas Shield.
 */
public class Shield extends Items {
  /**
   * Constructor.
   */

  public Shield() {
    super(14, 5);
  }

  /**
   * Getter id.
   *
   * @return id dari Shield.
   */

  public int getId() {
    return id;
  }

  /**
   * Getter price.
   *
   * @return price dari Shield.
   */

  public int getPrice() {
    return price;
  }

  /**
   * Getter description.
   *
   * @return description dari Shield.
   */

  public String getDescription() {
    return "prevents the health points from reducing for 10 seconds.";
  }

  /**
   * Buy Shield.
   *
   * @param id dari Shield.
   */

  @Override
  public void buy(int id) {

  }
}
