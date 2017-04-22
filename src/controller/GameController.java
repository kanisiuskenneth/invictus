package controller;

/**
 * File: GameController.java
 * Author: 13515033 - Andika Kusuma
 */

import model.player.Player;
import model.word.Word;
import view.GameView;

import javax.swing.*;
import java.util.HashMap;

/**
 * Kelas GameController untuk mengatur kerja game
 */
public class GameController {
    private Player player;
    private GameView game_view;
    public HashMap<String, SwingWorker<Void, Void>> map_of_thread;

    public GameController() {
        player = new Player();
        game_view = new GameView();
        map_of_thread = new HashMap<String, SwingWorker<Void, Void>>();
        startGame();
    }
    /**
     * Prosedur useItem untuk menggunakan item pada saat game
     * @param id id item yang akan digunakan
     */
    public void useItem(int id){
        // masih belum
    }

    public void reduceHP(){
        player.reducedHealth();
    }

    public void addScore(int score) {
        player.increaseScore(score);
    }

    public void addWord() {
        //Word new_word = new Word("A");
        String str = "A";
        while (map_of_thread.containsKey(str)) {
            str = str + "A";
        }
        Word new_word = new Word("DIKAGANTENGBANGET");
        //harusnya ngeloop terus sampe content nya ga ada di map
        SwingWorker<Void, Void> worker = null;
        worker = game_view.viewWord(new_word, worker);
        map_of_thread.put(new_word.getContent(), worker);
    }

    public void deleteWord(String content) {
        if (map_of_thread.containsKey(content)) {
            map_of_thread.get(content).cancel(true);
            map_of_thread.remove(content);
        }
    }

    public void startGame() {
        while (true) {
            try
            {
                Thread.sleep(1000);
            } catch (Exception e)
            {

            }
            //deleteWord("AAAA");
            addWord();
        }
    }
}
