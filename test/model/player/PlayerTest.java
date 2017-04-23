package model.player;

import model.main.MainModel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by 13515063 - Kezia Suhendra.
 */
class PlayerTest {
  @Test
  void getCurrentHealth() {
    MainModel main = new MainModel();
    main.loadData("data.txt");
    Player me = new Player();
    assertEquals(5, me.getCurrentHealth());
  }

  @Test
  void getScore() {
    Player me = new Player();
    assertEquals(0, me.getScore());
  }

  @Test
  void reducedHealth() {
    MainModel main = new MainModel();
    main.loadData("data.txt");
    Player me = new Player();
    me.reducedHealth();
    assertEquals(4, me.getCurrentHealth());
  }

  @Test
  void increaseScore() {
    Player me = new Player();
    me.increaseScore(5);
    assertEquals(5, me.getScore());
  }

}