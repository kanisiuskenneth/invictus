package model.main;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * File: MainModelTest.java
 * Created by 13515063 - Kezia Suhendra.
 */
class MainModelTest {
  @Test
  void loadData() {
    MainModel main = new MainModel();
    main.loadData("data.txt");
    assertEquals(3, main.health_maximum);
    assertEquals(0, main.coin);
    assertEquals(1.0, main.coin_multiplier);
    assertEquals(1.0, main.score_multiplier);
    assertEquals(new Integer(12), main.item.get(1).second);
    assertEquals(new Integer(10), main.item.get(5).second);
    assertEquals("KanisiusKenneth", main.leaderboard[0].first);
    assertEquals(new Integer(135), main.leaderboard[0].second);
  }

  @Test
  void loadWord() {
    MainModel main = new MainModel();
    main.loadWord("word.txt");
    assertEquals("ACERSECOMIC", main.word_bank.firstElement());
    assertEquals("ZYMOSIS", main.word_bank.lastElement());
  }

}