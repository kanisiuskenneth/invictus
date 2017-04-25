package model.main;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
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
  public static double coin_multiplier;
  public static double score_multiplier;
  public static HashMap<Integer, Pair<Items, Integer>> item;
  public static Pair<String, Integer>[] leaderboard;
  public static Vector<String> word_bank;
  public static final String VERSION = "UT beta v2.0";
  private static final String DATA_PATH = ".ut/data.txt";

  /**
   * Constructor.
   */
  public MainModel() {
    item = new HashMap<Integer, Pair<Items, Integer>>();
    word_bank = new Vector<String>();
    leaderboard = new Pair[5];
    loadData(DATA_PATH);
    loadWord("/asset/word.txt");
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
   *
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
        int id = scanner.nextInt();
        String className = scanner.next();
        int itemAmount = scanner.nextInt();
        try {
          Class cls = Class.forName(className);
          java.lang.reflect.Constructor constructor = cls.getConstructor(new Class[0]);
          Object items = constructor.newInstance(new Object[0]);
          item.put(id, new Pair(items, itemAmount));
          System.out.println(id + " " + items.getClass().getName() + " " + itemAmount);

        } catch (Throwable e) {
          System.err.println(e);
        }
      }
      scanner.next();
      while (scanner.hasNext()) {
        String firstValue = scanner.next();
        while (!scanner.hasNextInt()) {
          firstValue += " " + scanner.next();
        }
        int secondValue = scanner.nextInt();
        leaderboard[i] = new Pair(firstValue, secondValue);
        i++;
      }
    } catch (Exception e) {
      System.out.println("No Data File to Loaded");
      createDataFile();
    }
  }

  /**
   * Save data player dari file eksternal.
   */
  public static void saveData() {
    File outFile = new File(DATA_PATH);
    try {
      PrintWriter fileWriter = new PrintWriter(outFile);
      fileWriter.println(health_maximum + " " + coin + " " + coin_multiplier + " "
          + score_multiplier);
      for (Map.Entry<Integer, Pair<Items, Integer>> entry : item.entrySet()) {
        fileWriter.println(entry.getKey() + " " + entry.getValue().first.getClass().getName()
            + " " + entry.getValue().second);
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
   *
   * @param inputFile berisi data word.
   */
  public void loadWord(String inputFile) {
    try {
      Scanner scanner = new Scanner(getClass().getResourceAsStream(inputFile));
      while (scanner.hasNextLine()) {
        //System.out.println(scanner.nextLine());
        word_bank.add(scanner.nextLine().toUpperCase());
      }
    } catch (Exception e) {
      System.out.println("File I/O error!");
    }
  }

  private void createDataFile() {
    InputStream is = null;
    OutputStream os = null;
    try {
      is = getClass().getResourceAsStream("/asset/template.txt");
      System.out.println("HERE");
      File dir = new File(".ut");
      dir.mkdir();
      File file = new File(DATA_PATH);
      file.createNewFile();
      os = new FileOutputStream(file);
      byte[] buffer = new byte[1024];
      int length;
      while ((length = is.read(buffer)) > 0) {
        os.write(buffer, 0, length);
      }
      is.close();
      os.close();
      loadData(DATA_PATH);
    } catch (IOException e) {
      e.printStackTrace();
      System.exit(3);
    }
  }
}
