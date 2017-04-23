package model.goods;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by sylviajuliana on 23-Apr-17.
 */
class PotionTest {
  @Test
  void getId() {
    Potion p = new Potion();
    assertEquals(12, p.getId());
  }

  @Test
  void getPrice() {
    Potion p = new Potion();
    assertEquals(0, p.getPrice());
  }

  @Test
  void getDescription() {
    Potion p = new Potion();
    assertEquals("stop all of the words on the screen for 10 seconds.", p.getDescription());
  }

  @Test
  void buy() {

  }

}