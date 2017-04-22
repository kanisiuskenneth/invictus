
import controller.GameController;
import controller.ImageLoader;
import view.*;

/**
 * Created by kennethhalim on 4/20/17.
 */
public class Main {
    public static void main(String[] args) {
            new ImageLoader();
            new MainFrame();
            try {
                Thread.sleep(5000);
            } catch(Exception e) {
            }
            new GameController();
            //new Menu();
        }
}
