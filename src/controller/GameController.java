package controller;

/**
 * File: GameController.java
 * Author: 13515033 - Andika Kusuma
 */

import model.main.MainModel;
import model.player.Player;
import model.word.Word;
import view.GameView;

import javax.swing.*;
import java.util.HashMap;
import java.util.Random;

/**
 * Kelas GameController untuk mengatur kerja game
 */
public class GameController {
    private GameView game_view;

    public GameController() {
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

    public void startGame() {
        while (true) {
            try
            {
                Thread.sleep(1000);
            } catch (Exception e)
            {

            }
            game_view.addWord();
            // adding dummy word to prevent bugs
            try
            {
                Thread.sleep(10);
            } catch (Exception e)
            {

            }
            SwingWorker<Void, Void>  worker = null;
            worker = game_view.viewWord(new Word(""), worker);
        }
    }
}
