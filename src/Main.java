import controller.ImageLoader;
import model.main.MainModel;
import view.MainFrame;
import view.Menu;

/**
 * File: Main.java
 * Created by kennethhalim on 4/20/17.
 */

/**
 * Kelas Main.
 */
public class Main {
  /**
   * Fungsi Main.
   * @param args argumen tidak digunakan.
   */
  public static void main(String[] args) {
    new ImageLoader();
    new MainFrame();
    new MainModel();
    try {
      Thread.sleep(5000);
    } catch (Exception e) {
      System.out.println("");
    }

    new Menu();
    //new ShopView();
  }
}
