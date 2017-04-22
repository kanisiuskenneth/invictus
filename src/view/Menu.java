package view;


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
        pane.setBackground(Color.BLUE);
        try {
            BufferedImage playb = ImageIO.read(new File("img/playbutton.png"));
            JLabel label = new JLabel(new ImageIcon(playb));
            label.setSize(1366,768);
            label.setVisible(true);
            pane.add(label);
        } catch (Exception e) {
            System.out.println("Error");
        }
    }
}