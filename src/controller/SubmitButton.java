package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

import view.GameView;

/**
 * File: SubmitButton.java
 * Author: 13515033 - Andika Kusuma
 */

public class SubmitButton implements ActionListener, KeyListener {

  private JTextField inputText;
  private GameView gameView;

  public SubmitButton(GameView gameView, JTextField textField) {
    inputText = textField;
    this.gameView = gameView;
  }

  @Override
  public void actionPerformed(ActionEvent submitClicked) {
    gameView.deleteWord(inputText.getText(), true);
    inputText.setText("");
  }

  @Override
  public void keyPressed(KeyEvent e) {
    System.out.println("TEST");
    if (e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_SPACE) {
      gameView.deleteWord(inputText.getText(), true);
      inputText.setText("");
    }

  }

  @Override
  public void keyReleased(KeyEvent arg0) {

  }

  @Override
  public void keyTyped(KeyEvent arg0) {

  }
}