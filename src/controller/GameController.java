package controller;

/**
 * File: GameController.java
 * Author: 13515033 - Andika Kusuma
 */

import model.player.Player;
import model.word.Word;
import view.GameView;

import javax.swing.*;
import java.util.Vector;

/**
 * Kelas GameController untuk mengatur kerja game
 */
public class GameController {
    private Player player;
    private Vector<Word> list_of_words;
    private GameView game_view;

    public GameController() {
        player = new Player();
        list_of_words = new Vector<Word>();
        game_view = new GameView();
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
        Word new_word = new Word("JING");
        list_of_words.add(new_word);
        game_view.viewWord(new_word);
    }

    public void startGame() {
        while (true) {
            try
            {
                Thread.sleep(1000);
            } catch (Exception e)
            {

            }
            addWord();
        }
    }
}
