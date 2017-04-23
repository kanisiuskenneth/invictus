package model.goods;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by sylviajuliana on 23-Apr-17.
 */
class ShieldTest {
  @Test
  void getId() {
    Shield s = new Shield();
    assertEquals(14, s.getId());
  }

  @Test
  void getPrice() {
    Shield s = new Shield();
    assertEquals(0, s.getPrice());
  }

  @Test
  void getDescription() {
    Shield s = new Shield();
    assertEquals("prevents the health points from reducing for 10 seconds.", s.getDescription());
  }

  @Test
  void buy() {

  }

}