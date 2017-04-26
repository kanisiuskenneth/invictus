package view;

import controller.ImageLoader;
import java.awt.Color;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

/**
 * File : MainFrame.java.
 * Author: 13515008 - Kanisius Kenneth Halim.
 */

/**
 * Kelas MainFrame.
 */
public class MainFrame {

  private static final GraphicsDevice device = GraphicsEnvironment
      .getLocalGraphicsEnvironment().getScreenDevices()[0];
  static int height;
  static int width;
  public static JFrame mainframe;
  static final Color DARK_GRAY = new Color(30, 30, 30);

  /**
   * Constructor.
   */
  public MainFrame() {
    mainframe = new JFrame("Undefeated Typer");
    mainframe.setUndecorated(true);
    mainframe.setIconImage(new ImageIcon("img/gamelogo.png").getImage());
    mainframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    mainframe.setResizable(false);
    width = device.getDisplayMode().getWidth();
    height = device.getDisplayMode().getHeight();
    mainframe.getContentPane().setBackground(DARK_GRAY);
    mainframe.setSize(width, height);
    int splashWidth = widthToPx(60);
    int splashHeiht = splashWidth * ImageLoader.splash.getHeight()
        / ImageLoader.splash.getWidth();
    mainframe.setVisible(true);
    MainFrame.mainframe.add(new JLabel(
        new ImageIcon(
            ImageLoader.splash.getScaledInstance(
                splashWidth, splashHeiht, Image.SCALE_SMOOTH))));
    mainframe.setVisible(true);
    device.setFullScreenWindow(mainframe);
  }

  /**
   * Mengubah persen menjadi pixels sesuai panjang layar komputer pengguna.
   *
   * @param percent dari panjang layar komputer pengguna.
   * @return integer berupa pixels dari panjang layar komputer pengguna.
   */
  static int widthToPx(int percent) {
    return percent * width / 100;
  }

  /**
   * Mengubah persen menjadi pixels sesuai tinggi layar komputer pengguna.
   *
   * @param percent dari tinggi layar komputer pengguna.
   * @return integer berupa pixels dari tinggi layar komputer pengguna.
   */
  static int heightToPx(int percent) {
    return percent * height / 100;
  }
}
