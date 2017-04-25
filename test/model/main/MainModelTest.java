package model.main;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by 13515063 - Kezia Suhendra.
 */
class MainModelTest {
  @Test
  void loadData() {
    MainModel main = new MainModel();
    main.loadData("data.txt");
    assertEquals(5, main.health_maximum);
    assertEquals(0, main.coin);
    /*assertEquals(new Integer(1), main.item.firstElement().first);
    assertEquals(new Integer(0), main.item.firstElement().second);
    assertEquals(new Integer(4), main.item.lastElement().first);
    assertEquals(new Integer(3), main.item.lastElement().second);*/
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