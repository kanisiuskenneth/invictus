package controller;

/**
 * File: java
 * Author: 13515033 - Andika Kusuma
 */

import model.game.GameModel;
import model.main.MainModel;
import model.player.Player;
import model.word.Word;
import util.Pair;
import view.GameView;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Kelas GameController untuk mengatur kerja game
 */
public class GameController {
  public GameModel gameModel;

  public GameController() {
    gameModel = new GameModel();
  }

  /**
   * Prosedur useItem untuk menggunakan item pada saat game
   *
   * @param id id item yang akan digunakan
   */
  public void useItem(int id) {
    // masih belum
  }
  
  public void addWord() {
    String content = MainModel.word_bank.get(gameModel.random.nextInt(MainModel.word_bank.size()));
    while (gameModel.mapOfThread.containsKey(content)) {
      content = MainModel.word_bank.get(gameModel.random.nextInt(MainModel.word_bank.size()));
    }
    Word newWord = new Word(content);
    SwingWorker<Void, Void> worker = null;
    //
    //worker = gameModel.viewWord(newWord, worker);
    //
    // masih ada bug nyangkut di atas gatau kenapa
    int positionX = gameModel.random.nextInt(1000);
    int positionY = -20; // y position dari paling atas
    newWord.setPosition(new Pair(positionX, positionY));
    worker = new SwingWorker<Void, Void>() {
      @Override
      protected Void doInBackground() throws Exception {
        while (!isCancelled()) {
          try {
            Thread.sleep(100);
          } catch (Exception e) {
            System.out.println("");
          }
          newWord.setPosition(new Pair(newWord.getPosition().first, newWord.getPosition().second + 2));
          if (newWord.getPosition().second > 500) {
            //gameModel.mapOfThread.get(newWord.getContent()).cancel(true);
            //gameModel.mapOfThread.remove(newWord.getContent());
            reduceHealth();
            cancel(true);
          }
        }
        return null;
      }

      @Override
      protected void done() {

      }
    };
    worker.execute();
    gameModel.mapOfThread.put(newWord, worker);
    System.out.println("ADD DARI CONTROLLER" + gameModel.mapOfThread.size());
  }

  public void deleteWord(String content, boolean typed) {
    content = content.toUpperCase();
    Word word = null;
    for (Map.Entry<Word, SwingWorker<Void, Void>> entry : gameModel.mapOfThread.entrySet()) {
      if (entry.getKey().getContent().equals(content)) {
        word = entry.getKey();
        break;
      }
    }
    if (gameModel.mapOfThread.containsKey(word)) {
      word.getLabel().setText("");
      gameModel.mapOfThread.get(word).cancel(true);
      gameModel.mapOfThread.remove(word);
      if (typed) {
        addScore(10 * content.length());
      } else {
        reduceHealth();
      }
    }
  }

  public void reduceHealth() {
    gameModel.player.reducedHealth();
  }

  public void addScore(int score) {
    gameModel.player.increaseScore(score);
  }
}
