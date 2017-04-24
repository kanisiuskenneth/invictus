package view;


import controller.GameController;
import controller.ImageLoader;
import model.main.MainModel;
import sun.applet.Main;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * File: Menu.java
 * Created by kennethhalim on 4/20/17.
 */
public class Menu {
  public Menu() {
    Container temp = MainFrame.mainframe.getContentPane();
    temp.removeAll();
    MainFrame.mainframe.remove(temp);
    JPanel main_panel = new JPanel();
    MainFrame.mainframe.setContentPane(main_panel);
    main_panel.setBackground(MainFrame.DARK_GRAY);
    main_panel.setLayout(new BorderLayout(0, 0));
    int banner_height = MainFrame.heightToPx(30);
    int banner_width = banner_height * ImageLoader.game_banner.getWidth() / ImageLoader.game_banner.getHeight();
    int content_height = MainFrame.heightToPx(65);
    System.out.println(ImageLoader.game_banner.getHeight());
    JLabel gamelogo = new JLabel(new ImageIcon(
            ImageLoader.game_banner.getScaledInstance(
                    banner_width, banner_height, Image.SCALE_SMOOTH)));
    main_panel.add(gamelogo, BorderLayout.NORTH);
    JPanel menu_panel = new JPanel();
    main_panel.add(menu_panel, BorderLayout.CENTER);
    int content_rows = content_height / 90;
    menu_panel.setLayout(new GridLayout(content_rows, 1));
    menu_panel.setBackground(MainFrame.DARK_GRAY);
    JButton play = new JButton(new ImageIcon(
            ImageLoader.play_button.getScaledInstance(350, 70, Image.SCALE_DEFAULT)));
    JButton quit = new JButton(new ImageIcon(
            ImageLoader.quit_button.getScaledInstance(350, 70, Image.SCALE_DEFAULT)));
    JButton leaderboard = new JButton(new ImageIcon(
            ImageLoader.leaderboard_button.getScaledInstance(350, 70, Image.SCALE_DEFAULT)));
    JButton shop = new JButton(new ImageIcon(
            ImageLoader.shop_button.getScaledInstance(350, 70, Image.SCALE_DEFAULT)));
    menu_panel.add(play);
    menu_panel.add(shop);
    menu_panel.add(leaderboard);
    menu_panel.add(quit);

    shop.setBorder(BorderFactory.createEmptyBorder());
    shop.setContentAreaFilled(false);

    leaderboard.setBorder(BorderFactory.createEmptyBorder());
    leaderboard.setContentAreaFilled(false);

    play.setBorder(BorderFactory.createEmptyBorder());
    play.setContentAreaFilled(false);

    quit.setBorder(BorderFactory.createEmptyBorder());
    quit.setContentAreaFilled(false);

    JPanel footer = new JPanel();
    footer.setLayout(new BorderLayout());
    JLabel copy = new JLabel("Invictus Team \u00a92017");
    JLabel version = new JLabel(MainModel.VERSION);
    footer.setBackground(MainFrame.DARK_GRAY);
    copy.setForeground(Color.WHITE);
    version.setForeground(Color.WHITE);
    copy.setVisible(true);
    footer.add(copy, BorderLayout.WEST);
    footer.add(version, BorderLayout.EAST);
    main_panel.add(footer, BorderLayout.SOUTH);
    menu_panel.setVisible(true);
    MainFrame.mainframe.setVisible(true);

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
                //MainFrame.mainframe.removeAll();
                //new Menu();
                new GameView();
                //new GameController();
              }
            }
    );

  }
  private 
}