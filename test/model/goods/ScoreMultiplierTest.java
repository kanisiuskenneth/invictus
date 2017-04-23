package model.goods;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by sylviajuliana on 23-Apr-17.
 */
class ScoreMultiplierTest {
  @Test
  void getId() {
    ScoreMultiplier sm = new ScoreMultiplier();
    assertEquals(21, sm.getId());
  }

  @Test
  void getPrice() {
    ScoreMultiplier sm = new ScoreMultiplier();
    assertEquals(0, sm.getPrice());
  }

  @Test
  void getDescription() {
    ScoreMultiplier sm = new ScoreMultiplier();
    assertEquals("increase the scores multiplier by 0.1 from the base multiplier.", sm.getDescription());
  }

  @Test
  void buy() {

  }

}