package view;

import controller.ImageLoader;

import javax.swing.*;
import java.awt.*;

/**
 * Created by kennethhalim on 4/23/17.
 */
public class ShopView {
    Container temp;
    JPanel shopPanel;

    public ShopView() {
        temp = MainFrame.mainframe.getContentPane();
        shopPanel = new JPanel();
        shopPanel.setBackground(MainFrame.DARK_GRAY);
        shopPanel.setLayout(new BorderLayout());
        shopPanel.setSize(MainFrame.width, MainFrame.height);
        MainFrame.mainframe.setContentPane(shopPanel);
        int headWidth = MainFrame.widthToPx(60);
        int headHeight = headWidth* ImageLoader.shopBanner.getHeight()/
                ImageLoader.shopBanner.getWidth();
        JLabel headBanner = new JLabel(new ImageIcon(
                ImageLoader.shopBanner.getScaledInstance(headWidth,headHeight,Image.SCALE_DEFAULT)));
        shopPanel.add(headBanner,BorderLayout.NORTH);
        JPanel menuPanel = new JPanel();
        shopPanel.add(menuPanel, BorderLayout.CENTER);
        menuPanel.setBackground(Color.yellow);

        JButton powerUp = new JButton(new ImageIcon(
                ImageLoader.powerUpButton.getScaledInstance(350,70,Image.SCALE_DEFAULT)));
        JButton items = new JButton(new ImageIcon(
                ImageLoader.itemsButton.getScaledInstance(350,70,Image.SCALE_DEFAULT)));
        JButton menu = new JButton(new ImageIcon(
                ImageLoader.menuButton.getScaledInstance(350,70,Image.SCALE_DEFAULT)));
        menuPanel.add(powerUp);
        menuPanel.add(items);
        menuPanel.add(menu);

        powerUp.setBorder(BorderFactory.createEmptyBorder());
        powerUp.setContentAreaFilled(false);

        items.setBorder(BorderFactory.createEmptyBorder());
        items.setContentAreaFilled(false);

        menu.setBorder(BorderFactory.createEmptyBorder());
        menu.setContentAreaFilled(false);

        menuPanel.setVisible(true);
        /*
        int contentHeight = MainFrame.heightToPx(65);
        System.out.println(ImageLoader.game_banner.getHeight());
        JLabel gamelogo = new JLabel(new ImageIcon(
                ImageLoader.game_banner.getScaledInstance(
                        banner_width, banner_height,Image.SCALE_SMOOTH)));*/
    }
}
