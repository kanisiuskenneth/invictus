package view;

import controller.ImageLoader;
import model.game.GameModel;
import model.main.MainModel;
import util.Pair;


import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.border.MatteBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * File: GameOverView.java
 * Author: 13515008 - Kanisius Kenneth Halim.
 */

/**
 * Kelas GameOverView.
 */
public class GameOverView {
  GameModel gameModel;
  JPanel currentPanel;
  JTextField enterNameField;
  long score;
  long coin;
  private ActionListener saveAndQuit = new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
      if (score > MainModel.leaderboard[4].second) {
        String name = enterNameField.getText();
        int i = 4;
        while (i > 0) {
          if (score > MainModel.leaderboard[i - 1].second) {
            MainModel.leaderboard[i].first = MainModel.leaderboard[i - 1].first;
            MainModel.leaderboard[i].second = MainModel.leaderboard[i - 1].second;
            i--;
          } else {
            break;
          }
        }
        MainModel.leaderboard[i].first = name;
        MainModel.leaderboard[i].second = (int) score;
      }
      MainModel.saveData();
      MainFrame.mainframe.setContentPane(gameModel.menupanel);
    }
  };

  /**
   * Constructor
   *
   * @param gameModel GameModel yang telah selesai berjalan saat Constructor dipanggil
   */
  public GameOverView(GameModel gameModel) {
      this.gameModel = gameModel;
      currentPanel = new JPanel();
      currentPanel.setLayout(new BorderLayout());
      currentPanel.setSize(MainFrame.width, MainFrame.height);
      currentPanel.setBackground(MainFrame.DARK_GRAY);
      MainFrame.mainframe.setContentPane(currentPanel);
      score = Math.round(gameModel.player.getScore() * MainModel.score_multiplier);;
      coin = Math.round(gameModel.player.getScore() * MainModel.coin_multiplier / 100);
      addPadder();
      addHeader();
      displayScore();
      displayEnterNameForm();
      MainFrame.mainframe.setVisible(true);
      enterNameField.requestFocus();
  }

  /**
   * Menambahkan header game over pada layar.
   */
  private void addHeader() {
    int headWidth = MainFrame.widthToPx(60);
    int head_height = headWidth * ImageLoader.gameoverBanner.getHeight() /
        ImageLoader.gameoverBanner.getWidth();
    JLabel head_banner = new JLabel(new ImageIcon(
        ImageLoader.gameoverBanner.getScaledInstance(headWidth, head_height, Image.SCALE_DEFAULT)));
    head_banner.setBorder(new EmptyBorder(30, 0, 0, 0));
    currentPanel.add(head_banner, BorderLayout.NORTH);
  }

  /**
   * Menambahkan padder pada kiri dan kanan layar.
   */
  private void addPadder() {
    int dummyWidth = MainFrame.widthToPx(40);
    int dummyHeight = MainFrame.height;

    JLabel leftDummy = new JLabel(
        new ImageIcon(ImageLoader.SPACER.getScaledInstance(dummyWidth, dummyHeight, Image.SCALE_DEFAULT)));
    JLabel rightDummy = new JLabel(
        new ImageIcon(ImageLoader.SPACER.getScaledInstance(dummyWidth, dummyHeight, Image.SCALE_DEFAULT)));

    currentPanel.add(leftDummy, BorderLayout.WEST);
    currentPanel.add(rightDummy, BorderLayout.EAST);

  }

  /**
   * Menampilkan skor pada layar.
   */
  private void displayScore() {
    JPanel scorePanel = new JPanel();
    scorePanel.setLayout(new GridLayout(2, 2));
    JLabel scoreLabel = displayLabel("Score");
    JLabel scoreGet = displayLabel(": " + score);
    JLabel coinLabel = displayLabel("Coin");
    JLabel cointGet = displayLabel(":" + coin);
    scorePanel.add(scoreLabel);
    scorePanel.add(scoreGet);
    scorePanel.add(coinLabel);
    scorePanel.add(cointGet);
    scorePanel.setBackground(MainFrame.DARK_GRAY);
    currentPanel.add(scorePanel, BorderLayout.CENTER);
  }

  /**
   * Menampilkan textfield untuk menerima input dari pengguna.
   */
  private void displayEnterNameForm() {
    JLabel bottomDummy = new JLabel(
        new ImageIcon(ImageLoader.SPACER.getScaledInstance(100, 200, Image.SCALE_DEFAULT)));
    int backWidth = MainFrame.widthToPx(30);
    int backHeight = backWidth * ImageLoader.backButton.getHeight() / ImageLoader.backButton.getWidth();
    JPanel enterNamePanel = new JPanel();
    enterNamePanel.setLayout(new BorderLayout());
    int enterNameHeight = MainFrame.heightToPx(10);
    int enterNameWidth = 5 * enterNameHeight;
    JLabel enterNameLabel = new JLabel(new ImageIcon(
        ImageLoader.enterName.getScaledInstance(enterNameWidth, enterNameHeight, Image.SCALE_DEFAULT)));
    enterNamePanel.add(enterNameLabel, BorderLayout.NORTH);
    enterNameField = new JTextField();
    enterNameField.setFont(new Font("Serif", Font.BOLD, 40));
    enterNameField.setHorizontalAlignment(SwingConstants.CENTER);
    enterNameField.setOpaque(false);
    enterNameField.setForeground(Color.WHITE);
    enterNamePanel.setBorder(new EmptyBorder(30, 0, 100, 0));
    enterNameField.setBorder(new MatteBorder(2, 0, 2, 0, Color.WHITE));
    enterNameField.addActionListener(saveAndQuit);
    enterNamePanel.setBackground(MainFrame.DARK_GRAY);

    JPanel bottomPanel = new JPanel();

    bottomPanel.setBackground(MainFrame.DARK_GRAY);
    bottomPanel.setLayout(new BorderLayout());
    JButton back = new JButton(new ImageIcon(ImageLoader.backButton.getScaledInstance(
        backWidth, backHeight, Image.SCALE_DEFAULT
    )));

    currentPanel.repaint();
    enterNamePanel.add(enterNameField, BorderLayout.SOUTH);

    bottomPanel.setBorder(new EmptyBorder(0, 0, 60, 0));
    bottomPanel.add(back, BorderLayout.SOUTH);
    currentPanel.add(bottomPanel, BorderLayout.SOUTH);
    back.addActionListener(saveAndQuit);
    if (score > MainModel.leaderboard[4].second) {
      bottomPanel.add(enterNamePanel, BorderLayout.NORTH);
    } else {
      bottomPanel.add(bottomDummy, BorderLayout.NORTH);
    }
    back.setBorder(BorderFactory.createEmptyBorder());
    back.setContentAreaFilled(false);

  }

  /**
   * Menampilkan label pada scorepanel.
   *
   * @param text text yang akan ditampilkan.
   * @return Label yang telah terbentuk.
   */
  private JLabel displayLabel(String text) {
    JLabel label = new JLabel(text);
    label.setFont(new Font("Helvetica", Font.BOLD, 40));
    label.setForeground(Color.WHITE);
    return label;
  }

}
