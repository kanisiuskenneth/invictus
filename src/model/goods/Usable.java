package model.goods;

import model.game.GameModel;

/**
 * File: GameModel.java
 * Author: 13515033 - Andika Kusuma
 */

/**
 * Interface Usable.
 */
public interface Usable {
  /**
   * I.S. Items player tersedia.
   * F.S. Items player berkurang dan terpakai.
   * @param gameModel Game Model yang dioperasikan.
   */
  void use(GameModel gameModel);
}
