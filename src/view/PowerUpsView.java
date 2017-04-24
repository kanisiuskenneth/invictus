package view;

import controller.ImageLoader;
import model.goods.CoinMultiplier;
import model.goods.HealthUpgrade;
import model.goods.ScoreMultiplier;
import model.main.MainModel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * File: PowerUps.java
 * Created by sylviajuliana on 23-Apr-17.
 */
public class PowerUpsView {
  JPanel powerUpPanel;
  private int currentId;
  static final Color LIGHT_GRAY = new Color(40, 40, 40);
  static final Color GRAY = new Color(35, 35, 35);

  public PowerUpsView() {
    currentId = 1;
    CoinMultiplier itemCoinMultiplier = new CoinMultiplier();
    ScoreMultiplier itemScoreMultiplier = new ScoreMultiplier();
    HealthUpgrade itemHealthUpgrade = new HealthUpgrade();
    powerUpPanel = new JPanel();
    powerUpPanel.setBackground(MainFrame.DARK_GRAY);
    powerUpPanel.setLayout(new BorderLayout());
    powerUpPanel.setSize(MainFrame.width, MainFrame.height);
    int itemBannerWidth = 800;
    int itemBannerHeight = ImageLoader.powerUpBanner.getHeight() * itemBannerWidth / ImageLoader.powerUpBanner.getWidth();
    MainFrame.mainframe.setContentPane(powerUpPanel);
    JLabel headBanner = new JLabel(new ImageIcon(
      ImageLoader.powerUpBanner.getScaledInstance(itemBannerWidth, itemBannerHeight, Image.SCALE_DEFAULT)));
    powerUpPanel.add(headBanner, BorderLayout.NORTH);

    JPanel menuPanel = new JPanel();
    powerUpPanel.add(menuPanel, BorderLayout.CENTER);
    menuPanel.setLayout(new GridLayout(3, 1));
    menuPanel.setBackground(GRAY);

    JPanel descPanel = new JPanel();
    descPanel.setLayout(new GridLayout(7, 1));
    powerUpPanel.add(descPanel, BorderLayout.EAST);
    descPanel.setBackground(LIGHT_GRAY);

    JPanel coinM = new JPanel();
    coinM.setLayout(new GridLayout(1, 2));
    coinM.setBackground(GRAY);
    menuPanel.add(coinM);

    JPanel scoreM = new JPanel();
    scoreM.setLayout(new GridLayout(1, 2));
    scoreM.setBackground(GRAY);
    menuPanel.add(scoreM);

    JPanel healthU = new JPanel();
    healthU.setLayout(new GridLayout(1, 2));
    healthU.setBackground(GRAY);
    menuPanel.add(healthU);

    JButton coinMultiplier = new JButton(new ImageIcon(
      ImageLoader.coin.getScaledInstance(100, 100, Image.SCALE_DEFAULT)));
    JButton scoreMultiplier = new JButton(new ImageIcon(
      ImageLoader.scoreIcon.getScaledInstance(100, 100, Image.SCALE_DEFAULT)));
    JButton healthUpgrade = new JButton(new ImageIcon(
      ImageLoader.heartIcon.getScaledInstance(100, 100, Image.SCALE_DEFAULT)));

    String coinText = "<html> <font color = 'green'>";
    for (float i = 1; i < MainModel.coin_multiplier; i += 0.1) {
      coinText += "\u2588 ";
    }
    coinText += "</font><font color = 'white'>";
    for (float i = MainModel.coin_multiplier; i < 2; i += 0.1) {
      coinText += "\u2588 ";
    }
    coinText += "</font></html>";
    JLabel coinBar = new JLabel(coinText);
    //JLabel coinBar = new JLabel("\u2588 \u2588 \u2588 \u2588 \u2588 \u2588 \u2588 \u2588 \u2588 \u2588");
    coinBar.setFont(new Font("Courier New", Font.PLAIN, 35));
    coinBar.setForeground(Color.WHITE);

    String scoreText = "<html> <font color = 'green'>";
    for (float i = 1; i < MainModel.score_multiplier; i += 0.1) {
      scoreText += "\u2588 ";
    }
    scoreText += "</font><font color = 'white'>";
    for (float i = MainModel.score_multiplier; i < 2; i += 0.1) {
      scoreText += "\u2588 ";
    }
    scoreText += "</font></html>";
    JLabel scoreBar = new JLabel(scoreText);
    scoreBar.setFont(new Font("Courier New", Font.PLAIN, 35));
    scoreBar.setForeground(Color.WHITE);

    String healthText = "<html> <font color = 'green'>";
    for (int i = 3; i < MainModel.health_maximum; i++) {
      healthText += "\u2588 ";
    }
    healthText += "</font><font color = 'white'>";
    for (int i = MainModel.health_maximum; i < 13; i++) {
      healthText += "\u2588 ";
    }
    healthText += "</font></html>";
    JLabel healthBar = new JLabel(healthText);
    healthBar.setFont(new Font("Courier New", Font.PLAIN, 35));
    healthBar.setForeground(Color.WHITE);

    coinM.add(coinMultiplier);
    coinM.add(coinBar);
    scoreM.add(scoreMultiplier);
    scoreM.add(scoreBar);
    healthU.add(healthUpgrade);
    healthU.add(healthBar);

    coinMultiplier.setBorder(BorderFactory.createEmptyBorder());
    coinMultiplier.setContentAreaFilled(false);

    scoreMultiplier.setBorder(BorderFactory.createEmptyBorder());
    scoreMultiplier.setContentAreaFilled(false);

    healthUpgrade.setBorder(BorderFactory.createEmptyBorder());
    healthUpgrade.setContentAreaFilled(false);

    JLabel descBanner = new JLabel(new ImageIcon(
      ImageLoader.descriptionBanner.getScaledInstance(300, 50, Image.SCALE_DEFAULT)));
    descBanner.setBorder(new EmptyBorder(0, 50, 0, 50));
    descPanel.add(descBanner, BorderLayout.NORTH);
    JLabel name = new JLabel("", SwingConstants.CENTER);
    descPanel.add(name);
    JLabel desc = new JLabel("", SwingConstants.CENTER);
    descPanel.add(desc);


    JPanel pricePanel = new JPanel();
    //pricePanel.setLayout(new GridLayout(1, 1));
    pricePanel.setBackground(LIGHT_GRAY);
    descPanel.add(pricePanel);

    JLabel coin = new JLabel(new ImageIcon(
      ImageLoader.coin.getScaledInstance(30, 30, Image.SCALE_DEFAULT)));
    pricePanel.add(coin);
    JLabel price = new JLabel("", SwingConstants.CENTER);
    price.setText("" + itemCoinMultiplier.getPrice() * Math.round((MainModel.coin_multiplier - 0.9) * 10));
    pricePanel.setBackground(LIGHT_GRAY);
    price.setFont(new Font("Courier New", Font.PLAIN, 30));
    pricePanel.add(price);
    name.setForeground(Color.WHITE);
    desc.setForeground(Color.YELLOW);
    price.setForeground(Color.GREEN);
    name.setText("Coin Multiplier");
    name.setFont(new Font("Courier New", Font.PLAIN, 35));
    desc.setText("<html>increase the coins <br> multiplier by 0.1 from <br> the base multiplier.<br></html>");
    desc.setFont(new Font("Courier New", Font.PLAIN, 24));

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

    header.setVisible(true);

    menuPanel.setVisible(true);

    coinMultiplier.addActionListener(
      new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          currentId = 1;
          name.setText("Coin Multiplier");
          name.setFont(new Font("Courier New", Font.PLAIN, 35));
          desc.setText("<html>increase the coins <br> multiplier by 0.1 from <br> the base multiplier.<br></html>");
          desc.setFont(new Font("Courier New", Font.PLAIN, 24));
          price.setText("" + itemCoinMultiplier.getPrice() * Math.round((MainModel.coin_multiplier - 0.9) * 10));
          price.setFont(new Font("Courier New", Font.PLAIN, 30));
        }
      }
    );
    scoreMultiplier.addActionListener(
      new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          currentId = 2;
          name.setText("Score Multiplier");
          name.setFont(new Font("Courier New", Font.PLAIN, 35));
          desc.setText("<html>increase the scores <br> multiplier by 0.1 from <br> the base multiplier.<br></html>");
          desc.setFont(new Font("Courier New", Font.PLAIN, 24));
          price.setText("" + itemScoreMultiplier.getPrice() * Math.round((MainModel.score_multiplier - 0.9) * 10));
          price.setFont(new Font("Courier New", Font.PLAIN, 30));
        }
      }
    );
    healthUpgrade.addActionListener(
      new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          currentId = 3;
          name.setText("Health Upgrade");
          name.setFont(new Font("Courier New", Font.PLAIN, 35));
          desc.setText("<html>increase the maximum <br> of health points <br> by one heart.<br></html>");
          desc.setFont(new Font("Courier New", Font.PLAIN, 24));
          price.setText("" + itemHealthUpgrade.getPrice() * (MainModel.health_maximum - 2));
          price.setFont(new Font("Courier New", Font.PLAIN, 30));
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
            if (MainModel.coin >= itemCoinMultiplier.getPrice() * (MainModel.coin_multiplier - 0.9) * 10 && MainModel.coin_multiplier < 2) {
              MainModel.coin -= itemCoinMultiplier.getPrice() * (MainModel.coin_multiplier - 0.9) * 10;
              MainModel.coin_multiplier += 0.1;
              price.setText("" + itemCoinMultiplier.getPrice() * Math.round((MainModel.coin_multiplier - 0.9) * 10));
              // set bar
              String coinText = "<html> <font color = 'green'>";
              for (float i = 1; i < MainModel.coin_multiplier; i += 0.1) {
                coinText += "\u2588 ";
              }
              coinText += "</font><font color = 'white'>";
              for (float i = MainModel.coin_multiplier; i < 2; i += 0.1) {
                coinText += "\u2588 ";
              }
              coinText += "</font></html>";
              coinBar.setText(coinText);
            }
          } else if (currentId == 2) {
            if (MainModel.coin >= itemScoreMultiplier.getPrice() * (MainModel.score_multiplier - 0.9) * 10 && MainModel.score_multiplier < 2) {
              MainModel.coin -= itemScoreMultiplier.getPrice() * (MainModel.score_multiplier - 0.9) * 10;
              MainModel.score_multiplier += 0.1;
              price.setText("" + itemScoreMultiplier.getPrice() * Math.round((MainModel.score_multiplier - 0.9) * 10));
              // set bar
              String scoreText = "<html> <font color = 'green'>";
              for (float i = 1; i < MainModel.score_multiplier; i += 0.1) {
                scoreText += "\u2588 ";
              }
              scoreText += "</font><font color = 'white'>";
              for (float i = MainModel.score_multiplier; i < 2; i += 0.1) {
                scoreText += "\u2588 ";
              }
              scoreText += "</font></html>";
              scoreBar.setText(scoreText);
            }
          } else {
            if (MainModel.coin >= itemHealthUpgrade.getPrice() * (MainModel.health_maximum - 2) * 10 && MainModel.health_maximum < 13) {
              MainModel.coin -= itemHealthUpgrade.getPrice() * (MainModel.health_maximum - 2);
              MainModel.health_maximum += 1;
              price.setText("" + itemHealthUpgrade.getPrice() * (MainModel.health_maximum - 2));
              // set bar
              String healthText = "<html> <font color = 'green'>";
              for (int i = 3; i < MainModel.health_maximum; i++) {
                healthText += "\u2588 ";
              }
              healthText += "</font><font color = 'white'>";
              for (int i = MainModel.health_maximum; i < 13; i++) {
                healthText += "\u2588 ";
              }
              healthText += "</font></html>";
              healthBar.setText(healthText);
            }
          }
          money.setText("" + MainModel.coin);
          MainModel.saveData();
        }
      }
    );
  }
}
