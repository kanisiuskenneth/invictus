package model.goods;

import model.game.GameModel;
import model.main.MainModel;

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
    super(3, 75);
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
    return "increase the current health points by one heart.";
  }

  /**
   * I.S. Coin player lebih dari harga Potion.
   * F.S. Coin player berkurang dan Potion player bertambah.
   */

  @Override
  public void buy() {
    MainModel.item.get(id).second++;
    MainModel.coin -= price;
  }

  /**
   * I.S. Potion player tersedia.
   * F.S. Potion player berkurang dan terpakai.
   * @param gameModel Game Model yang dioperasikan.
   */

  @Override
  public void use(GameModel gameModel) {
    if (gameModel.player.getCurrentHealth() < MainModel.health_maximum) {
      gameModel.player.increaseHealth();
      gameModel.updateHealth();
    }
    MainModel.item.get(id).second--;
    gameModel.itemFlag = false;
  }
}