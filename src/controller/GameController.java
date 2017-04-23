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
import view.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

/**
 * Kelas GameController untuk mengatur kerja game
 */
public class GameController {
  private int updateTic = 15;
  private int spawnTic = 1;
  public GameModel gameModel;
  public Container gamePanel;
  public GameController(GameModel gameModel, JLayeredPane gamePanel) {
    this.gameModel = gameModel;
    this.gamePanel = gamePanel;
    startGame();
  }

  public void startGame() {
    addWord();
    updateWord();
  }

  private void updateWord() {
    SwingWorker<Void, Boolean> wordUpdater = new SwingWorker<Void, Boolean>() {
      @Override
      protected Void doInBackground() throws Exception {
        while (!isCancelled()) {
          for(Word word : gameModel.wordSet) {
            word.setPosition(new Pair<>(word.getPosition().first,word.getPosition().second+1));
          }
          System.out.print("Word Updated");
          publish(true);
          Thread.sleep(1000/updateTic);
        }
        return null;
      }

      @Override
      protected void process(List<Boolean> chunks) {
        if(chunks.get(chunks.size()-1)) {
          for(Word word : gameModel.wordSet) {
            word.getLabel().setLocation(word.getPosition().first,word.getPosition().second);
          }
        }
      }
    };
    wordUpdater.execute();
  }

  public void addWord() {

    SwingWorker<Void, Word> wordSpawner = new SwingWorker<Void, Word>() {
      @Override
      protected Void doInBackground() throws Exception {
        while (!isCancelled()) {
          Word temp = new Word(MainModel.word_bank.elementAt(gameModel.random.nextInt(MainModel.word_bank.size())));
          temp.setPosition(new Pair(gameModel.random.nextInt(gamePanel.getWidth()-50),-10));
          gameModel.wordSet.add(temp);
          publish(temp);
          System.out.println("Word Spawned");
          Thread.sleep(1000/spawnTic);
        }
        return null;
      }
      @Override
      protected void process(List<Word> chunks) {
        Word word = chunks.get(chunks.size()-1);
        JLabel temp = word.getLabel();
        temp.setSize(100,30);
        temp.setLocation(word.getPosition().first,word.getPosition().second);
        temp.setForeground(Color.WHITE);
        gamePanel.add(temp);
        temp.setVisible(true);
        gamePanel.setVisible(true);
        MainFrame.mainframe.setVisible(true);
        System.out.print(temp.getText());
      }
    };
    wordSpawner.execute();

  }

  public void deleteWord(String content, boolean typed) {

  }

  public void reduceHealth() {
    gameModel.player.reducedHealth();
  }

  public void addScore(int score) {
    gameModel.player.increaseScore(score);
  }
}
