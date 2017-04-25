package view;

import controller.GameController;
import controller.ImageLoader;
//import controller.SubmitButton;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import model.game.GameModel;
import model.goods.*;
import model.main.*;
import util.*;

/**
 * File: GameView.java
 * Author: 13515008 - Kanisius Kenneth Halim
 */

public class GameView {
  public GameController gameController;
  GameModel gameModel;
  private static int REFRESH_RATE = 60;
  private HashMap<Integer,JLabel> itemLabelMap;
  public GameView() {
    System.out.println("Starting game");
    gameModel = new GameModel();
    itemLabelMap = new HashMap<>();
    gameModel.gamePanel = new JLayeredPane();
    gameModel.gamePanel.setVisible(true);
    gameModel.gamePanel.setSize(MainFrame.widthToPx(80),500);
    gameModel.gamePanel.setBackground(new Color(35,35,35));
    gameModel.gamePanel.setOpaque(true);

    gameModel.menupanel = MainFrame.mainframe.getContentPane();
    JPanel mainPanel = new JPanel();
    mainPanel.setLayout(new BorderLayout());
    MainFrame.mainframe.setContentPane(mainPanel);
    mainPanel.setBackground(MainFrame.DARK_GRAY);
    mainPanel.setSize(MainFrame.width,MainFrame.height);

    JPanel topPanel = new JPanel();
    JPanel middlePanel = new JPanel();
    JPanel bottomPanel = new JPanel();
    JPanel mediatorPanel = new JPanel();
    mediatorPanel.setBackground(MainFrame.DARK_GRAY);
    mediatorPanel.setLayout(null);
    mediatorPanel.add(gameModel.gamePanel);
    middlePanel.setBackground(MainFrame.DARK_GRAY);
    middlePanel.setLayout(new BorderLayout());
    middlePanel.add(mediatorPanel,BorderLayout.CENTER);
    JLabel leftPadder = new JLabel(new ImageIcon(
        ImageLoader.SPACER.getScaledInstance(MainFrame.widthToPx(10),1000,Image.SCALE_FAST)));
    leftPadder.setBackground(MainFrame.DARK_GRAY);
    middlePanel.add(leftPadder,BorderLayout.WEST);

    gameController = new GameController(gameModel);

    topPanel.setLayout(new BorderLayout());
    topPanel.setBackground(MainFrame.DARK_GRAY);
    bottomPanel.setBackground(MainFrame.DARK_GRAY);
    int logo_height = (MainFrame.height-600)/2;
    int logo_width = logo_height* ImageLoader.gameBanner.getWidth()/ImageLoader.gameBanner.getHeight();
    JLabel logo = new JLabel(
        new ImageIcon(ImageLoader.gameBanner.getScaledInstance(logo_width,logo_height,Image.SCALE_DEFAULT)));
    topPanel.add(logo,BorderLayout.NORTH);

    gameModel.field = new JTextField();
    gameModel.field.setOpaque(false);
    gameModel.field.setBackground(null);
    gameModel.field.setBorder(null);
    gameModel.field.setHorizontalAlignment(SwingConstants.CENTER);
    gameModel.field.setFont(new Font("Courier New",Font.PLAIN,30));
    gameModel.healthLabel.setForeground(Color.WHITE);
    gameModel.healthLabel.setFont(new Font("Serif",Font.PLAIN,30));
    gameModel.healthLabel.setBorder(new EmptyBorder(0,30,30,0));
    gameModel.field.setBorder(new MatteBorder(2,0,2,0,Color.WHITE));
    gameModel.field.setForeground(Color.WHITE);
    gameModel.scoreLabel.setForeground(Color.WHITE);
    gameModel.scoreLabel.setFont(new Font("Serif",Font.PLAIN,30));
    gameModel.scoreLabel.setBorder(new EmptyBorder(0,0,30,30));

    topPanel.add(gameModel.healthLabel,BorderLayout.WEST);
    topPanel.add(gameModel.scoreLabel,BorderLayout.EAST);
    mainPanel.add(topPanel,BorderLayout.NORTH);

    bottomPanel.setLayout(new BorderLayout());
    bottomPanel.add(gameModel.field,BorderLayout.NORTH);
    addItems(bottomPanel);
    mainPanel.add(middlePanel,BorderLayout.CENTER);
    mainPanel.add(bottomPanel,BorderLayout.SOUTH);
    gameModel.field.requestFocus();
    mainPanel.setVisible(true);
    MainFrame.mainframe.setVisible(true);

    gameModel.field.addKeyListener(new KeyListener() {
      @Override
      public void keyTyped(KeyEvent e) {

      }

      @Override
      public void keyReleased(KeyEvent e) {
        gameModel.field.setText(gameModel.field.getText().toUpperCase());
        if(e.getKeyCode() ==  KeyEvent.VK_SPACE)
          gameModel.field.setText("");
        gameController.refreshScreen();
      }

      @Override
      public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_SPACE || e.getKeyCode() == KeyEvent.VK_ENTER)
        {
          String buffer = gameModel.field.getText();
          gameModel.field.setText("");
          try {
            int id = Integer.parseInt(buffer);
            itemLabelMap.get(id).setText("x"+(MainModel.item.get(id).second-1));
            gameController.useItem(id+"");
          }
          catch (Exception ex) {
            gameController.attemptToDeleteWord(buffer);
          }
        }
      }

    });
  }


  private void addItems(JPanel bottomPanel) {
    HashMap<Integer, BufferedImage> imageMap = new HashMap<>();
    imageMap.put(1,ImageLoader.slowButton);
    imageMap.put(2,ImageLoader.freezeButton);
    imageMap.put(3, ImageLoader.potionButton);
    imageMap.put(4, ImageLoader.lightningButton);
    imageMap.put(5, ImageLoader.shieldButton);
    JPanel itemPanel = new JPanel();
    itemPanel.setBackground(MainFrame.DARK_GRAY);
    for(Pair<Items,Integer> iter : MainModel.item.values()) {
      itemPanel.add(addItemButton(iter.first,iter.second,imageMap.get(iter.first.getId())));
    }
    bottomPanel.add(itemPanel,BorderLayout.SOUTH);
    bottomPanel.repaint();
  }

  private JPanel addItemButton(Items currItem,int count, BufferedImage img) {
    JPanel item = new JPanel();
    item.setOpaque(false);
    item.setBackground(MainFrame.DARK_GRAY);
    JButton label = new JButton();
    label.setIcon(new ImageIcon(img.getScaledInstance(50,50,Image.SCALE_DEFAULT)));
    label.setText(""+currItem.getId());
    label.setHorizontalTextPosition(JLabel.CENTER);
    label.setFont(new Font("Sans Serif",Font.BOLD,25));
    label.setForeground(MainFrame.DARK_GRAY);
    label.setBackground(MainFrame.DARK_GRAY);
    JLabel countLabel = new JLabel("x"+ count);
    countLabel.setFont(new Font("Sans Serif",Font.BOLD,20));
    countLabel.setForeground(Color.WHITE);
    label.setBorder(BorderFactory.createEmptyBorder());
    label.setContentAreaFilled(false);
    item.add(label);
    item.add(countLabel);
    itemLabelMap.put(currItem.getId(),countLabel);
    label.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        countLabel.setText("x" + (MainModel.item.get(currItem.getId()).second-1));
        gameController.useItem(currItem.getId()+"");
        gameModel.field.requestFocus();
      }
    });
    return  item;
  }
}
