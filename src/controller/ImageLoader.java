package controller;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.lang.reflect.Executable;
import java.nio.Buffer;

/**
 * Created by kennethhalim on 4/22/17.
 */
public class ImageLoader {
    public static BufferedImage splash;
    public static BufferedImage play_button;
    public static BufferedImage quit_button;
    public static BufferedImage leaderboard_button;
    public static BufferedImage game_logo;
    public static BufferedImage game_banner;
    public static BufferedImage leaderboard_banner;
    public static BufferedImage shop_button;
    public static BufferedImage SPACER;
    public static BufferedImage back_button;

    public ImageLoader() {
        try {
            splash = ImageIO.read(new File("img/comlogo.png"));
            play_button = ImageIO.read(new File("img/playbutton.png"));
            quit_button = ImageIO.read(new File("img/quitbutton.png"));
            leaderboard_button = ImageIO.read(new File("img/leaderboardbutton.png"));
            game_logo = ImageIO.read(new File("img/gamelogo.png"));
            game_banner = ImageIO.read(new File("img/gamebanner.png"));
            shop_button = ImageIO.read(new File("img/shopbutton.png"));
            leaderboard_banner = ImageIO.read(new File("img/leaderboardbanner.png"));
            SPACER = ImageIO.read(new File("img/spacer.png"));
            back_button = ImageIO.read(new File("img/backbutton.png"));
        } catch (Exception e) {
            System.out.println("File not Found Exception");
        }
    }
}
