package model.goods;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * File: ShieldTest.java
 * Created by 13515063 - Kezia Suhendra.
 */
class ShieldTest {
  @Test
  void getId() {
    Shield s = new Shield();
    assertEquals(5, s.getId());
  }

  @Test
  void getPrice() {
    Shield s = new Shield();
    assertEquals(75, s.getPrice());
  }

  @Test
  void getDescription() {
    Shield s = new Shield();
    assertEquals("prevents the health points from reducing for 10 seconds.", s.getDescription());
  }

}