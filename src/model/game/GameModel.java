package model.game;

import controller.SubmitButton;
import model.player.Player;
import model.word.Word;
import util.Pair;
import view.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

/**
 * File: GameModel.java
 * Author: 13515033 - Andika Kusuma
 */

public class GameModel {
  public Player player;
  public Random random;
  public HashSet<Word> wordSet;

  public GameModel() {
    wordSet = new HashSet<Word>();
    player = new Player();
    random = new Random();
  }
}
