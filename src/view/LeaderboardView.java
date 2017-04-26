package view;

import controller.ImageLoader;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.main.MainModel;

/**s
 * File: LeaderboardView.java
 * Author: 13515008 - Kanisius Kenneth Halim.
 */

/**
 * Kelas LeaderboardView.
 */
class LeaderboardView {
  private final Container old;
  private final JPanel currentPanel;

  /**
   * Constructor.
   */
  public LeaderboardView() {
    old = MainFrame.mainframe.getContentPane();
    currentPanel = new JPanel();
    currentPanel.setLayout(new BorderLayout());
    currentPanel.setSize(MainFrame.width, MainFrame.height);
    currentPanel.setBackground(MainFrame.DARK_GRAY);
    MainFrame.mainframe.setContentPane(currentPanel);

    ImageIcon spacer = new ImageIcon(ImageLoader.SPACER.getScaledInstance(MainFrame.widthToPx(25),
        MainFrame.heightToPx(100), Image.SCALE_DEFAULT));
    currentPanel.add(new JLabel(spacer), BorderLayout.WEST);
    currentPanel.add(new JLabel(spacer), BorderLayout.EAST);
    addBanner();
    addBackButton();
    printLeaderboard();
    currentPanel.setVisible(true);
    MainFrame.mainframe.setVisible(true);
  }

  /**
   * Menambahkan banner pada bagian atas dari LeaderboardView.
   */
  private void addBanner() {
    int headWidth = MainFrame.widthToPx(60);
    int headHeight = headWidth * ImageLoader.leaderboardBanner.getHeight()
        / ImageLoader.leaderboardBanner.getWidth();
    JLabel headBanner = new JLabel(new ImageIcon(
        ImageLoader.leaderboardBanner
            .getScaledInstance(headWidth, headHeight, Image.SCALE_DEFAULT)));
    currentPanel.add(headBanner, BorderLayout.NORTH);
    headBanner.setVisible(true);
  }

  /**
   * Menambahkan leaderboard pada bagian konten dari LeaderboardView.
   */
  private void printLeaderboard() {
    JPanel items = new JPanel();
    currentPanel.add(items, BorderLayout.CENTER);
    items.setLayout(new GridLayout(8, 3));
    items.setBackground(MainFrame.DARK_GRAY);
    for (int i = 0; i < 5; i++) {
      JPanel itemPanel = new JPanel(new BorderLayout());
      JLabel itemLabelName = new JLabel(MainModel.leaderboard[i].first);
      JLabel itemLabelScore = new JLabel(MainModel.leaderboard[i].second.toString());
      itemPanel.setBackground(MainFrame.DARK_GRAY);
      itemLabelName.setFont(new Font("Courier New", Font.PLAIN, 40));
      itemLabelScore.setFont(new Font("Courier New", Font.PLAIN, 40));
      if (i == 0) {
        itemLabelName.setForeground(Color.GREEN);
        itemLabelScore.setForeground(Color.GREEN);

      } else {
        itemLabelName.setForeground(Color.WHITE);
        itemLabelScore.setForeground(Color.WHITE);
      }
      itemPanel.add(itemLabelName, BorderLayout.WEST);
      itemPanel.add(itemLabelScore, BorderLayout.EAST);
      items.add(itemPanel);
      itemPanel.setVisible(true);
    }
    items.setVisible(true);
  }

  /**
   * Menambahkan tombol untuk kembali ke menu.
   */
  private void addBackButton() {
    int backWidth = MainFrame.widthToPx(30);
    int backHeight = backWidth * ImageLoader.backButton.getHeight()
        / ImageLoader.backButton.getWidth();
    JButton back = new JButton(new ImageIcon(ImageLoader.backButton.getScaledInstance(
        backWidth, backHeight, Image.SCALE_DEFAULT
    )));

    back.setBorder(BorderFactory.createEmptyBorder());
    back.setContentAreaFilled(false);
    currentPanel.add(back, BorderLayout.SOUTH);
    currentPanel.setVisible(true);
    MainFrame.mainframe.setVisible(true);

    back.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        close();
      }
    }
    );
  }

  /**
   * Menutup LeaderboardView.
   */
  private void close() {
    currentPanel.removeAll();
    MainFrame.mainframe.remove(currentPanel);
    MainFrame.mainframe.setContentPane(old);
  }
}

