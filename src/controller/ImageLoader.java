package controller;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

/**
 * File: ImageLoader.java
 * Created by kennethhalim on 4/22/17.
 */

/**
 * Kelas Singleton ImageLoader.
 */
public class ImageLoader {
  public static BufferedImage splash;
  public static BufferedImage playButton;
  public static BufferedImage quitButton;
  public static BufferedImage leaderboard_button;
  public static BufferedImage gameBanner;
  public static BufferedImage leaderboardBanner;
  public static BufferedImage shopButton;
  public static BufferedImage SPACER;
  public static BufferedImage backButton;
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
  public static BufferedImage gameoverBanner;
  public static BufferedImage enterName;

  /**
   * Constructor ImageLoader.
   */
  public ImageLoader() {
    try {
      splash = ImageIO.read(getClass().getResource("/img/comlogo.png"));
      playButton = ImageIO.read(getClass().getResource("/img/playbutton.png"));
      quitButton = ImageIO.read(getClass().getResource("/img/quitbutton.png"));
      leaderboard_button = ImageIO.read(getClass().getResource("/img/leaderboardbutton.png"));
      gameBanner = ImageIO.read(getClass().getResource("/img/gamebanner.png"));
      shopButton = ImageIO.read(getClass().getResource("/img/shopbutton.png"));
      leaderboardBanner = ImageIO.read(getClass().getResource("/img/leaderboardbanner.png"));
      SPACER = ImageIO.read(getClass().getResource("/img/spacer.png"));
      backButton = ImageIO.read(getClass().getResource("/img/backbutton.png"));
      shopBanner = ImageIO.read(getClass().getResource("/img/shopbanner.png"));
      powerUpBanner = ImageIO.read(getClass().getResource("/img/powerupbanner.png"));
      itemsBanner = ImageIO.read(getClass().getResource("/img/itemsbanner.png"));
      powerUpButton = ImageIO.read(getClass().getResource("/img/powerupbutton.png"));
      itemsButton = ImageIO.read(getClass().getResource("/img/itemsbutton.png"));
      menuButton = ImageIO.read(getClass().getResource("/img/menubutton.png"));
      slowButton = ImageIO.read(getClass().getResource("/img/slow.png"));
      freezeButton = ImageIO.read(getClass().getResource("/img/freeze.png"));
      potionButton = ImageIO.read(getClass().getResource("/img/potion.png"));
      lightningButton = ImageIO.read(getClass().getResource("/img/lightning.png"));
      shieldButton = ImageIO.read(getClass().getResource("/img/shield.png"));
      descriptionBanner = ImageIO.read(getClass().getResource("/img/description.png"));
      buyButton = ImageIO.read(getClass().getResource("/img/buybutton.png"));
      dummyImg = ImageIO.read(getClass().getResource("/img/dummy.png"));
      homeButton = ImageIO.read(getClass().getResource("/img/home.png"));
      arrowButton = ImageIO.read(getClass().getResource("/img/arrow.png"));
      coin = ImageIO.read(getClass().getResource("/img/coin.png"));
      heartIcon = ImageIO.read(getClass().getResource("/img/heart.png"));
      scoreIcon = ImageIO.read(getClass().getResource("/img/score.png"));
      inventoryIcon = ImageIO.read(getClass().getResource("/img/chest.png"));
      creditsBanner = ImageIO.read(getClass().getResource("/img/creditsbanner.png"));
      gameoverBanner = ImageIO.read(getClass().getResource("/img/gameover.png"));
      enterName = ImageIO.read(getClass().getResource("/img/entername.png"));
    } catch (Exception e) {
      System.out.println("File not Found Exception");
      System.exit(1);
    }
  }
}
