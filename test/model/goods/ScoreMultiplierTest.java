package model.goods;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * File: ScoreMultiplierTest.java
 * Created by 13515063 - Kezia Suhendra.
 */
class ScoreMultiplierTest {
  @Test
  void getId() {
    ScoreMultiplier sm = new ScoreMultiplier();
    assertEquals(7, sm.getId());
  }

  @Test
  void getPrice() {
    ScoreMultiplier sm = new ScoreMultiplier();
    assertEquals(80, sm.getPrice());
  }

  @Test
  void getDescription() {
    ScoreMultiplier sm = new ScoreMultiplier();
    assertEquals("increase the scores multiplier by 0.1 from the base multiplier.", sm.getDescription());
  }

}