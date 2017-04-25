package model.goods;

import javax.swing.SwingWorker;

import model.game.GameModel;
import model.main.MainModel;

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
    super(2, 85);
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
   * I.S. Coin player lebih dari harga Freeze Spell.
   * F.S. Coin player berkurang dan Freeze Spell player bertambah.
   */

  @Override
  public void buy() {
    MainModel.item.get(id).second++;
    MainModel.coin -= price;
  }

  /**
   * I.S. Freeze Spell player tersedia.
   * F.S. Freeze Spell player berkurang dan terpakai.
   * @param gameModel Game Model yang dioperasikan.
   */

  @Override
  public void use(GameModel gameModel) {
    SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
      @Override
      protected Void doInBackground() throws Exception {
        gameModel.spawnTic += 10000;
        gameModel.updateTic += 10000;
        gameModel.mutex = false;
        try {
          Thread.sleep(8000);
          gameModel.spawnTic -= 10000;
          gameModel.updateTic -= 10000;
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
