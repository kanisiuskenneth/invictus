package model.goods;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * File: LightningSpellTest.java
 * Created by 13515063 - Kezia Suhendra.
 */
class LightningSpellTest {
  @Test
  void getId() {
    LightningSpell ls = new LightningSpell();
    assertEquals(4, ls.getId());
  }

  @Test
  void getPrice() {
    LightningSpell ls = new LightningSpell();
    assertEquals(100, ls.getPrice());
  }

  @Test
  void getDescription() {
    LightningSpell ls = new LightningSpell();
    assertEquals("destroy all of the words on the screen.", ls.getDescription());
  }

}