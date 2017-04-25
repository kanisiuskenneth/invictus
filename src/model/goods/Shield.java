package model.goods;

import javax.swing.SwingWorker;

import model.game.GameModel;
import model.main.MainModel;

/**
 * File: Shield.java
 * Author: 13515070 - Sylvia Juliana
 */
public class Shield extends Items {
  /**
   * Constructor.
   */

  public Shield() {
    super(5, 75);
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
   * I.S. Coin player lebih dari harga Shield.
   * F.S. Coin player berkurang dan Shield player bertambah.
   */

  @Override
  public void buy() {
    MainModel.item.get(id).second++;
    MainModel.coin -= price;
  }

  /**
   * I.S. Shield player tersedia.
   * F.S. Shield player berkurang dan terpakai.
   * @param gameModel Game Model yang dioperasikan.
   */

  @Override
  public void use(GameModel gameModel) {
    SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
      @Override
      protected Void doInBackground() throws Exception {
        gameModel.shieldFlag = true;
        gameModel.mutex = false;
        try {
          Thread.sleep(10000);
          gameModel.itemFlag = false;
        } catch (Exception e) {
          System.out.println("");
        }
        gameModel.shieldFlag = false;
        return null;
      }
    };
    worker.execute();
    MainModel.item.get(id).second--;
  }
}
