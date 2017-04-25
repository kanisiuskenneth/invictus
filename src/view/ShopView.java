package view;

import controller.ImageLoader;

import java.awt.BorderLayout;
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

/**
 * File: ShopView.java
 * Created by 13515063 - Kezia Suhendra.
 */

/**
 * Kelas ShopView.
 */
public class ShopView {
  Container temp;
  JPanel shopPanel;

  /**
   * Constructor.
   */
  public ShopView() {
    temp = MainFrame.mainframe.getContentPane();
    shopPanel = new JPanel();
    shopPanel.setBackground(MainFrame.DARK_GRAY);
    shopPanel.setLayout(new BorderLayout());
    shopPanel.setSize(MainFrame.width, MainFrame.height);
    MainFrame.mainframe.setContentPane(shopPanel);
    addShopBanner();
    addMenu();
    MainFrame.mainframe.setVisible(true);
  }

  /**
   * Menambahkan logo shop pada bagian atas dari panel menu.
   */
  private void addShopBanner() {
    JLabel headBanner = new JLabel(new ImageIcon(
        ImageLoader.shopBanner.getScaledInstance(500, 250, Image.SCALE_DEFAULT)));
    shopPanel.add(headBanner, BorderLayout.NORTH);
  }

  /**
   * Menambahkan tombol pada content Shop.
   */
  private void addMenu() {
    JPanel menuPanel = new JPanel();
    shopPanel.add(menuPanel, BorderLayout.CENTER);
    menuPanel.setLayout(new GridLayout(5, 3));
    menuPanel.setBackground(MainFrame.DARK_GRAY);

    JButton powerUp = addButton(ImageLoader.powerUpButton);
    JButton items = addButton(ImageLoader.itemsButton);
    JButton menu = addButton(ImageLoader.menuButton);
    menuPanel.add(powerUp, BorderLayout.NORTH);
    menuPanel.add(items, BorderLayout.CENTER);
    menuPanel.add(menu, BorderLayout.SOUTH);

    powerUp.setBorder(BorderFactory.createEmptyBorder());
    powerUp.setContentAreaFilled(false);

    items.setBorder(BorderFactory.createEmptyBorder());
    items.setContentAreaFilled(false);

    menu.setBorder(BorderFactory.createEmptyBorder());
    menu.setContentAreaFilled(false);

    menuPanel.setVisible(true);

    menu.addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            Menu mainMenu = new Menu();

          }
        }
    );
    powerUp.addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            PowerUpsView pwrUp = new PowerUpsView();

          }
        }
    );
    items.addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            ItemsView itemsV = new ItemsView();

          }
        }
    );
  }

  /**
   * Mengubah gambar menjadi button yang akan digunakan pada shop.
   *
   * @param img gambar yang akan digunakan.
   * @return JButton yang akan ditambahkan.
   */
  private JButton addButton(BufferedImage img) {
    JButton button = new JButton(new ImageIcon(
        img.getScaledInstance(350, 70, Image.SCALE_DEFAULT)));
    button.setBorder(BorderFactory.createEmptyBorder());
    button.setContentAreaFilled(false);
    return button;
  }
}
