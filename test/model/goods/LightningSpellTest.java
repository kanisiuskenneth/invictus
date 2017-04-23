package model.goods;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by sylviajuliana on 23-Apr-17.
 */
class LightningSpellTest {
  @Test
  void getId() {
    LightningSpell ls = new LightningSpell();
    assertEquals(13, ls.getId());
  }

  @Test
  void getPrice() {
    LightningSpell ls = new LightningSpell();
    assertEquals(0, ls.getPrice());
  }

  @Test
  void getDescription() {
    LightningSpell ls = new LightningSpell();
    assertEquals("destroy all of the words on the screen.", ls.getDescription());
  }

  @Test
  void buy() {

  }

}