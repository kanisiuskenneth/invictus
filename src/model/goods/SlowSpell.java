package model.goods;

import javax.swing.SwingWorker;

import model.game.GameModel;
import model.main.MainModel;

/**
 * File: SlowSpell.java
 * Author: 13515063 - Kezia Suhendra
 */
public class SlowSpell extends Items {
  /**
   * Constructor.
   */

  public SlowSpell() {
    super(1, 65);
  }

  /**
   * Getter id.
   *
   * @return id dari SlowSpell.
   */

  public int getId() {
    return id;
  }

  /**
   * Getter price.
   *
   * @return price dari SlowSpell.
   */

  public int getPrice() {
    return price;
  }

  /**
   * Getter description.
   *
   * @return description dari SlowSpell.
   */

  public String getDescription() {
    return "decrease the speed of the words by 0.5.";
  }

  /**
   * I.S. Coin player lebih dari harga Slow Spell.
   * F.S. Coin player berkurang dan Slow Spell player bertambah.
   */

  @Override
  public void buy() {
    MainModel.item.get(id).second++;
    MainModel.coin -= price;
  }

  /**
   * I.S. Slow Spell player tersedia.
   * F.S. Slow Spell player berkurang dan terpakai.
   * @param gameModel Game Model yang dioperasikan.
   */

  @Override
  public void use(GameModel gameModel) {
    SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
      @Override
      protected Void doInBackground() throws Exception {
        gameModel.spawnTic *= 2;
        gameModel.updateTic *= 2;
        gameModel.mutex = false;
        try {
          Thread.sleep(10000);
          System.out.println("Slow Spell finished");
          gameModel.spawnTic /= 2;
          gameModel.updateTic /= 2;
          gameModel.itemFlag = false;
        } catch (Exception e) {
          System.out.println("");
        }
        return null;
      }
    };
    worker.execute();
    MainModel.item.get(id).second--;
  }
}
