package model.main;

import model.goods.Items;
import util.Pair;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

/**
 * File: MainModel.java
 * Author: 13515033 - Andika Kusuma
 */

/**
 * Kelas MainModel.
 */
public class MainModel {
    static public int health_maximum;
    static public int coin;
    static public float coin_multiplier;
    static public float score_multiplier;
<<<<<<< HEAD
    static public Vector<Pair<Items, Integer>> item;
    static public Pair<String, Integer> leaderboard[];
=======
    private Vector<Pair<Items, Integer>> item;
    private Pair<String, Integer> leaderboard[];
>>>>>>> origin/develop
    static public Vector<String> word_bank;

    public MainModel(){
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

    public void loadData(String input_file) {
        try {
            Scanner scanner = new Scanner(new File(input_file));
            int i = 0;
            health_maximum = scanner.nextInt();
            coin = scanner.nextInt();
            coin_multiplier = scanner.nextFloat();
            score_multiplier = scanner.nextFloat();
            while (scanner.hasNextInt()) {
                int first_value = scanner.nextInt();
                int second_value = scanner.nextInt();
                item.add(new Pair(first_value, second_value));
            }
            scanner.next();
            while (scanner.hasNext()) {
                String first_value = scanner.next();
                int second_value = scanner.nextInt();
                leaderboard[i] = new Pair(first_value, second_value);
                i++;
            }
        } catch (IOException e)
        {
            System.out.println("File I/O error!");
        }
    }

    public void loadWord(String input_file) {
        try {
            Scanner scanner = new Scanner(new File(input_file));
            while (scanner.hasNextLine()) {
                //System.out.println(scanner.nextLine());
                word_bank.add(scanner.nextLine().toUpperCase());
            }
        } catch (IOException e)
        {
            System.out.println("File I/O error!");
        }
    }
}
