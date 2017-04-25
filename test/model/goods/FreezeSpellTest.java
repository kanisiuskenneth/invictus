package model.goods;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * File: FreezeSpellTest.java
 * Created by 13515063 - Kezia Suhendra.
 */
class FreezeSpellTest {
  @Test
  void getId() {
    FreezeSpell fs = new FreezeSpell();
    assertEquals(2, fs.getId());
  }

  @Test
  void getPrice() {
    FreezeSpell fs = new FreezeSpell();
    assertEquals(85, fs.getPrice());
  }

  @Test
  void getDescription() {
    FreezeSpell fs = new FreezeSpell();
    assertEquals("stop all of the words on the screen for 10 seconds.", fs.getDescription());
  }

}