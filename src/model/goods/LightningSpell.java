package model.goods;

/**
 * File: LightningSpell.java
 * Author: 13515070 - Sylvia Juliana
 */

import model.main.MainModel;

/**
 * Kelas LightningSpell.
 */
public class LightningSpell extends Items {
  /**
   * Constructor.
   */

  public LightningSpell() {
    super(4, 100);
  }

  /**
   * Getter id.
   *
   * @return id dari LightningSpell.
   */

  public int getId() {
    return id;
  }

  /**
   * Getter price.
   *
   * @return price dari LightningSpell.
   */

  public int getPrice() {
    return price;
  }

  /**
   * Getter description.
   *
   * @return description dari LightningSpell.
   */

  public String getDescription() {
    return "destroy all of the words on the screen.";
  }

  /**
   * Buy LightningSpell.
   */

  @Override
  public void buy() {
    MainModel.item.get(id).second++;
    MainModel.coin -= price;
  }
}
