package view;


import controller.ImageLoader;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * Created by kennethhalim on 4/20/17.
 */
public class Menu extends Container {
    BufferedImage play_image;
    JButton play_button;
    public Menu() {
        JPanel pane = new JPanel();
        MainFrame.mainframe.setContentPane(pane);
        pane.setVisible(true);
        pane.setSize(MainFrame.width,MainFrame.height);
        pane.setBackground(MainFrame.DARK_GRAY);
        JButton label = new JButton("TEST");
        label.setVisible(true);
        pane.add(label);
    }
}