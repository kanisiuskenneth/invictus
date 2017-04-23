package model.goods;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by sylviajuliana on 23-Apr-17.
 */
class SlowSpellTest {
  @Test
  void getId() {
    SlowSpell ss = new SlowSpell();
    assertEquals(10, ss.getId());
  }

  @Test
  void getPrice() {
    SlowSpell ss = new SlowSpell();
    assertEquals(0, ss.getPrice());
  }

  @Test
  void getDescription() {
    SlowSpell ss = new SlowSpell();
    assertEquals("decrease the speed of the words by 0.5.", ss.getDescription());
  }

  @Test
  void buy() {

  }

}