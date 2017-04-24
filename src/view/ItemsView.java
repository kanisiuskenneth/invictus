package view;

import controller.ImageLoader;
import model.goods.*;
import model.main.MainModel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * File: ItemsView.java
 * Created by 13515063 - Kezia Suhendra.
 */
public class ItemsView {
  JPanel itemsPanel;
  int currentId;
  static final Color GRAY = new Color(35, 35, 35);
  static final Color LIGHT_GRAY = new Color(40, 40, 40);

  public ItemsView() {
    currentId = 1;
    SlowSpell itemSlow = new SlowSpell();
    FreezeSpell itemFreeze = new FreezeSpell();
    Potion itemPotion = new Potion();
    LightningSpell itemLightning = new LightningSpell();
    Shield itemShield = new Shield();
    itemsPanel = new JPanel();
    itemsPanel.setBackground(MainFrame.DARK_GRAY);
    itemsPanel.setLayout(new BorderLayout());
    itemsPanel.setSize(MainFrame.width, MainFrame.height);
    int itemBannerWidth = 800;
    int itemBannerHeight = ImageLoader.itemsBanner.getHeight() * itemBannerWidth / ImageLoader.itemsBanner.getWidth();
    MainFrame.mainframe.setContentPane(itemsPanel);
    JLabel headBanner = new JLabel(new ImageIcon(
            ImageLoader.itemsBanner.getScaledInstance(itemBannerWidth, itemBannerHeight, Image.SCALE_DEFAULT)));
    itemsPanel.add(headBanner, BorderLayout.NORTH);
    JPanel menuPanel = new JPanel();
    menuPanel.setLayout(new GridLayout(2, 1));
    itemsPanel.add(menuPanel, BorderLayout.CENTER);

    JPanel menuPanel2 = new JPanel();
    menuPanel2.setLayout(new GridLayout(1, 2));
    menuPanel2.setBackground(GRAY);
    menuPanel.add(menuPanel2);

    JPanel menuPanel1 = new JPanel();
    menuPanel1.setBackground(GRAY);
    menuPanel.add(menuPanel1);

    JPanel descPanel = new JPanel();
    descPanel.setLayout(new GridLayout(7, 1));
    itemsPanel.add(descPanel, BorderLayout.EAST);
    descPanel.setBackground(LIGHT_GRAY);

    JButton slowSpell = new JButton(new ImageIcon(
            ImageLoader.slowButton.getScaledInstance(150, 150, Image.SCALE_DEFAULT)));
    JButton freezeSpell = new JButton(new ImageIcon(
            ImageLoader.freezeButton.getScaledInstance(150, 150, Image.SCALE_DEFAULT)));
    JButton potion = new JButton(new ImageIcon(
            ImageLoader.potionButton.getScaledInstance(150, 150, Image.SCALE_DEFAULT)));
    JButton lightningSpell = new JButton(new ImageIcon(
            ImageLoader.lightningButton.getScaledInstance(150, 150, Image.SCALE_DEFAULT)));
    JButton shield = new JButton(new ImageIcon(
            ImageLoader.shieldButton.getScaledInstance(150, 150, Image.SCALE_DEFAULT)));
    JButton dummy = new JButton(new ImageIcon(
            ImageLoader.dummyImg.getScaledInstance(195, 150, Image.SCALE_DEFAULT)));
    menuPanel2.add(slowSpell);
    menuPanel2.add(freezeSpell);
    menuPanel2.add(potion);
    menuPanel1.add(lightningSpell);
    menuPanel1.add(dummy);
    menuPanel1.add(shield);

    slowSpell.setBorder(BorderFactory.createEmptyBorder());
    slowSpell.setContentAreaFilled(false);

    freezeSpell.setBorder(BorderFactory.createEmptyBorder());
    freezeSpell.setContentAreaFilled(false);

    potion.setBorder(BorderFactory.createEmptyBorder());
    potion.setContentAreaFilled(false);

    lightningSpell.setBorder(BorderFactory.createEmptyBorder());
    lightningSpell.setContentAreaFilled(false);

    shield.setBorder(BorderFactory.createEmptyBorder());
    shield.setContentAreaFilled(false);

    dummy.setBorder(BorderFactory.createEmptyBorder());
    dummy.setContentAreaFilled(false);

    JLabel descBanner = new JLabel(new ImageIcon(
            ImageLoader.descriptionBanner.getScaledInstance(300, 50, Image.SCALE_DEFAULT)));
    descBanner.setBorder(new EmptyBorder(0, 50, 0, 50));
    descPanel.add(descBanner, BorderLayout.NORTH);
    JLabel name = new JLabel("", SwingConstants.CENTER);
    descPanel.add(name);
    JLabel desc = new JLabel("", SwingConstants.CENTER);
    descPanel.add(desc);

    JPanel pricePanel = new JPanel();
    descPanel.add(pricePanel);
    pricePanel.setBackground(LIGHT_GRAY);
    JLabel coin = new JLabel(new ImageIcon(
            ImageLoader.coin.getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
    pricePanel.add(coin);
    JLabel price = new JLabel("", SwingConstants.CENTER);
    pricePanel.add(price);
    name.setForeground(Color.WHITE);
    desc.setForeground(Color.YELLOW);
    price.setForeground(Color.GREEN);
    name.setText("Slow Spell");
    name.setFont(new Font("Courier New", Font.PLAIN, 40));
    desc.setText("<html>decrease the speed <br> of the words <br> by 0.5.</html>");
    desc.setFont(new Font("Courier New", Font.PLAIN, 30));
    price.setText("" + itemSlow.getPrice());
    price.setFont(new Font("Courier New", Font.PLAIN, 30));

    JButton buy = new JButton(new ImageIcon(
            ImageLoader.buyButton.getScaledInstance(80, 40, Image.SCALE_DEFAULT)));
    descPanel.add(buy);
    buy.setBorder(BorderFactory.createEmptyBorder());
    buy.setContentAreaFilled(false);

    JPanel sub = new JPanel();
    sub.setLayout(new GridLayout(1, 2));
    descPanel.add(sub, BorderLayout.SOUTH);
    sub.setBackground(LIGHT_GRAY);

    JButton back = new JButton(new ImageIcon(
            ImageLoader.arrowButton.getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
    sub.add(back, BorderLayout.AFTER_LAST_LINE);
    back.setBorder(BorderFactory.createEmptyBorder());
    back.setContentAreaFilled(false);

    JButton home = new JButton(new ImageIcon(
            ImageLoader.homeButton.getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
    sub.add(home, BorderLayout.AFTER_LAST_LINE);
    home.setBorder(BorderFactory.createEmptyBorder());
    home.setContentAreaFilled(false);

    JPanel header = new JPanel();
    descPanel.add(header);
    JLabel coin1 = new JLabel(new ImageIcon(
            ImageLoader.coin.getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
    header.add(coin1);
    JLabel money = new JLabel("" + MainModel.coin);
    money.setFont(new Font("Courier New", Font.PLAIN, 30));
    header.setBackground(LIGHT_GRAY);
    money.setForeground(Color.GREEN);
    header.add(money);

    JLabel dummySpace = new JLabel(new ImageIcon(
            ImageLoader.dummyImg.getScaledInstance(100, 100, Image.SCALE_DEFAULT)));
    header.add(dummySpace);
    JLabel bag = new JLabel(new ImageIcon(
            ImageLoader.inventoryIcon.getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
    header.add(bag);
    JLabel inventory = new JLabel();
    inventory.setText("" + MainModel.item.get(currentId).second);
    inventory.setFont(new Font("Courier New", Font.PLAIN, 30));
    inventory.setForeground(Color.GREEN);
    header.add(inventory);

    header.setVisible(true);

    menuPanel.setVisible(true);

    slowSpell.addActionListener(
            new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                currentId = 1;
                name.setText("<html>Slow Spell<br></html>");
                name.setFont(new Font("Courier New", Font.PLAIN, 40));
                desc.setText("<html>decrease the speed <br> of the words <br> by 0.5.<br></html>");
                desc.setFont(new Font("Courier New", Font.PLAIN, 30));
                price.setText("" + itemSlow.getPrice());
                price.setFont(new Font("Courier New", Font.PLAIN, 30));
                inventory.setText("" + MainModel.item.get(currentId).second);
                inventory.setFont(new Font("Courier New", Font.PLAIN, 30));
              }
            }
    );
    freezeSpell.addActionListener(
            new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                currentId = 2;
                name.setText("<html>Freeze Spell<br></html>");
                name.setFont(new Font("Courier New", Font.PLAIN, 40));
                desc.setText("<html>stop all of the <br> words on the screen <br> for 10 seconds.<br></html>");
                desc.setFont(new Font("Courier New", Font.PLAIN, 30));
                price.setText("" + itemFreeze.getPrice());
                price.setFont(new Font("Courier New", Font.PLAIN, 30));
                inventory.setText("" + MainModel.item.get(currentId).second);
                inventory.setFont(new Font("Courier New", Font.PLAIN, 30));
              }
            }
    );
    potion.addActionListener(
            new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                currentId = 3;
                name.setText("<html>Potion<br></html>");
                name.setFont(new Font("Courier New", Font.PLAIN, 40));
                desc.setText("<html>increase the current <br> health points by <br> one heart.<br></html>");
                desc.setFont(new Font("Courier New", Font.PLAIN, 30));
                price.setText("" + itemPotion.getPrice());
                price.setFont(new Font("Courier New", Font.PLAIN, 30));
                inventory.setText("" + MainModel.item.get(currentId).second);
                inventory.setFont(new Font("Courier New", Font.PLAIN, 30));
              }
            }
    );
    lightningSpell.addActionListener(
            new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                currentId = 4;
                name.setText("<html>Lightning Spell<br></html>");
                name.setFont(new Font("Courier New", Font.PLAIN, 40));
                desc.setText("<html>destroy all of <br> the words on <br> the screen.<br></html>");
                desc.setFont(new Font("Courier New", Font.PLAIN, 30));
                price.setText("" + itemLightning.getPrice());
                price.setFont(new Font("Courier New", Font.PLAIN, 30));
                inventory.setText("" + MainModel.item.get(currentId).second);
                inventory.setFont(new Font("Courier New", Font.PLAIN, 30));
              }
            }
    );
    shield.addActionListener(
            new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                currentId = 5;
                name.setText("<html>Shield<br></html>");
                name.setFont(new Font("Courier New", Font.PLAIN, 40));
                desc.setText("<html>prevents the health <br> points from reducing <br> for 10 seconds.<br></html>");
                desc.setFont(new Font("Courier New", Font.PLAIN, 30));
                price.setText("" + itemShield.getPrice());
                price.setFont(new Font("Courier New", Font.PLAIN, 30));
                inventory.setText("" + MainModel.item.get(currentId).second);
                inventory.setFont(new Font("Courier New", Font.PLAIN, 30));
              }
            }
    );
    back.addActionListener(
            new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                ShopView shop = new ShopView();
              }
            }
    );
    home.addActionListener(
            new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                Menu main = new Menu();
              }
            }
    );
    buy.addActionListener(
            new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                if (currentId == 1) {
                  System.out.println(itemSlow.getPrice());
                  if (MainModel.coin >= itemSlow.getPrice()) {
                    MainModel.item.get(currentId).second++;
                    MainModel.coin -= itemSlow.getPrice();
                    inventory.setText("" + MainModel.item.get(currentId).second);
                  }
                } else if (currentId == 2) {
                  System.out.println(itemFreeze.getPrice());
                  if (MainModel.coin >= itemFreeze.getPrice()) {
                    MainModel.item.get(currentId).second++;
                    MainModel.coin -= itemFreeze.getPrice();
                    inventory.setText("" + MainModel.item.get(currentId).second);
                  }
                } else if (currentId == 3) {
                  System.out.println(itemPotion.getPrice());
                  if (MainModel.coin >= itemPotion.getPrice()) {
                    MainModel.item.get(currentId).second++;
                    MainModel.coin -= itemPotion.getPrice();
                    inventory.setText("" + MainModel.item.get(currentId).second);
                  }
                } else if (currentId == 4) {
                  System.out.println(itemLightning.getPrice());
                  if (MainModel.coin >= itemLightning.getPrice()) {
                    MainModel.item.get(currentId).second++;
                    MainModel.coin -= itemLightning.getPrice();
                    inventory.setText("" + MainModel.item.get(currentId).second);
                  }
                } else {
                  System.out.println(itemShield.getPrice());
                  if (MainModel.coin >= itemShield.getPrice()) {
                    MainModel.item.get(currentId).second++;
                    MainModel.coin -= itemShield.getPrice();
                    inventory.setText("" + MainModel.item.get(currentId).second);
                  }
                }
                money.setText("" + MainModel.coin);
                MainModel.saveData();
              }
            }
    );
  }
}
