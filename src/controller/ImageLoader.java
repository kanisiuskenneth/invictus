package controller;

import javax.imageio.ImageIO;
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

    public ImageLoader() {
        try {
            splash = ImageIO.read(new File("img/comlogo.png"));
            play_button = ImageIO.read(new File("img/playbutton.png"));
        } catch (Exception e) {
            System.out.println("File not Found Exception");
        }
    }
}
