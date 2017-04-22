package view;

import controller.ImageLoader;
import javax.swing.*;
import java.awt.*;

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
        JFrame.setDefaultLookAndFeelDecorated(true);
        mainframe = new JFrame("Undefeated Typer");
        mainframe.setIconImage(new ImageIcon("img/gamelogo.png").getImage());
        mainframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainframe.setResizable(false);
        width = device.getDisplayMode().getWidth();
        height = device.getDisplayMode().getHeight();
        System.out.println(height);
        System.out.println(width);
        mainframe.getContentPane().setBackground(DARK_GRAY);
        mainframe.setSize(width,height);
        MainFrame.mainframe.add(new JLabel(new ImageIcon(ImageLoader.splash.getScaledInstance(960,540,Image.SCALE_SMOOTH))));
        mainframe.setVisible(true);
        device.setFullScreenWindow(mainframe);
    }

}
