package model.goods;

/**
 * File: SlowSpell.java
 * Author: 13515063 - Kezia Suhendra
 */

import model.game.GameModel;
import model.main.MainModel;

import javax.swing.*;

/**
 * Kelas SlowSpell.
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
   * Buy SlowSpell.
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
        gameModel.spawnTic *= 2;
        gameModel.updateTic *= 2;
        gameModel.mutex = false;
        try {
          Thread.sleep(10000);
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
