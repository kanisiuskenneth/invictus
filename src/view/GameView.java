package view;

import controller.GameController;
import controller.ImageLoader;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import model.game.GameModel;


/**
 * File: GameView.java
 * Author: 13515008 - Kanisius Kenneth Halim
 */

/**
 * Kelas GameView.
 */
class GameView {

  private GameController gameController;
  private final GameModel gameModel;
  private final JPanel mainPanel;

  /**
   * Constructor.
   */
  public GameView() {
    gameModel = new GameModel();
    gameModel.menupanel = MainFrame.mainframe.getContentPane();
    mainPanel = new JPanel();
    MainFrame.mainframe.setContentPane(mainPanel);
    mainPanel.setLayout(new BorderLayout());
    mainPanel.setBackground(MainFrame.DARK_GRAY);
    mainPanel.setSize(MainFrame.width, MainFrame.height);
    addTopPanel();
    addMiddlePanel();
    addBottomPanel();
    mainPanel.setVisible(true);
    mainPanel.repaint();
    MainFrame.mainframe.setVisible(true);

    gameModel.field.requestFocus();
    gameModel.field.addKeyListener(new KeyListener() {
      @Override
      public void keyTyped(KeyEvent e) {

      }

      @Override
      public void keyReleased(KeyEvent e) {
        gameModel.field.setText(gameModel.field.getText().toUpperCase());
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
          gameModel.field.setText("");
        }
        gameController.refreshScreen();
      }

      @Override
      public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE || e.getKeyCode() == KeyEvent.VK_ENTER) {
          String buffer = gameModel.field.getText();
          gameModel.field.setText("");
          try {
            int id = Integer.parseInt(buffer);
            itemLabelMap.get(id).setText("x" + (MainModel.item.get(id).second - 1));
            gameController.useItem(id + "");
          } catch (Exception ex) {
            gameController.attemptToDeleteWord(buffer);
          }
        }
      }

    });
    gameController = new GameController(gameModel);
  }

  /**
   * Menambahkan panel pada bagian atas dari layar.
   */
  private void addTopPanel() {

    JPanel topPanel = new JPanel();
    topPanel.setLayout(new BorderLayout());
    topPanel.setBackground(MainFrame.DARK_GRAY);
    int logoHeight = (MainFrame.height - 600) / 2;
    int logoWidth =
        logoHeight * ImageLoader.gameBanner.getWidth() / ImageLoader.gameBanner.getHeight();
    JLabel logo = new JLabel(
        new ImageIcon(ImageLoader.gameBanner
            .getScaledInstance(logoWidth, logoHeight, Image.SCALE_DEFAULT)));
    topPanel.add(logo, BorderLayout.NORTH);

    topPanel.add(gameModel.healthLabel, BorderLayout.WEST);
    topPanel.add(gameModel.scoreLabel, BorderLayout.EAST);
    mainPanel.add(topPanel, BorderLayout.NORTH);
  }

  /**
   * Menambahkan panel pada bagian tengah layar.
   */
  private void addMiddlePanel() {
    JPanel middlePanel = new JPanel();
    JPanel mediatorPanel = new JPanel();
    mediatorPanel.setBackground(MainFrame.DARK_GRAY);
    mediatorPanel.setLayout(null);
    middlePanel.setBackground(MainFrame.DARK_GRAY);
    middlePanel.setLayout(new BorderLayout());
    middlePanel.add(mediatorPanel, BorderLayout.CENTER);
    gameModel.gamePanel = new JLayeredPane();
    gameModel.gamePanel.setVisible(true);
    gameModel.gamePanel.setSize(MainFrame.widthToPx(80), 500);
    gameModel.gamePanel.setBackground(new Color(35, 35, 35));
    gameModel.gamePanel.setOpaque(true);
    gameModel.healthLabel.setForeground(Color.WHITE);
    gameModel.healthLabel.setFont(new Font("Serif", Font.PLAIN, 30));
    gameModel.healthLabel.setBorder(new EmptyBorder(0, 30, 30, 0));
    gameModel.scoreLabel.setForeground(Color.WHITE);
    gameModel.scoreLabel.setFont(new Font("Serif", Font.PLAIN, 30));
    gameModel.scoreLabel.setBorder(new EmptyBorder(0, 0, 30, 30));
    mediatorPanel.add(gameModel.gamePanel);
    JLabel leftPadder = new JLabel(new ImageIcon(
        ImageLoader.SPACER.getScaledInstance(MainFrame.widthToPx(10), 1000, Image.SCALE_FAST)));
    leftPadder.setBackground(MainFrame.DARK_GRAY);
    middlePanel.add(leftPadder, BorderLayout.WEST);
    mainPanel.add(middlePanel, BorderLayout.CENTER);

  }

  /**
   * Menambahkan panel pada bagian bawah dari layar.
   */
  private void addBottomPanel() {
    JPanel bottomPanel = new JPanel();
    mainPanel.add(bottomPanel, BorderLayout.SOUTH);
    bottomPanel.setBackground(MainFrame.DARK_GRAY);
    bottomPanel.setLayout(new BorderLayout());
    gameModel.field = new JTextField();
    gameModel.field.setOpaque(false);
    gameModel.field.setBackground(null);
    gameModel.field.setBorder(null);
    gameModel.field.setHorizontalAlignment(SwingConstants.CENTER);
    gameModel.field.setFont(new Font("Courier New", Font.PLAIN, 30));
    gameModel.field.setBorder(new MatteBorder(2, 0, 2, 0, Color.WHITE));
    gameModel.field.setForeground(Color.WHITE);
    bottomPanel.add(gameModel.field, BorderLayout.NORTH);
  }
}
