package model.goods;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by sylviajuliana on 23-Apr-17.
 */
class FreezeSpellTest {
  @Test
  void getId() {
    FreezeSpell fs = new FreezeSpell();
    assertEquals(11, fs.getId());
  }

  @Test
  void getPrice() {
    FreezeSpell fs = new FreezeSpell();
    assertEquals(0, fs.getPrice());
  }

  @Test
  void getDescription() {
    FreezeSpell fs = new FreezeSpell();
    assertEquals("stop all of the words on the screen for 10 seconds.", fs.getDescription());
  }

  @Test
  void buy() {

  }

}