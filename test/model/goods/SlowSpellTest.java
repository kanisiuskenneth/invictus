package model.goods;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by 13515063 - Kezia Suhendra.
 */
class SlowSpellTest {
  @Test
  void getId() {
    SlowSpell ss = new SlowSpell();
    assertEquals(1, ss.getId());
  }

  @Test
  void getPrice() {
    SlowSpell ss = new SlowSpell();
    assertEquals(65, ss.getPrice());
  }

  @Test
  void getDescription() {
    SlowSpell ss = new SlowSpell();
    assertEquals("decrease the speed of the words by 0.5.", ss.getDescription());
  }

}