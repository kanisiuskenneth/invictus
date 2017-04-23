package model.game;

import controller.SubmitButton;
import model.player.Player;
import model.word.Word;
import util.Pair;
import view.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Random;

/**
 * File: GameModel.java
 * Author: 13515033 - Andika Kusuma
 */

public class GameModel {
  public Player player;
  public Random random;
  public HashMap<Word, SwingWorker<Void, Void>> mapOfThread;

  public GameModel() {
    player = new Player();
    mapOfThread = new HashMap<Word, SwingWorker<Void, Void>>();
    random = new Random();
  }
}
