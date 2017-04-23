package model.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;
import model.goods.Items;
import util.Pair;

/**
 * File: MainModel.java
 * Author: 13515033 - Andika Kusuma
 */

/**
 * Kelas MainModel.
 */
public class MainModel {
  public static int health_maximum;
  public static int coin;
  public static float coin_multiplier;
  public static float score_multiplier;
  public static Vector<Pair<Items, Integer>> item;
  public static Pair<String, Integer>[] leaderboard;
  public static Vector<String> word_bank;
  public static final String VERSION = "UT alpha v1.0";
  /**
   * Constructor.
   */
  public MainModel() {
    item = new Vector<Pair<Items, Integer>>();
    word_bank = new Vector<String>();
    leaderboard = new Pair[5];
    loadData("asset/data.txt");
    loadWord("asset/word.txt");
    //nunggu word.txt nya ada
    System.out.println(health_maximum);
    System.out.println(coin);
    System.out.println(coin_multiplier);
    System.out.println(score_multiplier);
    for (Pair<Items, Integer> pair : item) {
      System.out.println(pair.first + " ada " + pair.second);
    }
    for (int i = 0; i < 5; i++) {
      System.out.println(leaderboard[i].first + " with score " + leaderboard[i].second);
    }
  }

  /**
   * Load data player dari file eksternal.
   * @param inputFile berisi data player.
   */
  public void loadData(String inputFile) {
    try {
      Scanner scanner = new Scanner(new File(inputFile));
      int i = 0;
      health_maximum = scanner.nextInt();
      coin = scanner.nextInt();
      coin_multiplier = scanner.nextFloat();
      score_multiplier = scanner.nextFloat();
      while (scanner.hasNextInt()) {
        int firstValue = scanner.nextInt();
        int secondValue = scanner.nextInt();
        item.add(new Pair(firstValue, secondValue));
      }
      scanner.next();
      while (scanner.hasNext()) {
        String firstValue = scanner.next();
        int secondValue = scanner.nextInt();
        leaderboard[i] = new Pair(firstValue, secondValue);
        i++;
      }
    } catch (IOException e) {
      System.out.println("File I/O error!");
    }
  }

  /**
   * Load data word dari file eksternal.
   * @param inputFile berisi data word.
   */
  public void loadWord(String inputFile) {
    try {
      Scanner scanner = new Scanner(new File(inputFile));
      while (scanner.hasNextLine()) {
        //System.out.println(scanner.nextLine());
        word_bank.add(scanner.nextLine().toUpperCase());
      }
    } catch (IOException e) {
      System.out.println("File I/O error!");
    }
  }
}
