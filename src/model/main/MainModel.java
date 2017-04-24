package model.main;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Vector;

import jdk.nashorn.internal.objects.annotations.Constructor;
import model.goods.*;
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
  public static HashMap<Items, Integer> item;
  public static Pair<String, Integer>[] leaderboard;
  public static Vector<String> word_bank;
  public static final String VERSION = "UT alpha v1.0";
  /**
   * Constructor.
   */
  public MainModel() {
    item = new HashMap<Items, Integer>();
    word_bank = new Vector<String>();
    leaderboard = new Pair[5];
    loadData("asset/data.txt");
    loadWord("asset/word.txt");
    saveData();
    //nunggu word.txt nya ada
    System.out.println(health_maximum);
    System.out.println(coin);
    System.out.println(coin_multiplier);
    System.out.println(score_multiplier);
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
        String itemClass = scanner.next();
        int secondValue = scanner.nextInt();
        try {
          Class cls = Class.forName(itemClass);
          Class parameterTypes[] = null;
          //Items items =
          java.lang.reflect.Constructor ct = cls.getConstructor(parameterTypes);
          Object argList[] = null;
          Object items = ct.newInstance(argList);
          System.out.println("jing");
          System.out.println(" " + cls.getName());
          item.put((Items) items, secondValue);
        } catch (Throwable e) {
          System.out.println("TOD");
          System.err.println(e);
        }
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
   * Save data player dari file eksternal.
   */
  public static void saveData() {
    File outFile = new File("asset/data.txt");
    try {
      PrintWriter fileWriter = new PrintWriter(outFile);
      fileWriter.println(health_maximum + " " + coin + " " + coin_multiplier + " " + score_multiplier);
      for (Map.Entry<Items, Integer> entry : item.entrySet()) {
        fileWriter.println(entry.getKey().getId() + " " + entry.getKey().getClass().getName() + " " + entry.getValue());
      }
      fileWriter.println("-");
      for (int i = 0; i < 5; i++) {
        fileWriter.println(leaderboard[i].first + " " + leaderboard[i].second);
      }
      System.out.println("Save Done");
      fileWriter.close();
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
