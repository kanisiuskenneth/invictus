package model.goods;

/**
 * File: FreezeSpell.java
 * Author: 13515063 - Kezia Suhendra
 */

import model.game.GameModel;
import model.main.MainModel;

import javax.swing.*;

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
   * Buy FreezeSpell.
   */

  @Override
  public void buy() {
    MainModel.item.get(id).second++;
    MainModel.coin -= price;
  }

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
        } catch (Exception e) {
          System.out.println("");
        }
        gameModel.spawnTic -= 10000;
        gameModel.updateTic -= 10000;
        return null;
      }
    };
    worker.execute();
    MainModel.item.get(id).second--;
  }
}
