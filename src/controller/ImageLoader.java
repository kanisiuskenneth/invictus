package controller;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.lang.reflect.Executable;
import java.nio.Buffer;

/**
 * File: ImageLoader.java
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
  public static BufferedImage shopBanner;
  public static BufferedImage powerUpBanner;
  public static BufferedImage itemsBanner;
  public static BufferedImage powerUpButton;
  public static BufferedImage itemsButton;
  public static BufferedImage menuButton;
  public static BufferedImage slowButton;
  public static BufferedImage freezeButton;
  public static BufferedImage potionButton;
  public static BufferedImage lightningButton;
  public static BufferedImage shieldButton;
  public static BufferedImage descriptionBanner;
  public static BufferedImage buyButton;
  public static BufferedImage dummyImg;
  public static BufferedImage homeButton;
  public static BufferedImage arrowButton;
  public static BufferedImage coin;
  public static BufferedImage heartIcon;
  public static BufferedImage scoreIcon;
  public static BufferedImage inventoryIcon;
  public static BufferedImage creditsBanner;
  public static BufferedImage gameover_banner;
  public static BufferedImage enterName;

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
      shopBanner = ImageIO.read(new File("img/shopbanner.png"));
      powerUpBanner = ImageIO.read(new File("img/powerupbanner.png"));
      itemsBanner = ImageIO.read(new File("img/itemsbanner.png"));
      powerUpButton = ImageIO.read(new File("img/powerupbutton.png"));
      itemsButton = ImageIO.read(new File("img/itemsbutton.png"));
      menuButton = ImageIO.read(new File("img/menubutton.png"));
      slowButton = ImageIO.read(new File("img/slow.png"));
      freezeButton = ImageIO.read(new File("img/freeze.png"));
      potionButton = ImageIO.read(new File("img/potion.png"));
      lightningButton = ImageIO.read(new File("img/lightning.png"));
      shieldButton = ImageIO.read(new File("img/shield.png"));
      descriptionBanner = ImageIO.read(new File("img/description.png"));
      buyButton = ImageIO.read(new File("img/buybutton.png"));
      dummyImg = ImageIO.read(new File("img/dummy.png"));
      homeButton = ImageIO.read(new File("img/home.png"));
      arrowButton = ImageIO.read(new File("img/arrow.png"));
      coin = ImageIO.read(new File("img/coin.png"));
      heartIcon = ImageIO.read(new File("img/heart.png"));
      scoreIcon = ImageIO.read(new File("img/score.png"));
      inventoryIcon = ImageIO.read(new File("img/chest.png"));
      creditsBanner = ImageIO.read(new File("img/creditsbanner.png"));
      gameover_banner = ImageIO.read(new File("img/gameover.png"));
      enterName = ImageIO.read(new File("img/entername.png"));
    } catch (Exception e) {
      System.out.println("File not Found Exception");
    }
  }
}
