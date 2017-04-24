package view;

import controller.ImageLoader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * File: ShopView.java
 * Created by 13515063 - Kezia Suhendra.
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
    JLabel headBanner = new JLabel(new ImageIcon(
        ImageLoader.shopBanner.getScaledInstance(500, 250, Image.SCALE_DEFAULT)));
    shopPanel.add(headBanner, BorderLayout.NORTH);
    JPanel menuPanel = new JPanel();
    shopPanel.add(menuPanel, BorderLayout.CENTER);
    menuPanel.setLayout(new GridLayout(5, 3));
    menuPanel.setBackground(MainFrame.DARK_GRAY);

    JButton powerUp = new JButton(new ImageIcon(
        ImageLoader.powerUpButton.getScaledInstance(350, 70, Image.SCALE_DEFAULT)));
    JButton items = new JButton(new ImageIcon(
        ImageLoader.itemsButton.getScaledInstance(350, 70, Image.SCALE_DEFAULT)));
    JButton menu = new JButton(new ImageIcon(
        ImageLoader.menuButton.getScaledInstance(350, 70, Image.SCALE_DEFAULT)));
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
}
