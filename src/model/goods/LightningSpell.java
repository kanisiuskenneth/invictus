package model.goods;

import javax.swing.SwingUtilities;

import model.game.GameModel;
import model.main.MainModel;
import model.word.Word;

/**
 * File: LightningSpell.java
 * Author: 13515070 - Sylvia Juliana
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
   * I.S. Coin player lebih dari harga Lightning Spell.
   * F.S. Coin player berkurang dan Lightning Spell player bertambah.
   */

  @Override
  public void buy() {
    MainModel.item.get(id).second++;
    MainModel.coin -= price;
  }

  /**
   * I.S. Lightning Spell player tersedia.
   * F.S. Lightning Spell player berkurang dan terpakai.
   * @param gameModel Game Model yang dioperasikan.
   */

  @Override
  public void use(GameModel gameModel) {
    for (Word word : gameModel.wordSet) {
      SwingUtilities.invokeLater(new Runnable() {
        @Override
        public void run() {
          word.getLabel().setVisible(false);
          gameModel.wordSet.remove(word);
          gameModel.player.increaseScore(word.getContent().length() * 10);
          gameModel.updateScore();
        }
      });
    }
    gameModel.gamePanel.removeAll();
    MainModel.item.get(id).second--;
    gameModel.itemFlag = false;
  }
}