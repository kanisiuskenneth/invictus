package view;


import controller.ImageLoader;
import sun.applet.Main;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * Created by kennethhalim on 4/20/17.
 */
public class Menu extends Container {
    public Menu() {
        JPanel main_panel = new JPanel();
        MainFrame.mainframe.setContentPane(main_panel);
        main_panel.setSize(MainFrame.width,MainFrame.height);
        main_panel.setBackground(MainFrame.DARK_GRAY);
        main_panel.setLayout(new BorderLayout(0,60));

        JLabel gamelogo = new JLabel(new ImageIcon(ImageLoader.game_banner.getScaledInstance(800,220,Image.SCALE_SMOOTH)));
        main_panel.add(gamelogo,BorderLayout.NORTH);
        JPanel menu_panel = new JPanel();
        main_panel.add(menu_panel,BorderLayout.CENTER);
        menu_panel.setLayout(new GridLayout(4,1));
        menu_panel.setBackground(MainFrame.DARK_GRAY);

        JButton play = new JButton(new ImageIcon(
                ImageLoader.play_button.getScaledInstance(400,80,Image.SCALE_FAST)));
        JButton quit = new JButton(new ImageIcon(
                ImageLoader.quit_button.getScaledInstance(400,80,Image.SCALE_FAST)));
        JButton leaderboard = new JButton(new ImageIcon(
                ImageLoader.leaderboard_button.getScaledInstance(400,80,Image.SCALE_FAST)));
        JButton shop = new JButton(new ImageIcon(
                ImageLoader.shop_button.getScaledInstance(400,80,Image.SCALE_FAST)));
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

        JLabel footer = new JLabel("<html><font color=white>Invictus Team \u00a92017</font></html>");
        footer.setVisible(true);
        main_panel.add(footer,BorderLayout.SOUTH);

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

                    }
                }
        );

    }
}