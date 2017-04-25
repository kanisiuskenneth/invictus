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
    assertEquals(3, MainModel.health_maximum);
    assertEquals(0, MainModel.coin);
    assertEquals(1.0, MainModel.coin_multiplier);
    assertEquals(1.0, MainModel.score_multiplier);
    assertEquals(new Integer(12), MainModel.item.get(1).second);
    assertEquals(new Integer(10), MainModel.item.get(5).second);
    assertEquals("KanisiusKenneth", MainModel.leaderboard[0].first);
    assertEquals(new Integer(135), MainModel.leaderboard[0].second);
  }

  @Test
  void loadWord() {
    MainModel main = new MainModel();
    main.loadWord("word.txt");
    assertEquals("ACERSECOMIC", MainModel.word_bank.firstElement());
    assertEquals("ZYMOSIS", MainModel.word_bank.lastElement());
  }

}