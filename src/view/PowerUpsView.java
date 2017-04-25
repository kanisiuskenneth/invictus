package view;

import controller.ImageLoader;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import model.goods.CoinMultiplier;
import model.goods.HealthUpgrade;
import model.goods.ScoreMultiplier;
import model.main.MainModel;

/**
 * File: PowerUpsView.java
 * Created by sylviajuliana on 23-Apr-17.
 */

/**
 * Kelas PowerUpsView.
 */
public class PowerUpsView {

  JPanel powerUpPanel;
  private int currentId;
  static final Color LIGHT_GRAY = new Color(40, 40, 40);
  static final Color GRAY = new Color(35, 35, 35);
  private CoinMultiplier itemCoinMultiplier = new CoinMultiplier();
  private ScoreMultiplier itemScoreMultiplier = new ScoreMultiplier();
  private HealthUpgrade itemHealthUpgrade = new HealthUpgrade();

  /**
   * Constructor.
   */
  public PowerUpsView() {
    currentId = 1;
    powerUpPanel = new JPanel();
    powerUpPanel.setBackground(MainFrame.DARK_GRAY);
    powerUpPanel.setLayout(new BorderLayout());
    powerUpPanel.setSize(MainFrame.width, MainFrame.height);
    addPowerBanner();
    addMenu();
    powerUpPanel.setVisible(true);
  }

  /**
   * Menambahkan logo power up pada bagian atas dari panel power up.
   */
  private void addPowerBanner() {
    int itemBannerWidth = 800;
    int itemBannerHeight =
        ImageLoader.powerUpBanner.getHeight() * itemBannerWidth / ImageLoader.powerUpBanner
            .getWidth();
    MainFrame.mainframe.setContentPane(powerUpPanel);
    JLabel headBanner = new JLabel(new ImageIcon(
        ImageLoader.powerUpBanner
            .getScaledInstance(itemBannerWidth, itemBannerHeight, Image.SCALE_DEFAULT)));
    powerUpPanel.add(headBanner, BorderLayout.NORTH);
  }

  /**
   * Menambahkan tombol dan gambar power up pada content power up.
   */
  private void addMenu() {
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

    String coinText = "<html> <font color = 'green'>";
    for (double i = 1; i < MainModel.coin_multiplier; i += 0.1) {
      coinText += "█ ";
    }
    coinText += "</font><font color = 'white'>";
    for (double i = MainModel.coin_multiplier; i < 1.999; i += 0.1) {
      coinText += "█ ";
    }
    coinText += "</font></html>";
    JLabel coinBar = new JLabel(coinText);
    coinBar.setFont(new Font("Courier New", Font.PLAIN, 35));
    coinBar.setForeground(Color.WHITE);

    String scoreText = "<html> <font color = 'green'>";
    for (double i = 1; i < MainModel.score_multiplier; i += 0.1) {
      scoreText += "█ ";
    }
    scoreText += "</font><font color = 'white'>";
    for (double i = MainModel.score_multiplier; i < 1.999; i += 0.1) {
      scoreText += "█ ";
    }
    scoreText += "</font></html>";
    JLabel scoreBar = new JLabel(scoreText);
    scoreBar.setFont(new Font("Courier New", Font.PLAIN, 35));
    scoreBar.setForeground(Color.WHITE);

    String healthText = "<html> <font color = 'green'>";
    for (int i = 3; i < MainModel.health_maximum; i++) {
      healthText += "█ ";
    }
    healthText += "</font><font color = 'white'>";
    for (int i = MainModel.health_maximum; i < 13; i++) {
      healthText += "█ ";
    }
    healthText += "</font></html>";
    JLabel healthBar = new JLabel(healthText);
    healthBar.setFont(new Font("Courier New", Font.PLAIN, 35));
    healthBar.setForeground(Color.WHITE);
    JButton coinMultiplier = new JButton(new ImageIcon(
        ImageLoader.coin.getScaledInstance(100, 100, Image.SCALE_DEFAULT)));
    coinM.add(coinMultiplier);
    coinM.add(coinBar);
    JButton scoreMultiplier = new JButton(new ImageIcon(
        ImageLoader.scoreIcon.getScaledInstance(100, 100, Image.SCALE_DEFAULT)));
    scoreM.add(scoreMultiplier);
    scoreM.add(scoreBar);
    JButton healthUpgrade = new JButton(new ImageIcon(
        ImageLoader.heartIcon.getScaledInstance(100, 100, Image.SCALE_DEFAULT)));
    healthU.add(healthUpgrade);
    healthU.add(healthBar);
    coinMultiplier.setBorder(BorderFactory.createEmptyBorder());
    coinMultiplier.setContentAreaFilled(false);

    scoreMultiplier.setBorder(BorderFactory.createEmptyBorder());
    scoreMultiplier.setContentAreaFilled(false);

    healthUpgrade.setBorder(BorderFactory.createEmptyBorder());
    healthUpgrade.setContentAreaFilled(false);

    JLabel descBanner = new JLabel(new ImageIcon(
        ImageLoader.descriptionBanner
            .getScaledInstance(300, 50, Image.SCALE_DEFAULT)));
    descBanner.setBorder(new EmptyBorder(0, 50, 0, 50));
    descPanel.add(descBanner, BorderLayout.NORTH);
    JLabel name = new JLabel("", SwingConstants.CENTER);
    descPanel.add(name);
    JLabel desc = new JLabel("", SwingConstants.CENTER);
    descPanel.add(desc);

    JPanel pricePanel = new JPanel();
    pricePanel.setBackground(LIGHT_GRAY);
    descPanel.add(pricePanel);

    JLabel coin = new JLabel(new ImageIcon(
        ImageLoader.coin.getScaledInstance(30, 30, Image.SCALE_DEFAULT)));
    pricePanel.add(coin);
    JLabel price = new JLabel("", SwingConstants.CENTER);
    price.setText(
        "" + itemCoinMultiplier.getPrice() * Math.round((MainModel.coin_multiplier - 0.9) * 10));
    pricePanel.setBackground(LIGHT_GRAY);
    price.setFont(new Font("Courier New", Font.PLAIN, 30));
    pricePanel.add(price);
    name.setForeground(Color.WHITE);
    desc.setForeground(Color.YELLOW);
    price.setForeground(Color.GREEN);
    name.setText("Coin Multiplier");
    name.setFont(new Font("Courier New", Font.PLAIN, 35));
    desc.setText(
        "<html>increase the coins <br> multiplier by 0.1 from <br>"
            + " the base multiplier.<br></html>");
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
            desc.setText(
                "<html>increase the coins <br> multiplier "
                    + "by 0.1 from <br> the base multiplier.<br></html>");
            desc.setFont(new Font("Courier New", Font.PLAIN, 24));
            price.setText("" + itemCoinMultiplier.getPrice() * Math
                .round((MainModel.coin_multiplier - 0.9) * 10));
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
            desc.setText(
                "<html>increase the scores <br> "
                    + "multiplier by 0.1 from <br> the base multiplier.<br></html>");
            desc.setFont(new Font("Courier New", Font.PLAIN, 24));
            price.setText("" + itemScoreMultiplier.getPrice() * Math
                .round((MainModel.score_multiplier - 0.9) * 10));
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
            desc.setText(
                "<html>increase the maximum <br> of health points <br> by one heart.<br></html>");
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
              if (MainModel.coin >= itemCoinMultiplier.getPrice() * (MainModel.coin_multiplier
                  - 0.9) * 10 && MainModel.coin_multiplier < 1.999) {
                itemCoinMultiplier.buy();
                price.setText("" + itemCoinMultiplier.getPrice() * Math
                    .round((MainModel.coin_multiplier - 0.9) * 10));
                // set bar
                String coinText = "<html> <font color = 'green'>";
                for (double i = 1; i < MainModel.coin_multiplier; i += 0.1) {
                  coinText += "█ ";
                }
                coinText += "</font><font color = 'white'>";
                for (double i = MainModel.coin_multiplier; i < 1.999; i += 0.1) {
                  coinText += "█ ";
                }
                coinText += "</font></html>";
                coinBar.setText(coinText);
              }
            } else if (currentId == 2) {
              if (MainModel.coin >= itemScoreMultiplier.getPrice() * (MainModel.score_multiplier
                  - 0.9) * 10 && MainModel.score_multiplier < 1.999) {
                itemScoreMultiplier.buy();
                price.setText("" + itemScoreMultiplier.getPrice() * Math
                    .round((MainModel.score_multiplier - 0.9) * 10));
                // set bar
                String scoreText = "<html> <font color = 'green'>";
                for (double i = 1; i < MainModel.score_multiplier; i += 0.1) {
                  scoreText += "█ ";
                }
                scoreText += "</font><font color = 'white'>";
                for (double i = MainModel.score_multiplier; i < 1.999; i += 0.1) {
                  scoreText += "█ ";
                }
                scoreText += "</font></html>";
                scoreBar.setText(scoreText);
              }
            } else {
              if (MainModel.coin >= itemHealthUpgrade.getPrice() * (MainModel.health_maximum - 2)
                  * 10 && MainModel.health_maximum < 13) {
                itemHealthUpgrade.buy();
                price.setText("" + itemHealthUpgrade.getPrice() * (MainModel.health_maximum - 2));
                // set bar
                String healthText = "<html> <font color = 'green'>";
                for (int i = 3; i < MainModel.health_maximum; i++) {
                  healthText += "█ ";
                }
                healthText += "</font><font color = 'white'>";
                for (int i = MainModel.health_maximum; i < 13; i++) {
                  healthText += "█ ";
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
