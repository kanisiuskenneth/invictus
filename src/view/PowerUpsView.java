package view;

import com.sun.java.swing.action.AlignCenterAction;
import controller.ImageLoader;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * File: PowerUps.java
 * Created by sylviajuliana on 23-Apr-17.
 */
public class PowerUpsView {
  JPanel powerUpPanel;
  static final Color LIGHT_GRAY = new Color(40, 40, 40);
  static final Color GRAY = new Color(35, 35, 35);

  public PowerUpsView() {
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
    menuPanel.setLayout(new GridLayout(5,3));
    menuPanel.setBackground(GRAY);

    JPanel descPanel = new JPanel();
    descPanel.setLayout(new GridLayout(7,1));
    powerUpPanel.add(descPanel, BorderLayout.EAST);
    descPanel.setBackground(LIGHT_GRAY);

    JLabel descBanner = new JLabel(new ImageIcon(
            ImageLoader.descriptionBanner.getScaledInstance(300, 50, Image.SCALE_DEFAULT)));
    descBanner.setBorder(new EmptyBorder(0,50,0,50));
    descPanel.add(descBanner, BorderLayout.NORTH);
    JLabel name = new JLabel("",SwingConstants.CENTER);
    descPanel.add(name);
    JLabel desc = new JLabel("",SwingConstants.CENTER);
    descPanel.add(desc);

    /*JButton dummy = new JButton(new ImageIcon(
            ImageLoader.dummyImg.getScaledInstance(10, 10, Image.SCALE_DEFAULT)));
    dummy.setBorder(BorderFactory.createEmptyBorder());
    dummy.setContentAreaFilled(false);
    descPanel.add(dummy);*/

    JPanel pricePanel = new JPanel();
    pricePanel.setLayout(new GridLayout(1, 1));
    pricePanel.setBackground(LIGHT_GRAY);
    descPanel.add(pricePanel);
    /*JLabel coin = new JLabel(new ImageIcon(
            ImageLoader.coin.getScaledInstance(30, 30, Image.SCALE_DEFAULT)));
    pricePanel.add(coin);
    JLabel price = new JLabel("",SwingConstants.CENTER);
    pricePanel.add(price);*/

    JLabel coin = new JLabel(new ImageIcon(
            ImageLoader.coin.getScaledInstance(30, 30, Image.SCALE_DEFAULT)));
    pricePanel.add(coin);
    JLabel price = new JLabel("", SwingConstants.CENTER);
    price.setText("0");
    pricePanel.setBackground(LIGHT_GRAY);
    price.setFont(new Font("Courier New",Font.PLAIN,20));
    pricePanel.add(price);
    name.setForeground(Color.WHITE);
    desc.setForeground(Color.YELLOW);
    price.setForeground(Color.GREEN);
    name.setText("Coin Multiplier");
    name.setFont(new Font("Courier New",Font.PLAIN,35));
    desc.setText("<html>increase the coins <br> multiplier by 0.1 <br> from the base <br> multiplier.<br></html>");
    desc.setFont(new Font("Courier New",Font.PLAIN,24));



    JButton buy = new JButton(new ImageIcon(
            ImageLoader.buyButton.getScaledInstance(80, 40, Image.SCALE_DEFAULT)));
    descPanel.add(buy);
    buy.setBorder(BorderFactory.createEmptyBorder());
    buy.setContentAreaFilled(false);

    JPanel sub = new JPanel();
    sub.setLayout(new GridLayout(1,2));
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
    JLabel money = new JLabel("0");
    money.setFont(new Font("Courier New", Font.PLAIN, 30));
    header.setBackground(LIGHT_GRAY);
    money.setForeground(Color.GREEN);
    header.add(money);

    header.setVisible(true);

    menuPanel.setVisible(true);
/*
    coinMultiplier.addActionListener(
            new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                name.setText("<html>Slow Spell<br></html>");
                name.setFont(new Font("Courier New",Font.PLAIN,40));
                desc.setText("<html>decrease the speed <br> of the words <br> by 0.5.<br></html>");
                desc.setFont(new Font("Courier New",Font.PLAIN,30));
                price.setText("0");
                price.setFont(new Font("Courier New",Font.PLAIN,30));
              }
            }
    );
    scoreMultiplier.addActionListener(
            new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                name.setText("<html>Freeze Spell<br></html>");
                name.setFont(new Font("Courier New",Font.PLAIN,40));
                desc.setText("<html>stop all of the <br> words on the screen <br> for 10 seconds.<br></html>");
                desc.setFont(new Font("Courier New",Font.PLAIN,30));
                price.setText("0");
                price.setFont(new Font("Courier New",Font.PLAIN,30));
              }
            }
    );
    healthUpgrade.addActionListener(
            new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                name.setText("<html>Potion<br></html>");
                name.setFont(new Font("Courier New",Font.PLAIN,40));
                desc.setText("<html>increase the current <br> health points by <br> one heart.<br></html>");
                desc.setFont(new Font("Courier New",Font.PLAIN,30));
                price.setText("0");
                price.setFont(new Font("Courier New",Font.PLAIN,30));
              }
            }
    );
   */
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

              }
            }
    );
  }
}
