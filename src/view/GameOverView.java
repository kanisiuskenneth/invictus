package view;

import controller.ImageLoader;
import model.game.GameModel;
import model.main.MainModel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * File: GameOverView.java
 * Author: 13515008 - Kanisius Kenneth Halim.
 */

/**
 * Kelas GameOverView.
 */
public class GameOverView {
  Container old;
  GameModel gameModel;
  JPanel currentPanel;
  long score = Math.round(gameModel.player.getScore() * MainModel.score_multiplier);
  long coin = Math.round(gameModel.player.getScore() * MainModel.coin_multiplier / 100);

  public GameOverView(GameModel gameModel) {
      old = MainFrame.mainframe.getContentPane();
      this.gameModel = gameModel;
      currentPanel = new JPanel();
      currentPanel.setLayout(new BorderLayout());
      currentPanel.setSize(MainFrame.width, MainFrame.height);
      currentPanel.setBackground(MainFrame.DARK_GRAY);
      MainFrame.mainframe.setContentPane(currentPanel);
      score = Math.round(gameModel.player.getScore() * MainModel.score_multiplier);;
      coin = Math.round(gameModel.player.getScore() * MainModel.coin_multiplier / 100);
      MainFrame.mainframe.setVisible(true);



  }
  private void addHeader() {
      int headWidth = MainFrame.widthToPx(60);
      int head_height = headWidth * ImageLoader.gameoverBanner.getHeight() /
          ImageLoader.gameoverBanner.getWidth();
      JLabel head_banner = new JLabel(new ImageIcon(
          ImageLoader.gameoverBanner.getScaledInstance(headWidth, head_height, Image.SCALE_DEFAULT)));
      head_banner.setBorder(new EmptyBorder(30, 0, 0, 0));
      currentPanel.add(head_banner, BorderLayout.NORTH);
  }
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
      JTextField enterNameField = new JTextField();
      enterNameField.setFont(new Font("Serif", Font.BOLD, 40));
      enterNameField.setHorizontalAlignment(SwingConstants.CENTER);
      enterNameField.setOpaque(false);
      enterNameField.setForeground(Color.WHITE);
      enterNamePanel.setBorder(new EmptyBorder(30, 0, 100, 0));
      enterNameField.setBorder(new MatteBorder(2, 0, 2, 0, Color.WHITE));
      enterNamePanel.setBackground(MainFrame.DARK_GRAY);

      JPanel bottomPanel = new JPanel();

      bottomPanel.setBackground(MainFrame.DARK_GRAY);
      bottomPanel.setLayout(new BorderLayout());
      JButton back = new JButton(new ImageIcon(ImageLoader.backButton.getScaledInstance(
          backWidth, backHeight, Image.SCALE_DEFAULT
      )));

      currentPanel.repaint();
      enterNameField.requestFocus();
      enterNamePanel.add(enterNameField, BorderLayout.SOUTH);

      bottomPanel.setBorder(new EmptyBorder(0, 0, 60, 0));
      bottomPanel.add(back, BorderLayout.SOUTH);
      currentPanel.add(bottomPanel, BorderLayout.SOUTH);
      back.addActionListener(new ActionListener() {
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
                      }
                  }
                  MainModel.leaderboard[i].first = name;
                  MainModel.leaderboard[i].second = (int) score;
              }
              MainModel.saveData();
              currentPanel.removeAll();
              MainFrame.mainframe.remove(currentPanel);
              MainFrame.mainframe.setContentPane(gameModel.menupanel);
          }
      });
      if (score > MainModel.leaderboard[4].second) {
          bottomPanel.add(enterNamePanel, BorderLayout.NORTH);
      } else {
          bottomPanel.add(bottomDummy, BorderLayout.NORTH);
      }
      back.setBorder(BorderFactory.createEmptyBorder());
      back.setContentAreaFilled(false);

  }
  private JLabel displayLabel(String text) {
    JLabel label = new JLabel(text);
    label.setFont(new Font("Helvetica", Font.BOLD, 40));
    label.setForeground(Color.WHITE);
    return label;
  }

  public void close() {
    currentPanel.removeAll();
    MainFrame.mainframe.remove(currentPanel);
    MainFrame.mainframe.setContentPane(old);
  }
}
