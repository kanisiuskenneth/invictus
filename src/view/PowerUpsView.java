package view;

import controller.ImageLoader;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by sylviajuliana on 23-Apr-17.
 */
public class PowerUpsView {
  Container old;
  JPanel powerUpPanel;
  static final Color LIGHT_GRAY = new Color(40, 40, 40);

  public PowerUpsView() {
    old = MainFrame.mainframe.getContentPane();
    powerUpPanel = new JPanel();
    powerUpPanel.setBackground(MainFrame.DARK_GRAY);
    powerUpPanel.setLayout(new BorderLayout());
    powerUpPanel.setSize(MainFrame.width, MainFrame.height);
    MainFrame.mainframe.setContentPane(powerUpPanel);
    JLabel headBanner = new JLabel(new ImageIcon(
            ImageLoader.powerUpBanner.getScaledInstance(500, 250, Image.SCALE_DEFAULT)));
    powerUpPanel.add(headBanner, BorderLayout.NORTH);

    JPanel menuPanel = new JPanel();
    powerUpPanel.add(menuPanel, BorderLayout.CENTER);
    menuPanel.setLayout(new GridLayout(5,3));
    menuPanel.setBackground(MainFrame.DARK_GRAY);

    JPanel menuPanel2 = new JPanel();
    menuPanel2.setLayout(new GridLayout(7,1));
    powerUpPanel.add(menuPanel2, BorderLayout.EAST);
    menuPanel2.setBackground(LIGHT_GRAY);

    JButton plusCoin = new JButton(new ImageIcon(
            ImageLoader.plusButton.getScaledInstance(350, 70, Image.SCALE_DEFAULT)));
    JButton plusScore = new JButton(new ImageIcon(
            ImageLoader.plusButton.getScaledInstance(350, 70, Image.SCALE_DEFAULT)));
    menuPanel.add(plusCoin, BorderLayout.NORTH);
    menuPanel.add(plusScore, BorderLayout.SOUTH);

    plusCoin.setBorder(BorderFactory.createEmptyBorder());
    plusCoin.setContentAreaFilled(false);

    plusScore.setBorder(BorderFactory.createEmptyBorder());
    plusScore.setContentAreaFilled(false);

    JLabel descBanner = new JLabel(new ImageIcon(
            ImageLoader.descriptionBanner.getScaledInstance(300, 50, Image.SCALE_DEFAULT)));
    descBanner.setBorder(new EmptyBorder(0,50,0,50));
    menuPanel2.add(descBanner, BorderLayout.NORTH);
    JLabel name = new JLabel("",SwingConstants.CENTER);
    menuPanel2.add(name);
    JLabel desc = new JLabel("",SwingConstants.CENTER);
    menuPanel2.add(desc);

    JPanel pricePanel = new JPanel();
    menuPanel2.add(pricePanel);
    pricePanel.setBackground(LIGHT_GRAY);
    JLabel coin = new JLabel(new ImageIcon(
            ImageLoader.coin.getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
    pricePanel.add(coin);
    JLabel price = new JLabel("",SwingConstants.CENTER);
    pricePanel.add(price);
    name.setForeground(Color.WHITE);
    desc.setForeground(Color.YELLOW);
    price.setForeground(Color.GREEN);
    name.setText("Slow Spell");
    name.setFont(new Font("Courier New",Font.PLAIN,40));
    desc.setText("<html>decrease the speed <br> of the words <br> by 0.5.</html>");
    desc.setFont(new Font("Courier New",Font.PLAIN,30));
    price.setText("0");
    price.setFont(new Font("Courier New",Font.PLAIN,30));

    JButton buy = new JButton(new ImageIcon(
            ImageLoader.buyButton.getScaledInstance(80, 40, Image.SCALE_DEFAULT)));
    menuPanel2.add(buy);
    buy.setBorder(BorderFactory.createEmptyBorder());
    buy.setContentAreaFilled(false);

    JPanel sub = new JPanel();
    sub.setLayout(new GridLayout(1,2));
    menuPanel2.add(sub, BorderLayout.SOUTH);
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
    freezeSpell.addActionListener(
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
    potion.addActionListener(
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

    plusCoin.addActionListener(
            new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                Menu mainMenu = new Menu();
              }
            }
    );
    plusScore.addActionListener(
            new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                Menu mainMenu = new Menu();
              }
            }
    );
  }
}
