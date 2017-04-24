package view;

import controller.ImageLoader;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.main.MainModel;

/**
 * File: Menu.java
 * Author: 13515008 - Kanisius Kenneth Halim.
 */

/**
 * Kelas Menu.
 */
public class Menu {
  JPanel mainPanel;
  JPanel menuPanel;

  /**
   * Constructor.
   */
  public Menu() {
    Container temp = MainFrame.mainframe.getContentPane();
    temp.removeAll();
    mainPanel = new JPanel();
    MainFrame.mainframe.remove(temp);
    MainFrame.mainframe.setContentPane(mainPanel);
    mainPanel.setBackground(MainFrame.DARK_GRAY);
    mainPanel.setLayout(new BorderLayout());
    addGameBanner();
    addMenu();
    addFooter();
    mainPanel.setVisible(true);
    MainFrame.mainframe.setVisible(true);
  }

  /**
   * Menambahkan logo game pada bagian atas dari Panel menu.
   */
  private void addGameBanner() {
    int bannerHeight = MainFrame.heightToPx(30);
    int bannerWidth = bannerHeight * ImageLoader.game_banner.getWidth()
        / ImageLoader.game_banner.getHeight();
    JLabel gamelogo = new JLabel(new ImageIcon(ImageLoader.game_banner
        .getScaledInstance(bannerWidth, bannerHeight, Image.SCALE_SMOOTH)));
    mainPanel.add(gamelogo, BorderLayout.NORTH);
  }

  /**
   * Menambahkan tombol pada bagian content dari menu.
   */
  private void addMenu() {

    menuPanel = new JPanel();
    mainPanel.add(menuPanel, BorderLayout.CENTER);
    JButton play = addMenuButton(ImageLoader.play_button);
    JButton shop = addMenuButton(ImageLoader.menuButton);
    JButton leaderboard = addMenuButton(ImageLoader.leaderboard_button);
    JButton quit = addMenuButton(ImageLoader.quit_button);
    int contentHeight = MainFrame.heightToPx(65);
    int contentRows = contentHeight / 90;
    menuPanel.setLayout(new GridLayout(contentRows, 1));
    menuPanel.setBackground(MainFrame.DARK_GRAY);
    menuPanel.add(play);
    menuPanel.add(shop);
    menuPanel.add(leaderboard);
    menuPanel.add(quit);
    menuPanel.setVisible(true);

    quit.addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            MainFrame.mainframe.dispose();
            System.exit(0);
          }
        }
    );
    leaderboard.addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            LeaderboardView ld = new LeaderboardView();
            //ld.close();
          }
        }
    );

    shop.addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            ShopView sv = new ShopView();

          }
        }
    );

    play.addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            new GameView();
          }
        }
    );

  }

  /**
   * Menambahkan footer pada menu.
   */
  private void addFooter() {
    JPanel footer = new JPanel();
    footer.setLayout(new BorderLayout());
    JLabel copy = new JLabel("Invictus Team  ©2017");
    JLabel version = new JLabel(MainModel.VERSION);
    footer.setBackground(MainFrame.DARK_GRAY);
    copy.setForeground(Color.WHITE);
    version.setForeground(Color.WHITE);
    copy.setVisible(true);
    footer.add(copy, BorderLayout.WEST);
    footer.add(version, BorderLayout.EAST);
    mainPanel.add(footer, BorderLayout.SOUTH);
  }

  /**
   * Mengubah gambar menjadi button yang akan digunakan pada menu.
   *
   * @param img gambar yang akan digunakan.
   * @return JButton yang akan ditambahkan.
   */
  private JButton addMenuButton(BufferedImage img) {
    JButton button = new JButton(new ImageIcon(
        img.getScaledInstance(350, 70, Image.SCALE_DEFAULT)));
    button.setBorder(BorderFactory.createEmptyBorder());
    button.setContentAreaFilled(false);
    return button;
  }
}