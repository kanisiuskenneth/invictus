package controller;

/**
 * File: java
 * Author: 13515033 - Andika Kusuma
 */

import java.awt.*;
import java.util.List;
import javax.swing.*;
import model.game.GameModel;
import model.main.MainModel;
import model.word.Word;
import util.Pair;
import view.GameOverView;
import view.MainFrame;

/**
 * Kelas GameController untuk mengatur kerja game.
 */
public class GameController {
  public GameModel gameModel;
  public Container gamePanel;
  SwingWorker<Void, Word> wordSpawner;
  SwingWorker<Void, Boolean> wordUpdater;

  /**
   * Constructore.
   * @param gameModel yang akan di kontrol.
   */
  public GameController(GameModel gameModel) {
    JLayeredPane gamePanel = gameModel.gamePanel;
    this.gameModel = gameModel;
    this.gamePanel = gamePanel;
    startGame();
  }

  /**
   * Memulai permainan.
   */
  public void startGame() {
    gameModel.mutex = false;
    refreshScreen();
    addWord();
    updateWord();

  }

  /**
   * Memperbaharui kata-kata yang akan keluar pada permainan.
   */
  private void updateWord() {
    wordUpdater = new SwingWorker<Void, Boolean>() {
      @Override
      protected Void doInBackground() throws Exception {
        while (!isCancelled()) {
          while (gameModel.mutex) {
          }
          ;
          gameModel.mutex = true;
          for (Word word : gameModel.wordSet) {
            word.setPosition(new Pair<>(word.getPosition().first, word.getPosition().second + 1));
            if (word.getPosition().second >= (gamePanel.getHeight() - 40)) {
              deleteWord(word, false);
            }
          }
          gamePanel.repaint();
          gameModel.mutex = false;
          publish(true);
          Thread.sleep(gameModel.updateTic);
        }
        return null;
      }

      @Override
      protected void process(List<Boolean> chunks) {
        if (chunks.get(chunks.size() - 1)) {
          while (gameModel.mutex) {
          }
          gameModel.mutex = true;
          for (Word word : gameModel.wordSet) {
            word.getLabel().setLocation(word.getPosition().first, word.getPosition().second);
          }
          gameModel.mutex = false;
        }
      }
    };
    wordUpdater.execute();

  }

  /**
   * Menambah kata-kata pada layar permainan.
   */
  public void addWord() {
    wordSpawner = new SwingWorker<Void, Word>() {
      @Override
      protected Void doInBackground() throws Exception {
        while (!isCancelled()) {
          while (gameModel.mutex) {
          }
          gameModel.mutex = true;
          Word temp = new Word(MainModel.word_bank.elementAt(
                  gameModel.random.nextInt(MainModel.word_bank.size())));
          temp.setPosition(new Pair(gameModel.random.nextInt(
                  gamePanel.getWidth() - 300) + 100, -20));
          gameModel.wordSet.add(temp);
          publish(temp);
          System.out.print("Word Spawned");
          gameModel.mutex = false;
          Thread.sleep(gameModel.spawnTic);
        }
        return null;
      }

      @Override
      protected void process(List<Word> chunks) {
        Word word = chunks.get(chunks.size() - 1);
        JLabel temp = word.getLabel();
        temp.setSize(500, 50);
        temp.setLocation(word.getPosition().first, word.getPosition().second);
        temp.setForeground(Color.WHITE);
        temp.setFont(new Font("Courier New", Font.BOLD, 24));
        gamePanel.add(temp);
        temp.setVisible(true);
        gamePanel.setVisible(true);
        MainFrame.mainframe.setVisible(true);
        System.out.println(temp.getText());
      }

      @Override
      protected void done() {
      }
    };
    wordSpawner.execute();

  }

  /**
   * Menghilangkan kata-kata yang ada pada layar setelah diketikkan.
   * @param word kata yang akan dihapus dari layar.
   * @param typed mengecek apakah kata sudah diketik atau belum.
   */
  public void deleteWord(Word word, boolean typed) {
    SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run() {
        gamePanel.remove(word.getLabel());
        word.getLabel().setVisible(false);
        gameModel.wordSet.remove(word);
        if (!typed) {
          if (!gameModel.shieldFlag) {
            reduceHealth();
          }
          if (gameModel.player.getCurrentHealth() == 0) {
            stopGame();
          }
        } else {
          addScore(word.getContent().length() * 10);
        }
        gameModel.updateHealth();
        gameModel.updateScore();
      }
    });
  }

  /**
   * Menghentikan permainan.
   */
  private void stopGame() {
    SwingWorker<Void, Void> stopper = new SwingWorker<Void, Void>() {
      @Override
      protected Void doInBackground() throws Exception {
        wordSpawner.cancel(true);
        wordUpdater.cancel(true);
        gameModel.wordSet.clear();
        return null;
      }

      @Override
      protected void done() {
        new GameOverView(gameModel);
      }
    };
    stopper.execute();
  }

  /**
   * Mengurangi hati dari pemain jika word gagal diketikkan.
   */
  public void reduceHealth() {
    gameModel.player.reduceHealth();
  }

  /**
   * Menambahkan skor seiring dengan berjalannya permainan.
   * @param score yang akan ditambahkan.
   */
  public void addScore(int score) {
    gameModel.player.increaseScore(score);
  }

  /**
   * Kondisi menunggu mutex atau keadaan aman agar tidak terjadi deadlock sebelum di delete.
   * @param content kata yang akan di delete.
   */
  public void attemptToDeleteWord(String content) {
    SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run() {
        while (gameModel.mutex) {
        }
        gameModel.mutex = true;
        System.out.println("Attempt to delete " + content);
        for (Word word : gameModel.wordSet) {
          if (word.getContent().toLowerCase().equals(content.toLowerCase())) {
            System.out.println("Word Deleted");
            deleteWord(word, true);
          }
        }

        gameModel.mutex = false;
      }
    });
  }

  /**
   * Mengubah warna huruf dari kata yang prefixnya sama dengan kata yang ada di input field.
   */
  public void refreshScreen() {
    SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run() {
        while (gameModel.mutex) {
        }
        gameModel.mutex = true;
        for (Word word : gameModel.wordSet) {
          String currString = gameModel.field.getText();
          int idx = getIndexPrefix(currString, word.getContent());
          String newLabel = "<html><font color =green>"
                  + word.getContent().substring(0, idx + 1) + "</font>"
                  + word.getContent().substring(idx + 1);
          if (!word.getLabel().getText().equals(newLabel)) {
            word.getLabel().setText(newLabel);
          }

        }
        gamePanel.repaint();
        gameModel.mutex = false;
      }
    });
  }

  /**
   * Menggunakan item yang dimiliki.
   * @param id dari item yang akan digunakan.
   */
  public void useItem(String id) {
    if (!gameModel.itemFlag) {
      gameModel.itemFlag = true;
      while (gameModel.mutex) {
      }
      gameModel.mutex = true;
      try {
        int idItem = Integer.parseInt(id);
        if (MainModel.item.get(idItem).second > 0) {
          System.out.println("Use item " + id);
          MainModel.item.get(idItem).first.use(gameModel);
        }
      } catch (Exception e) {
        gameModel.itemFlag = false;
      }
      gameModel.mutex = false;
    }
  }

  /**
   * Mendapatkan indeks dari longest common prefix.
   * @param firstString sad.
   * @param secondString sa.
   * @return indeks dari longest common prefix.
   */
  private int getIndexPrefix(String firstString, String secondString) {
    if (firstString.length() > secondString.length()) {
      return -1;
    } else {
      if (firstString.equals(secondString.substring(0, firstString.length()))) {
        return firstString.length() - 1;
      } else {
        return -1;
      }
    }
  }

}
