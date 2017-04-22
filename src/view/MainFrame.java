package view;

import view.util.ImagePanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * Created by kennethhalim on 4/21/17.
 */
public class MainFrame {
    static GraphicsDevice device = GraphicsEnvironment
            .getLocalGraphicsEnvironment().getScreenDevices()[0];
    static int height;
    static int width;
    public static JFrame mainframe;
    public static Color DARK_GRAY = new Color(30,30,30);

    public MainFrame() {

        mainframe = new JFrame("Undefeated Typer");
        mainframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainframe.setResizable(false);
        width = device.getDisplayMode().getWidth();
        height = device.getDisplayMode().getHeight();
        System.out.println(height);
        System.out.println(width);
        mainframe.getContentPane().setBackground(DARK_GRAY);
        mainframe.setSize(width,height);
        mainframe.setVisible(true);
        try {
            BufferedImage img;
            img = ImageIO.read(new File("img/comlogo.png"));
            MainFrame.mainframe.add(new JLabel(new ImageIcon(img.getScaledInstance(960,540,Image.SCALE_SMOOTH))));

        } catch (Exception e) {

        }
        device.setFullScreenWindow(mainframe);
    }

}
