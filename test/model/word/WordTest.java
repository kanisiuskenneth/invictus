package model.word;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * File: WordTest.java
 * Created by 13515063 - Kezia Suhendra.
 */
class WordTest {
  @Test
  void getContent() {
    Word text = new Word("test");
    assertEquals("test", text.getContent());
  }

  @Test
  void getPosition() {
    Word text = new Word("test");
    text.setPosition(new util.Pair<Integer,Integer>(new Integer(3), new Integer(5)));
    assertEquals(3, (int)text.getPosition().first);
    assertEquals(5, (int)text.getPosition().second);
  }

  @Test
  void setPosition() {
    Word text = new Word("test");
    text.setPosition(new util.Pair<Integer,Integer>(new Integer(2), new Integer(4)));
    assertEquals(2, (int)text.getPosition().first);
    assertEquals(4, (int)text.getPosition().second);
  }

}